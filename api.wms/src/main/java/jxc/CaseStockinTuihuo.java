package jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 无批次商品
 * @Date : Created in 2020/8/28 16:10
 */
public class CaseStockinTuihuo {
    // 入库单编号
    String orderId = "ET20200828165437488904";
    // 入库商品sku
    String sku = "sku08281548";

    @Test
    public void inTuihuo() throws Exception {
        BackStockin.backTuihuo(orderId,sku,100,1,"","","","ZP",0);
    }
    @Test
    public void inTuihuos() throws Exception {
        for(int i=1;i<6;i++){
            BackStockin.backTuihuo(orderId,sku,200,i,"","","","ZP",1);
            Thread.sleep(1000);
        }
    }

    @Test
    public void inTuihuoBatch() throws Exception {
        BackStockin.backTuihuo(orderId,sku,100,1,"20200811","2020-08-11 10:00:50","2025-08-11 10:00:50","CP",0);
    }
    @Test
    public void inTuihuoBatchs() throws Exception {
        BackStockin.backTuihuo(orderId,sku,200,1,"20200811","2020-08-11 10:00:50","2025-08-11 10:00:50","ZP",1);
        Thread.sleep(1000);
    }

}
