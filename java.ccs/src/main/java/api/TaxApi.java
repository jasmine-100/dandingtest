package api;

import domainout.BackTax;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/6 14:45
 */
public class TaxApi {

    // 已放行申报单：生成并汇总税金
    @Test
    public void taxTocal() throws IOException {
        // 清单号
        String invtNo = "QD20200806144901";

        // 已生成
        BackTax.backTaxCreate(invtNo,"20200806140610230");
        // 已汇总
        BackTax.backTaxTotal(invtNo,"20200807140610230");
    }

    // 已退货或撤单的申报单：生成并作废税金
    @Test
    public void taxCancel() throws IOException {
        // 清单号
        String invtNo = "QD20200806151604";

        // 已生成
        BackTax.backTaxCreate(invtNo,"20200806140610230");
        // 已作废
        BackTax.backTaxCancel(invtNo,"20200807140610230");
    }

}
