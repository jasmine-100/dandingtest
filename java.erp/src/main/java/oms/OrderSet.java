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
        OrderDTO order = new OrderDTO(orderNo,items,"SF",expressNo,"V2","8ce310a0407cc30b0163d11b7628942a");

        ApiClient.doPostJson(Data.OrderUrl,null,null,order);
    }

}
