package jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/28 18:11
 */
public class CaseStockout {
    String orderId = "OB20200828191813841443";
    String sku = "SKU08281752";
    String batchCode = "20200811";

    /**
     * 发货单和批发出库单回传
     * 只校验批次号，不校验效期
     * 只回传正品，不回传次品
      * @throws Exception
     */
    @Test
    public void deliver() throws Exception {
        BackStockout.backDeliver(orderId,sku,batchCode,9,"","","ZP");
    }

    @Test
    public void tuihuo() throws Exception {
        BackStockout.backOutDiaobo(orderId,sku,batchCode,10,"","","ZP");
    }
}
