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
        StockinModel.stockin("SOTHRKD","ET20200831145744169685",num);
    }
    // 退货入库单：无批次、多次回传
    @Test
    public void backMore() throws Exception {
        StockinModel.stockins("SOTHRKD","ET20200831145748512006",num);
    }

    // 退货入库单：无批次、一次全部回传
    @Test
    public void stockinBatch() throws Exception {
        OrderStockin.orderTuihuo(Data.skuBatch,num,orderno);
    }
    @Test
    public void backWholeBatch() throws Exception {
        StockinModel.stockinBatch("SOTHRKD","ET20200831145811512470",num);
    }
    // 退货入库单：无批次、多次回传
    @Test
    public void backMoreBatch() throws Exception {
        StockinModel.stockinBatchs("SOTHRKD","ET20200831145813083469",num);
    }


}
