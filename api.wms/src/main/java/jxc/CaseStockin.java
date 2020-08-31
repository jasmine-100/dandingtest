package jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 退货入库单
 * @Date : Created in 2020/8/28 16:10
 */
public class CaseStockin {
    // 入库单编号
    static String orderId = "ET20200831092617464315";
    // 入库商品sku
    static String sku = "sku08310925";

    // 采购单回执
    // 全部入库、无批次
    @Test
    public void backPurchase() throws Exception {
        stockin("CGRKD");
    }
    //多次入库、无批次
    @Test
    public void backPurchases() throws Exception {
        stockins("CGRKD");
    }
    // 全部入库、有批次
    @Test
    public void backPurchaseBatch() throws Exception {
        stockinBatch("CGRKD");
    }
    // 多次入库、有批次
    @Test
    public void backPurchaseBatchs() throws Exception {
        stockinBatchs("CGRKD");
    }

    // 退货入库单回执
    // 全部入库、无批次
    @Test
    public void backTuihuo() throws Exception {
        stockin("SOTHRKD");
    }
    //多次入库、无批次
    @Test
    public void backTuihuos() throws Exception {
        stockins("SOTHRKD");
    }
    // 全部入库、有批次
    @Test
    public void backTuihuoBatch() throws Exception {
        stockinBatch("SOTHRKD");
    }
    // 多次入库、有批次
    @Test
    public void backTuihuoBatchs() throws Exception {
        stockinBatchs("SOTHRKD");
    }

    // 调拨入库单回执
    // 全部入库、无批次
    @Test
    public void backDiaobo() throws Exception {
        stockin("DBRKD");
    }
    //多次入库、无批次
    @Test
    public void backDiaobos() throws Exception {
        stockins("DBRKD");
    }
    // 全部入库、有批次
    @Test
    public void backDiaoboBatch() throws Exception {
        stockinBatch("DBRKD");
    }
    // 多次入库、有批次
    @Test
    public void backDiaoboBatchs() throws Exception {
        stockinBatchs("DBRKD");
    }

    // 无批次、全部入库
    public void stockin(String billType) throws Exception {
        BackStockin.backStockin(billType,orderId,sku,2000,1,"","","","ZP",0);
    }
    // 无批次、多次入库
    public void stockins(String billType) throws Exception {
        BackStockin.backStockin(billType,orderId,sku,400,1,"","","","ZP",1);
        BackStockin.backStockin(billType,orderId,sku,400,2,"","","","CP",1);
        BackStockin.backStockin(billType,orderId,sku,400,3,"","","","ZP",1);
        BackStockin.backStockin(billType,orderId,sku,400,4,"","","","CP",1);
        Thread.sleep(1000);
        BackStockin.backStockin(billType,orderId,sku,400,5,"","","","ZP",0);
    }

    // 有批次、全部入库
    public void stockinBatch(String billType) throws Exception {
        BackStockin.backStockin(billType,orderId,sku,2000,1,"20200812","2020-08-11 10:00:50","2025-08-11 10:00:50","ZP",0);
    }
    // 有批次、多次入库
    public void stockinBatchs(String billType) throws Exception {
        BackStockin.backStockin(billType,orderId,sku,400,1,"20200813","2020-08-11 10:00:50","2021-08-11 10:00:50","ZP",1);
        BackStockin.backStockin(billType,orderId,sku,400,2,"20200815","2021-08-11 10:00:50","2025-08-11 10:00:50","CP",1);
        BackStockin.backStockin(billType,orderId,sku,400,3,"20200816","2019-08-11 10:00:50","2020-08-11 10:00:50","ZP",1);
        BackStockin.backStockin(billType,orderId,sku,400,4,"20200818","2020-08-11 10:00:50","2022-08-11 10:00:50","CP",1);
        Thread.sleep(1000);
        BackStockin.backStockin(billType,orderId,sku,400,5,"20200810","2020-08-11 10:00:50","2023-08-11 10:00:50","ZP",0);
    }

}
