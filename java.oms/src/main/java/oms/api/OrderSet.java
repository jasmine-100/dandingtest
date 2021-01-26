package oms.api;

import client.ApiClient;
import oms.domain.Item;
import oms.domain.Order;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 13:20
 */
public class OrderSet {

    @Test
    public void orderSet(){
        //订单号
        String orderno = "JOS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        List<Item> items = new ArrayList<>();
        items.add(new Item("","OUT1600679279797",1,100));

        //组装订单项
        Order order = new Order(orderno,"916",items,10,20,5);

        //接口推送订单
        ApiClient.doPostJson(Data.URL,null,null,order) ;
    }

}
