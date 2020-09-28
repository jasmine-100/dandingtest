package api;

import domainout.BackTax;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 回执汇总或作废税金报文
 * @Date : Created in 2020/8/6 14:45
 */
public class TaxApi {

    // 清单号
    String invtNo = "QD20200821180548";

    // 已放行申报单：汇总税金
    @Test
    public void taxTotal() throws IOException {
        // 已汇总
        BackTax.backTaxTotal(invtNo,"20200821120000102");
    }

    // 已退货或撤单的申报单：作废税金
    @Test
    public void taxCancel() throws IOException {
        // 已作废
        BackTax.backTaxCancel(invtNo,"20200821150000102");
    }

}
