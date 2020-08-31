package qimen.jxccase;

import org.junit.jupiter.api.Test;
import wms.jxc.BackStockin;

/**
 * @Author： jasmine
 * @Description : 退货入库单
 * @Date : Created in 2020/8/28 16:10
 */
public class StockinModel {
    // 入库单编号
    static String orderId = "ET20200831092617464315";

    // 全部入库、有批次
    @Test
    public void backPurchaseBatch() throws Exception {
        stockinBatch("CGRKD",orderId);
    }
    // 多次入库、有批次
    @Test
    public void backPurchaseBatchs() throws Exception {
        stockinBatchs("CGRKD",orderId);
    }

    // 退货入库单回执
    // 全部入库、有批次
    @Test
    public void backTuihuoBatch() throws Exception {
        stockinBatch("SOTHRKD",orderId);
    }
    // 多次入库、有批次
    @Test
    public void backTuihuoBatchs() throws Exception {
        stockinBatchs("SOTHRKD",orderId);
    }

    // 调拨入库单回执
    // 全部入库、有批次
    @Test
    public void backDiaoboBatch() throws Exception {
        stockinBatch("DBRKD",orderId);
    }
    // 多次入库、有批次
    @Test
    public void backDiaoboBatchs() throws Exception {
        stockinBatchs("DBRKD",orderId);
    }


    public static void stockin(String billType,String orderId) throws Exception {
        // 无批次、全部入库
        BackStockin.backStockin(billType,orderId,Data.sku,2000,1,"","","","ZP",0);
    }

    public static void stockins(String billType,String orderId) throws Exception {
        // 无批次、多次入库
        BackStockin.backStockin(billType,orderId,Data.sku,400,1,"","","","ZP",1);
        BackStockin.backStockin(billType,orderId,Data.sku,400,2,"","","","CP",1);
        BackStockin.backStockin(billType,orderId,Data.sku,400,3,"","","","ZP",1);
        BackStockin.backStockin(billType,orderId,Data.sku,400,4,"","","","CP",1);
        Thread.sleep(1000);
        BackStockin.backStockin(billType,orderId,Data.sku,400,5,"","","","ZP",0);
    }

    public static void stockinBatch(String billType,String orderId) throws Exception {
        // 有批次、全部入库
        BackStockin.backStockin(billType, orderId, Data.skuBatch, 2000, 1, "20200812", "2020-08-11 10:00:50", "2025-08-11 10:00:50", "ZP", 0);
    }
    public static void stockinBatchs(String billType ,String orderId) throws Exception {
        // 有批次、多次入库
        BackStockin.backStockin(billType,orderId,Data.skuBatch,400,1,"20200813","2020-08-11 10:00:50","2021-08-11 10:00:50","ZP",1);
        BackStockin.backStockin(billType,orderId,Data.skuBatch,400,2,"20200815","2021-08-11 10:00:50","2025-08-11 10:00:50","CP",1);
        BackStockin.backStockin(billType,orderId,Data.skuBatch,400,3,"20200816","2019-08-11 10:00:50","2020-08-11 10:00:50","ZP",1);
        BackStockin.backStockin(billType,orderId,Data.skuBatch,400,4,"20200818","2020-08-11 10:00:50","2022-08-11 10:00:50","CP",1);
        Thread.sleep(1000);
        BackStockin.backStockin(billType,orderId,Data.skuBatch,400,5,"20200810","2020-08-11 10:00:50","2023-08-11 10:00:50","ZP",0);
    }

}
