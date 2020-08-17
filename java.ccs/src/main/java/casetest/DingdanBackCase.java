package casetest;

import domainout.BackDingdan;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/17 15:17
 */
public class DingdanBackCase {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";

    static String orderno = "A0817152240";

    // 订单回执：逻辑校验通过
    @Test
    public void backLogic() throws IOException {
        BackDingdan.logicOk(orderno,ebcCode,ebcCode,"20200817150000001");
    }

    // 订单回执：新增申报成功
    @Test
    public void backAddOk() throws IOException {
        BackDingdan.declareAddOk(orderno,ebcCode,ebcCode,"20200817060000001");
    }

    // 订单回执：订单中的订购人姓名和身份证不匹配
    @Test
    public void backIdError() throws IOException {
        BackDingdan.backIDError(orderno,ebcCode,ebcCode,"20200817060000001");
    }

    // 订单回执：清单上的订购人姓名与订单上的订购人姓名不一致
    @Test
    public void backNameError() throws IOException {
        BackDingdan.backNameError(orderno,ebcCode,ebcCode,"20200817060000001");
    }

    // 订单回执：支付单支付金额与订单支付金额不一致
    @Test
    public void backMoneyError() throws IOException {
        BackDingdan.backMoneyError(orderno,ebcCode,ebcCode,"20200817060000001");
    }

    // 订单回执：清单表体商品项与订单表体商品项的项数不一致
    @Test
    public void backItemError() throws IOException {
        BackDingdan.backItemError(orderno,ebcCode,ebcCode,"20200817060000001");
    }
}
