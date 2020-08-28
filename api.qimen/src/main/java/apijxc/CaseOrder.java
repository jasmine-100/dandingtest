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
    String sku = "sku08281705";
    String batchCode = "";
    // 入库数量
    int num = 1000;

    @Test
    public void stockin() throws Exception {
        OrderStockin.orderPurchase(sku,num,orderno);
    }
    @Test
    public void tuihuo() throws Exception {
        OrderStockin.orderTuihuo(sku,num,orderno);
    }
    @Test
    public void diaoboIn() throws Exception {
        OrderStockin.orderDiaobo(sku,num,orderno);
    }

    @Test
    public void deliver() throws Exception {
        OrderStockout.deliverOrder(orderno,shopNick,sku,batchCode,num);
    }
    @Test
    public void outbound() throws Exception {
        OrderStockout.outboundOrder(orderno,shopNick,sku,batchCode,num);
    }
    @Test
    public void diaoboOut() throws Exception {
        OrderStockout.diaoboOrder(orderno,shopNick,sku,batchCode,num);
    }

}
