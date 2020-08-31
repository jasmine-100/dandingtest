package qimen.jxccase;

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
    int num = 3000;

    // 退货入库单：无批次、一次全部回传
    @Test
    public void stockin() throws Exception {
        OrderStockin.orderTuihuo(Data.sku,num,orderno);
    }
    @Test
    public void backWhole() throws Exception {
        StockinModel.stockin("SOTHRKD","ET20200831144824119512",num);
    }
    // 退货入库单：无批次、多次回传
    @Test
    public void backMore() throws Exception {
        StockinModel.stockins("SOTHRKD","ET20200831144828370097",num);
    }

    // 退货入库单：无批次、一次全部回传
    @Test
    public void stockinBatch() throws Exception {
        OrderStockin.orderTuihuo(Data.skuBatch,num,orderno);
    }
    @Test
    public void backWholeBatch() throws Exception {
        StockinModel.stockinBatch("SOTHRKD","",num);
    }
    // 退货入库单：无批次、多次回传
    @Test
    public void backMoreBatch() throws Exception {
        StockinModel.stockinBatchs("SOTHRKD","",num);
    }


}
