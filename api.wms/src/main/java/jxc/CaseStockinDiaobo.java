package jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 无批次商品
 * @Date : Created in 2020/8/28 16:10
 */
public class CaseStockinDiaobo {
    // 入库单编号
    String orderId = "ET20200828180429279216";
    // 入库商品sku
    String sku = "SKU08281752";

    @Test
    public void diaobo() throws Exception {
        BackStockin.backDiaobo(orderId,sku,1000,1,"","","","ZP",0);
    }
    @Test
    public void diaobos() throws Exception {
        BackStockin.backDiaobo(orderId,sku,200,1,"","","","ZP",1);
        BackStockin.backDiaobo(orderId,sku,200,2,"","","","CP",1);
        BackStockin.backDiaobo(orderId,sku,200,3,"","","","ZP",1);
        BackStockin.backDiaobo(orderId,sku,200,4,"","","","CP",1);
        BackStockin.backDiaobo(orderId,sku,200,5,"","","","ZP",0);
    }

    @Test
    public void indiaoboBatch() throws Exception {
        BackStockin.backDiaobo(orderId,sku,1000,1,"20200811","2020-08-11 10:00:50","2025-08-11 10:00:50","ZP",0);
    }
    @Test
    public void indiaoboBatchs() throws Exception {
        BackStockin.backDiaobo(orderId,sku,200,1,"20200813","2020-08-11 10:00:50","2021-08-11 10:00:50","ZP",1);
        BackStockin.backDiaobo(orderId,sku,200,2,"20200815","2021-08-11 10:00:50","2025-08-11 10:00:50","CP",1);
        BackStockin.backDiaobo(orderId,sku,200,3,"20200816","2019-08-11 10:00:50","2020-08-11 10:00:50","ZP",1);
        BackStockin.backDiaobo(orderId,sku,200,4,"20200818","2020-08-11 10:00:50","2022-08-11 10:00:50","CP",1);
        BackStockin.backDiaobo(orderId,sku,200,5,"20200810","2020-08-11 10:00:50","2023-08-11 10:00:50","ZP",0);
    }

}
