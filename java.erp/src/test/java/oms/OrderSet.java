package oms;

import client.ApiClient;
import oms.order.Item;
import oms.order.OrderDTO;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 新版OMS 内部下单接口
 * @Date : Created in 2021/01/06 14:08
 */
public class OrderSet extends Data {
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String orderNo = "JOS"+str;
    String expressNo = "SF"+str;
    List<Item> items = new ArrayList<>();

    @Test
    public void order1(){ // 哈哈科技的黑店
        items.add(new Item("SKU2101141536",null,"",50,1));//完税
//        items.add(new Item("SKU202101191448",null,"",50,1));//完税
//        items.add(new Item("SKU2001181133",null,"",50,3));//保税
//        items.add(new Item("SKU2101121328",null,"",30,2));//保税
        OrderDTO order = new OrderDTO(orderNo,items,"SF",expressNo,"V2",accessCode1);
//        OrderDTO order = new OrderDTO(orderNo,items,null,null,"V2",Data.accessCode1);

        ApiClient.doPostJson(OrderUrl,null,null,order);
    }

    @Test
    public void order2(){ // 小花花的花店
        items.add(new Item("SKU202101191103",null,"",50,1));//保税
//        OrderDTO order = new OrderDTO(orderNo,items,"SF",expressNo,"V2",Data.accessCode2);
        OrderDTO order = new OrderDTO(orderNo,items,null,expressNo,"V2",accessCode2);

        ApiClient.doPostJson(OrderUrl,null,null,order);
    }


}
