package oms.api;

import client.ApiClient;
import oms.domain.Item;
import oms.domain.Order;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 13:20
 */
public class OrderSet extends Data {

    @Test
    public void orderSet(){
        //订单号
        String orderno = "JOS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        List<Item> items = new ArrayList<>();
        items.add(new Item("","OUT1612494414926",1,100));

        //组装订单项
        Order order = new Order(orderno,"869",items,10,20,5);

        //接口推送订单
        ApiClient.doPostJson(URL,null,null,order) ;
    }

}
