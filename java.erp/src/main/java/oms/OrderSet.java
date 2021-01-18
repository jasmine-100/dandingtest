package oms;

import client.ApiClient;
import oms.dto.order.Item;
import oms.dto.order.OrderDTO;
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
public class OrderSet {

    @Test
    public void order(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String orderNo = "JOS"+str;
        String expressNo = "SF"+str;

        List<Item> items = new ArrayList<>();
        items.add(new Item("SKU2101141536","",50,1));
        OrderDTO order = new OrderDTO(orderNo,items,"sf",expressNo,"V2",Data.accessCode);
//        OrderDTO order = new OrderDTO(orderNo,items,null,null,"V2",Data.accessCode);

        ApiClient.doPostJson(Data.OrderUrl,null,null,order);
    }

}
