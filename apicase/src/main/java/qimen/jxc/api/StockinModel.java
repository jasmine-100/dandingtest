package qimen.jxc.api;

import wms.jxc.BackStockin;

/**
 * @Author： jasmine
 * @Description : 退货入库单
 * @Date : Created in 2020/8/28 16:10
 */
public class StockinModel {

    public static void stockin(String billType,String orderId,int num) throws Exception {
        // 无批次、全部入库
        BackStockin.backStockin(billType,orderId,Data.sku,num,1,"","","","ZP",0);
    }

    public static void stockins(String billType,String orderId,int num) throws Exception {
        // 无批次、多次入库
        BackStockin.backStockin(billType,orderId,Data.sku,num/5,1,"","","","ZP",1);
        BackStockin.backStockin(billType,orderId,Data.sku,num/5,2,"","","","CP",1);
        BackStockin.backStockin(billType,orderId,Data.sku,num/5,3,"","","","ZP",1);
        BackStockin.backStockin(billType,orderId,Data.sku,num/5,4,"","","","CP",1);
        Thread.sleep(1000);
        BackStockin.backStockin(billType,orderId,Data.sku,num/5,5,"","","","ZP",0);
    }

    public static void stockinBatch(String billType,String orderId,int num) throws Exception {
        // 有批次、全部入库
        BackStockin.backStockin(billType, orderId, Data.skuBatch, num, 1, "20200812", "2020-08-11 10:00:50", "2025-08-11 10:00:50", "ZP", 0);
    }
    public static void stockinBatchs(String billType ,String orderId,int num) throws Exception {
        // 有批次、多次入库
        BackStockin.backStockin(billType,orderId,Data.skuBatch,num/5,1,"20200813","2020-08-11 10:00:50","2021-08-11 10:00:50","ZP",1);
        BackStockin.backStockin(billType,orderId,Data.skuBatch,num/5,2,"20200815","2021-08-11 10:00:50","2025-08-11 10:00:50","CP",1);
        BackStockin.backStockin(billType,orderId,Data.skuBatch,num/5,3,"20200816","2019-08-11 10:00:50","2020-08-11 10:00:50","ZP",1);
        BackStockin.backStockin(billType,orderId,Data.skuBatch,num/5,4,"20200818","2020-08-11 10:00:50","2022-08-11 10:00:50","CP",1);
        Thread.sleep(1000);
        BackStockin.backStockin(billType,orderId,Data.skuBatch,num/5,5,"20200810","2020-08-11 10:00:50","2023-08-11 10:00:50","ZP",0);
    }

}
