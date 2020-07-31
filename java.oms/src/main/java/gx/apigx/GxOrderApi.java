package gx.apigx;

import oms.api.OrderSet;
import oms.domain.Item;
import oms.domain.ShipBack;
import orderutils.DeclareOrder;
import orderutils.ListOrder;
import orderutils.Pay;
import orderutils.ShipOrder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description : 模拟OMS小B下单（大贸）
 * @Date : Created in 2020/7/27 14:51
 */
public class GxOrderApi {

    //订单号
    String orderno = "JOS2020073110";
    //jasmine12b的店铺id
    String shopId = "1046";

    //小B下单，调用OMS内部下单接口
    @Test
    public void orderSet() throws Exception {
        //组装商品项：下单之前小B需要映射和上架商品、补足库存
        List<Item> items = new ArrayList<>();
        items.add(new Item("","PDD04",10,1));
//        items.add(new Item("","PDD101",2,100));

        //组装并推送订单
        OrderSet.orderSet(orderno,shopId,items);
    }

    //推送海关支付信息
    @Test
    public void pushPayInfo() throws IOException {
        Pay.payInfoPush(orderno);
    }

    //推送订单回执
    @Test
    public void pushDeclareBack() throws IOException {
        //逻辑校验通过
        DeclareOrder.declareLogicPass(orderno);
        //新增申报成功
        DeclareOrder.declareSuccess(orderno);
    }

    //清单回执：海关放行
    @Test
    public void pushListBack() throws IOException {
//        ListOrder.listLogicPass(orderno);
//        ListOrder.listAddSuccess(orderno);
        ListOrder.listSuccess(orderno);
    }

    //推送运单回执
    @Test
    public void pushShipBack() throws IOException {
//        ShipOrder.shipBackPush(orderno);
//        ShipOrder.shipBackPush(orderno,"SF","SF"+new Random(999999),"2020-6-1");
        ShipOrder.shipBackPush(orderno,"HTKY","557017524547024","2020-6-1");
    }

}
