package oms.api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import oms.domain.Item;
import oms.domain.Order;
import orderutils.ShipOrder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : OMS接口：大贸订单推送--发货
 * @Date : Created in 2020/7/20 11:20
 */
public class OrderSetApiDamao {
    String orderNo = "JOS20200728150903";

    // 大贸订单
    @Test
    public void orderSet2() throws IOException {
        //组装商品列表
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("SPC1595921421330","",20,12));
//        items.add(new Item("SPC1595216228153","",5,10));

        //组装订单项
//        String orderNo = "JS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Order order = new Order(orderNo,"1026",items,10,20,5);

        //接口推送订单
        ApiClient.doPostJson("http://pangu.admintest.yang800.cn/docking/api/order/push",null,null,order);
    }

    //推送运单回执
    @Test
    public void pushShipBack() throws IOException {
        ShipOrder.shipBackPush(orderNo);
    }

}
