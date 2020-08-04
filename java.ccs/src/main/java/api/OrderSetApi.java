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
import java.util.Random;

/**
 * @Author： jasmine
 * @Description : CCS 下单-申报订单-申报清单流程
 * @Date : Created in 2020/7/20 12:23
 */
public class OrderSetApi {

    String orderno = "JS"+new SimpleDateFormat("MMddHHmmss").format(new Date());

    /**
     * 步骤一：推送申报单
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void pushOrder() throws IOException, InterruptedException {
        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("NO0715J01",2,10));
        items.add(new Item("NO0715J02",6,11));
        items.add(new Item("NO0715J03",5,12));

        // 组装申报单
        Order order = new Order(orderno,"ZTO","Z"+new Random(999999),"jasRoute", items);

        ApiClient client = new ApiClient("http://ccs.backend.daily.yang800.com/xhr/order/submit");
        client.doPostJson(JSON.toJSON(order));
    }

    /**
     * 步骤二：订单申报回执
     */
    @Test
    public void dingdanBack() throws IOException {
        //订单回执成功
        BackDingdan.declareSuccess(orderno);
        BackDingdan.logicSuccess(orderno);
    }

    /**
     * 步骤三：清单申报回执
     * @throws IOException
     */
    @Test
    public void qingdanBack() throws IOException {
        // 取申报单的数据库id
        String orderno = "497465543217905665";

        BackQingDan.backPass(orderno);
        BackQingDan.backDeclareSuccess(orderno);
        BackQingDan.backLogicPass(orderno);
    }

}
