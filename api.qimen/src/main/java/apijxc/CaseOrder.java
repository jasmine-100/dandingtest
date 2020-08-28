package apijxc;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/28 16:11
 */
public class CaseOrder {
    //外部订单号，相同货主内唯一
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    //进销存存在的店铺名称
    String shopNick = "jasmine的小店";
    // 入库商品sku
    String sku = "sku08281737";
    String batchCode = "";

    // 采购入库单
    @Test
    public void purchase() throws Exception {
        OrderStockin.orderPurchase(sku,10000,orderno);
        System.out.println(orderno);
    }
    // 退货入库单
    @Test
    public void tuihuo() throws Exception {
        OrderStockin.orderTuihuo(sku,10000,orderno);
        System.out.println(orderno);
    }
    // 调拨入库单
    @Test
    public void diaoboIn() throws Exception {
        OrderStockin.orderDiaobo(sku,10000,orderno);
        System.out.println(orderno);
    }

    // 发货出库单
    @Test
    public void deliver() throws Exception {
        OrderStockout.deliverOrder(orderno,shopNick,sku,batchCode,10);
        System.out.println(orderno);
    }
    // 批发出库单
    @Test
    public void outbound() throws Exception {
        OrderStockout.outboundOrder(orderno,shopNick,sku,batchCode,10);
        System.out.println(orderno);
    }
    // 调拨出库单
    @Test
    public void diaoboOut() throws Exception {
        OrderStockout.diaoboOrder(orderno,shopNick,sku,batchCode,10);
        System.out.println(orderno);
    }

    // 取消c单和B单
    @Test
    public void cancel () throws Exception {
        OrderStockout.orderCancel("QM20200828193209369");
    }
}
