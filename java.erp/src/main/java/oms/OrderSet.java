package oms;

import client.ApiClient;
import oms.dto.Item;
import oms.dto.Order;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : ERP内部的新版OMS下单接口
 * @Date : Created in 2021/01/06 14:08
 */
public class OrderSet {

    @Test
    public void order(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String orderNo = "JOS"+str;
        String expressNo = "SF"+str;

        List<Item> items = new ArrayList<>();
        items.add(new Item("SKU2101141536","",10.5,1));
//        items.add(new Item("SKU202101111600","",21,1));
        Order order = new Order(orderNo,items,"SF",expressNo,"V2","8075d0d391d63805b6920cb67002599b");

        ApiClient.doPostJson(Data.OrderUrl,null,null,order);
    }

}
