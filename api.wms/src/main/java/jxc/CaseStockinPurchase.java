package jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 采购入库单
 * @Date : Created in 2020/8/28 16:10
 */
public class CaseStockinPurchase {
    // 入库单编号
    String orderId = "ET20200828191514536705";
    // 入库商品sku
    String sku = "SKU08281752";

    // 无批次、全部入库
    @Test
    public void inPurchase() throws Exception {
        BackStockin.backPurStockin(orderId,sku,1000,1,"","","","ZP",0);
    }
    // 无批次、多次入库
    @Test
    public void inPurchase11() throws Exception {
        BackStockin.backPurStockin(orderId,sku,200,1,"","","","ZP",1);
        BackStockin.backPurStockin(orderId,sku,200,2,"","","","CP",1);
        BackStockin.backPurStockin(orderId,sku,200,3,"","","","ZP",1);
        BackStockin.backPurStockin(orderId,sku,200,4,"","","","CP",1);
        BackStockin.backPurStockin(orderId,sku,200,5,"","","","ZP",0);
    }

    // 有批次、全部入库
    @Test
    public void inPurchaseBatch() throws Exception {
        BackStockin.backPurStockin(orderId,sku,10000,1,"20200811","2020-08-11 10:00:50","2025-08-11 10:00:50","ZP",0);
    }
    // 有批次、部分入库
    @Test
    public void inPurchaseBatch1() throws Exception {
        BackStockin.backPurStockin(orderId,sku,200,1,"20200813","2020-08-11 10:00:50","2021-08-11 10:00:50","ZP",1);
        BackStockin.backPurStockin(orderId,sku,200,2,"20200815","2021-08-11 10:00:50","2025-08-11 10:00:50","CP",1);
        BackStockin.backPurStockin(orderId,sku,200,3,"20200816","2019-08-11 10:00:50","2020-08-11 10:00:50","ZP",1);
        BackStockin.backPurStockin(orderId,sku,200,4,"20200818","2020-08-11 10:00:50","2022-08-11 10:00:50","CP",1);
        BackStockin.backPurStockin(orderId,sku,200,5,"20200810","2020-08-11 10:00:50","2023-08-11 10:00:50","ZP",0);
    }

}
