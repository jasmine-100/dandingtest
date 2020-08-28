package jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/28 18:11
 */
public class CaseStockout {
    String orderId = "OB20200828193537835345";
    String sku = "sku08281737";
    String batchCode = "";

    /**
     * C单和B单  出库回传
     * 只校验批次号，不校验效期
     * 只回传正品，不回传次品
      * @throws Exception
     */
    @Test
    public void deliver() throws Exception {
        BackStockout.backDeliver(orderId,sku,batchCode,9,"","","ZP");
    }

    @Test
    public void diaobo() throws Exception {
        BackStockout.backOutDiaobo(orderId,sku,batchCode,10,"","","ZP");
    }
}
