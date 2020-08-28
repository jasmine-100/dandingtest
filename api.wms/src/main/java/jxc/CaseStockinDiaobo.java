package jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 无批次商品
 * @Date : Created in 2020/8/28 16:10
 */
public class CaseStockinDiaobo {
    // 入库单编号
    String orderId = "ET20200828170603514384";
    // 入库商品sku
    String sku = "sku08281647";

    @Test
    public void diaobo() throws Exception {
        BackStockin.backDiaobo(orderId,sku,1000,1,"","","","ZP",0);
    }
    @Test
    public void diaobos() throws Exception {
        for(int i=1;i<6;i++){
            BackStockin.backDiaobo(orderId,sku,200,i,"","","","ZP",1);
            Thread.sleep(1000);
        }
    }

    @Test
    public void indiaoboBatch() throws Exception {
        BackStockin.backDiaobo(orderId,sku,1000,1,"20200811","2020-08-11 10:00:50","2025-08-11 10:00:50","CP",0);
    }
    @Test
    public void indiaoboBatchs() throws Exception {
        for(int i=1;i<6;i++){
            BackStockin.backDiaobo(orderId,sku,200,i,"20200811","2020-08-11 10:00:50","2025-08-11 10:00:50","ZP",1);
            Thread.sleep(1000);
        }
    }

}
