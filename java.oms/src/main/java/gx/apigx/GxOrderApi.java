package gx.apigx;

import oms.api.OrderSet;
import oms.domain.Item;
import oms.domain.ShipBack;
import orderutils.ShipOrder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 模拟OMS小B下单（大贸）
 * @Date : Created in 2020/7/27 14:51
 */
public class GxOrderApi {

    //订单号
    String orderno = "JOS2020072917";
    //jasmine12b的店铺id
    String shopId = "1026";

    //小B下单，调用OMS内部下单接口
    @Test
    public void orderSet() throws Exception {
        //组装商品项：下单之前小B需要映射和上架商品、补足库存
        List<Item> items = new ArrayList<>();
        items.add(new Item("","PDD103",1,500));
        items.add(new Item("","PDD101",2,100));

        //组装并推送订单
        OrderSet.orderSet(orderno,shopId,items);
    }

    //推送运单回执
    @Test
    public void pushShipBack() throws IOException {
//        ShipOrder.shipBackPush(orderno);
        ShipOrder.shipBackPush(orderno,"SF","SF9620054395412");
    }

}
