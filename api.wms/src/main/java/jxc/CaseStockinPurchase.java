package jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 无批次商品
 * @Date : Created in 2020/8/28 16:10
 */
public class CaseStockinPurchase {
    // 入库单编号
    String orderId = "ET20200828191514536705";
    // 入库商品sku
    String sku = "SKU08281752";

    @Test
    public void inPurchase() throws Exception {
        BackStockin.backPurStockin(orderId,sku,1000,1,"","","","ZP",0);
    }

    @Test
    public void inPurchase11() throws Exception {
        for(int i=1;i<6;i++){
            BackStockin.backPurStockin(orderId,sku,200,i,"","","","ZP",1);
            Thread.sleep(1000);
        }
    }

    @Test
    public void inPurchaseBatch() throws Exception {
        BackStockin.backPurStockin(orderId,sku,10000,1,"20200811","2020-08-11 10:00:50","2025-08-11 10:00:50","ZP",0);
    }
    @Test
    public void inPurchaseBatch1() throws Exception {
        for(int i=1;i<6;i++){
            BackStockin.backPurStockin(orderId,sku,200,i,"20200811","2020-08-11 10:00:50","2025-08-11 10:00:50","ZP",1);
            Thread.sleep(1000);
        }
    }

}
