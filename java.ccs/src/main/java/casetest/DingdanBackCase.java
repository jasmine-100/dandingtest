package casetest;

import domainout.BackDingdanZongshu;
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

    static String orderno = "A108181312131";

    // 订单回执：新增申报成功
    @Test
    public void backAddOk() throws IOException {
        BackDingdanZongshu.declareAddOk(orderno,ebcCode,ebcCode,"20200817150000001");
    }

    // 订单回执：逻辑校验通过
    @Test
    public void backLogic() throws IOException {
        BackDingdanZongshu.logicOk(orderno,ebcCode,ebcCode,"20200817160000001");
    }

    // 以下为异常的订单回执
    @Test
    public void backError1() throws IOException {
        BackDingdanZongshu.modelZongshu(orderno,ebpCode,ebcCode,"100","[code:13035;Desc:支付企业不一致]","20200817170000001");
    }
    @Test
    public void backError2 () throws IOException {
        BackDingdanZongshu.modelZongshu(orderno,ebpCode,ebcCode,"-301020","验签失败","20200817180000001");
    }
//    @Test
//    public void backError3() throws IOException {
//        BackDingdan.function(orderno,ebpCode,ebcCode,"2","[code:22001;Desc:支付企业未备案]","20200817170000001");
//    }
//    @Test
//    public void backError4() throws IOException {
//        BackDingdan.function(orderno,ebpCode,ebcCode,"2","[code:22007;Desc:对应清单已放行]","20200817170000001");
//    }

//    // 订单回执：订单中的订购人姓名和身份证不匹配
//    @Test
//    public void backIdError() throws IOException {
//        BackDingdan.backIDError(orderno,ebcCode,ebcCode,"20200817060000001");
//    }
//
//    // 订单回执：清单上的订购人姓名与订单上的订购人姓名不一致
//    @Test
//    public void backNameError() throws IOException {
//        BackDingdan.backNameError(orderno,ebcCode,ebcCode,"20200817060000001");
//    }
//
//    // 订单回执：支付单支付金额与订单支付金额不一致
//    @Test
//    public void backMoneyError() throws IOException {
//        BackDingdan.backMoneyError(orderno,ebcCode,ebcCode,"20200817060000001");
//    }

}
