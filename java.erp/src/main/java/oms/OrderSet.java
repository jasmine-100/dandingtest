package oms;

import client.ApiClient;
import oms.dto.Item;
import oms.dto.Order;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/12 14:08
 */
public class OrderSet {

    @Test
    public void order(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("sku2012121500","20201210",10.5,10));
        Order order = new Order("JOS2012121501",items,"ZTO","8956565656");

        ApiClient.doPostJson(Data.OrderUrl,null,null,order);
    }

}
