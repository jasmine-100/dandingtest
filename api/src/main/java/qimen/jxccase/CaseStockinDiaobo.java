package qimen.jxccase;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 9:54
 */
public class CaseStockinDiaobo {
    //外部订单号，相同货主内唯一
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 调拨入库单--无批次
    @Test
    public void diaoboIn() throws Exception {
        OrderStockin.orderDiaobo(Data.sku,2000,orderno);
        System.out.println(orderno);
    }
    @Test
    public void backWhole() throws Exception {
        StockinModel.stockin("DBRKD","");
    }
    @Test
    public void backMore() throws Exception {
        StockinModel.stockins("DBRKD","");
    }

    // 调拨入库单--有批次
    @Test
    public void diaoboInBatch() throws Exception {
        OrderStockin.orderDiaobo(Data.skuBatch,2000,orderno);
        System.out.println(orderno);
    }
    @Test
    public void backWholeBatch() throws Exception {
        StockinModel.stockinBatch("DBRKD","ET20200831103357724125");
    }
    @Test
    public void backMoreBatch() throws Exception {
        StockinModel.stockinBatchs("DBRKD","");
    }

}
