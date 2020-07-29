package oms.api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import oms.domain.Item;
import oms.domain.Order;
import orderutils.Pay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 13:20
 */
public class OrderSet {

    public static void orderSet(String orderNo,String shopId,List<Item> items) throws Exception {
        String url = "http://pangu.admintest.yang800.cn/docking/api/order/push";

        //组装订单项
        Order order = new Order(orderNo,shopId,items,10,20,5);

        //接口推送订单
        ApiClient client = new ApiClient("http://pangu.admintest.yang800.cn/docking/api/order/push");
        client.doPostJson(JSON.toJSON(order));
    }

}
