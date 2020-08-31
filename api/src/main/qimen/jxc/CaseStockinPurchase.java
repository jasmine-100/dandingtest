package jxc;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/28 16:11
 */
public class CaseStockinPurchase {
    //外部订单号，相同货主内唯一
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 采购入库单
    @Test
    public void purchase() throws Exception {
        OrderStockin.orderPurchase(Data.sku,2000,orderno);
    }
    @Test
    public void backWhole() throws Exception {
        StockinModel.stockin("CGRKD","ET20200831104131285858");
    }
    @Test
    public void backMore() throws Exception {
        StockinModel.stockins("CGRKD","ET20200831114203575455");
    }

    // 采购入库单--有批次
    @Test
    public void purchaseBatch() throws Exception {
        OrderStockin.orderPurchase(Data.skuBatch,2000,orderno);
        System.out.println(orderno);
    }
    @Test
    public void backWholeBatch() throws Exception {
        StockinModel.stockinBatch("CGRKD","ET20200831104339558791");
    }
    @Test
    public void backMoreBatch() throws Exception {
        StockinModel.stockinBatchs("CGRKD","ET20200831114429438110");
    }
}
