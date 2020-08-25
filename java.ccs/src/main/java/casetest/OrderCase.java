package casetest;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import com.google.protobuf.Api;
import dao.BaseParam;
import domain.Item;
import domain.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description : 批量下单
 * @Date : Created in 2020/8/17 15:23
 */
public class OrderCase {

    // 批量下单
    @Test
    public void ordersSet() throws IOException {
        for(int i=0;i<5;i++){
            String str = new SimpleDateFormat("MMddHHmmss").format(new Date())+i;
            // 渠道订单号
            String outOrderno = "JC"+str;
            // 申报单号
            String declareOrderNo = "DC"+str;
            // 添加商品项
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("JHKY08241053","SKU08241053",3,9));
            items.add(new Item("JHKY08241046","SKU08241046",10,2));
            // 组装申报单
            Order order = new Order("xiaoyuer","小鱼儿",outOrderno,declareOrderNo,"SF",Data.logiticsNo,Data.routeCode,"","","", items);
            //接口：推送申报单
            new ApiClient(BaseParam.URL_ORDER).doPostJson(JSON.toJSON(order));
        }
    }

    // 单一下单
    @Test
    public void orderSet() throws Exception {
        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("pd1406","sku1406",3,10));
        // 组装申报单
        Order order = new Order("xiaoyuer","小鱼儿",Data.declareOrderNo,Data.declareOrderNo,"SF",Data.logiticsNo,Data.routeCode,"","","", items);
        //接口：推送申报单
        ApiClient.doPostJson(BaseParam.URL_ORDER,null,null,order);

    }

}
