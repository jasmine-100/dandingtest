package api;

import domainout.BackTax;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 回执汇总或作废税金报文
 * @Date : Created in 2020/8/6 14:45
 */
public class TaxApi {

    // 已放行申报单：生成并汇总税金（已生成是海关内部的一个状态，对本系统没有影响）
    @Test
    public void taxTocal() throws IOException {
        // 清单号
        String invtNo = "QD20200807093049";

        // 已生成
        BackTax.backTaxCreate(invtNo,"20200806140610230");
        // 已汇总
        BackTax.backTaxTotal(invtNo,"20200807120000102");
    }

    // 已退货或撤单的申报单：生成并作废税金
    @Test
    public void taxCancel() throws IOException {
        // 清单号
        String invtNo = "QD20200807122029";

        // 已生成
        BackTax.backTaxCreate(invtNo,"20200806140610102");
        // 已作废
        BackTax.backTaxCancel(invtNo,"20200807140610102");
    }

}
