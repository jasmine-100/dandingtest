package jxc;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 9:53
 */
public class CaseStockinTuihuo {
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 退货入库单：无批次、一次全部回传
    @Test
    public void stockin() throws Exception {
        OrderStockin.orderTuihuo(Data.sku,2000,orderno);
    }
    @Test
    public void backWhole() throws Exception {
        OrderStockin.orderTuihuo(Data.sku,2000,orderno);

        StockinModel.stockin("SOTHRKD","");
    }
    // 退货入库单：无批次、多次回传
    @Test
    public void backMore() throws Exception {
        OrderStockin.orderTuihuo(Data.sku,2000,orderno);

        StockinModel.stockins("SOTHRKD","");
    }

    // 退货入库单：无批次、一次全部回传
    @Test
    public void stockinBatch() throws Exception {
        OrderStockin.orderTuihuo(Data.skuBatch,2000,orderno);
    }
    @Test
    public void backWholeBatch() throws Exception {
        StockinModel.stockinBatch("SOTHRKD","");
    }
    // 退货入库单：无批次、多次回传
    @Test
    public void backMoreBatch() throws Exception {
        StockinModel.stockinBatchs("SOTHRKD","");
    }


}
