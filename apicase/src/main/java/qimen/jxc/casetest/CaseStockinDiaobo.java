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
 * @Date : Created in 2020/8/31 9:54
 */
public class CaseStockinDiaobo {
    //外部订单号，相同货主内唯一
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    int num =3000;

    // 调拨入库单--无批次
    @Test
    public void diaoboIn() throws Exception {
        OrderStockin.orderDiaobo(Data.sku,num,orderno);
        System.out.println(orderno);
    }
    @Test
    public void backWhole() throws Exception {
        StockinModel.stockin("DBRKD","ET20200831145622855832",num);
    }
    @Test
    public void backMore() throws Exception {
        StockinModel.stockins("DBRKD","ET20200831145625701878",num);
    }

    // 调拨入库单--有批次
    @Test
    public void diaoboInBatch() throws Exception {
        OrderStockin.orderDiaobo(Data.skuBatch,num,orderno);
        System.out.println(orderno);
    }
    @Test
    public void backWholeBatch() throws Exception {
        StockinModel.stockinBatch("DBRKD","ET20200831145651744749",num);
    }
    @Test
    public void backMoreBatch() throws Exception {
        StockinModel.stockinBatchs("DBRKD","ET20200831145654080230",num);
    }

}
