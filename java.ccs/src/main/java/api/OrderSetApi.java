package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import com.sun.corba.se.spi.orb.ORBData;
import domainInner.Item;
import domainInner.Order;
import domainout.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : CCS内部接口--推送申报单、回执放行报文
 * @Date : Created in 2020/7/20 12:23
 */
public class OrderSetApi {

    @Test
    public void pushOrder() throws IOException, InterruptedException {

        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("NO0715J01",2,10));
        items.add(new Item("NO0715J02",6,11));
        items.add(new Item("NO0715J03",5,12));

        // 组装申报单
        String str = new SimpleDateFormat("MMddHHmmss").format(new Date());
        String orderno = "JS"+str;
        Order order = new Order(orderno,"ZTO","Z"+str,"jasRoute", items);

        ApiClient client = new ApiClient("http://ccs.backend.daily.yang800.com/xhr/order/submit");
        client.doPostJson(JSON.toJSON(order));
        Thread.sleep(2000);

        //订单回执成功
        BackDingdan.declareSuccess(orderno);
        BackDingdan.logicSuccess(orderno);

    }

    @Test
    public void qingdanBack() throws IOException {
        // 取申报单的数据库id
        String orderno = "497465543217905665";

        BackQingDan.backPass(orderno);
        BackQingDan.backDeclareSuccess(orderno);
        BackQingDan.backLogicPass(orderno);
    }

}
