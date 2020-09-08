package qimen.jxc.api;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import qimen.domain.Param;
import qimen.domain.stockin.EntryOrder;
import qimen.domain.stockin.OrderData;
import qimen.domain.stockin.OrderLine;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.Product;
import wms.domain.stockin.StockinData;
import wms.jxc.BaseParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/28 16:11
 */
public class CaseStockinPurchase {
    //外部订单号，相同货主内唯一
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    int num = 1000;

    // 采购入库单
    @Test
    public void purchase() throws Exception {
        OrderStockin.orderPurchase(Data.sku,num,orderno);
    }
    @Test
    public void backWhole() throws Exception {
        StockinModel.stockin("CGRKD","ET20200831173005442516",num);
    }
    @Test
    public void backMore() throws Exception {
        StockinModel.stockins("CGRKD","ET20200831171912571626",num);
    }

    // 采购入库单--有批次
    @Test
    public void purchaseBatch() throws Exception {
        OrderStockin.orderPurchase(Data.skuBatch,num,orderno);
        System.out.println(orderno);
    }
    @Test
    public void backWholeBatch() throws Exception {
        StockinModel.stockinBatch("CGRKD","ET20200831172257025460",1000);
    }
    @Test
    public void backMoreBatch() throws Exception {
        StockinModel.stockinBatchs("CGRKD","ET20200831145557945514",num);
    }
}
