package oms.api;

import client.ApiClient;
import oms.domain.Item;
import oms.domain.Order;
import orderutils.DeclareOrder;
import orderutils.ListOrder;
import orderutils.Pay;
import orderutils.ShipOrder;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : OMS接口：保税订单推送--推送支付单--订单回执--清单回执--运单回执
 * @Date : Created in 2020/7/20 11:20
 */
public class OrderSetApiBaoshui {
//    String orderNo = "JS20200803175010";
    String orderNo = "JS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

    // 保税订单
    @Test
    public void orderSet() {
        //组装商品列表
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("SPC1596433033872","",2,1));

        Order order = new Order(orderNo,"916",items,10,20,5);

        ApiClient.doPostJson(Data.URL,null,null,order) ;

    }
    //推送海关支付信息
    @Test
    public void pushPayInfo() {
        Pay.payInfoPush(orderNo);
    }


    //推送订单回执
    @Test
    public void pushDeclareBack() {
        //逻辑校验通过
        DeclareOrder.declareLogicPass(orderNo);
        //新增申报成功
        DeclareOrder.declareSuccess(orderNo);
    }

    //推送清单回执
    @Test
    public void pushListBack() {
        ListOrder.listLogicPass(orderNo);
        ListOrder.listAddSuccess(orderNo);
        ListOrder.listSuccess(orderNo);
    }
//    @Test
//    public void pushListBack() throws IOException {
//        ListOrder.listPayinfoNotExist(orderNo);
//    }

    //推送运单回执
    @Test
    public void pushShipBack(){
        ShipOrder.shipBackPush(orderNo);
    }


}
