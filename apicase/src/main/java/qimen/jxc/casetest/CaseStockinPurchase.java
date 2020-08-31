package qimen.jxc.casetest;

import org.junit.jupiter.api.Test;
import qimen.jxc.api.Data;
import qimen.jxc.api.OrderStockin;
import qimen.jxc.api.StockinModel;

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
    int num = 3000;

    // 采购入库单
    @Test
    public void purchase() throws Exception {
        OrderStockin.orderPurchase(Data.sku,num,orderno);
    }
    @Test
    public void backWhole() throws Exception {
        StockinModel.stockin("CGRKD","ET20200831145503103282",num);
    }
    @Test
    public void backMore() throws Exception {
        StockinModel.stockins("CGRKD","ET20200831145509490829",num);
    }

    // 采购入库单--有批次
    @Test
    public void purchaseBatch() throws Exception {
        OrderStockin.orderPurchase(Data.skuBatch,num,orderno);
        System.out.println(orderno);
    }
    @Test
    public void backWholeBatch() throws Exception {
        StockinModel.stockinBatch("CGRKD","ET20200831145554208577",num);
    }
    @Test
    public void backMoreBatch() throws Exception {
        StockinModel.stockinBatchs("CGRKD","ET20200831145557945514",num);
    }
}
