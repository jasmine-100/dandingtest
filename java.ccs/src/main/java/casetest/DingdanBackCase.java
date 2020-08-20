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

    // 订单回执：新增申报成功
    @Test
    public void backAddOk() throws IOException {
        BackDingdanZongshu.declareAddOk(Data.orderno,Data.ebpCode,Data.ebcCode,"20200817150000001");
    }
    // 订单回执：逻辑校验通过
    @Test
    public void backLogic() throws IOException {
        BackDingdanZongshu.logicOk(Data.orderno,Data.ebpCode,Data.ebcCode,"20200817160000001");
    }

    // 失败的回执--口岸(口岸异常未处理，已总署为准)
    // 测试用例：验签失败
//    @Test
//    public void errorVertify() throws IOException {
//        BackDingdanKouan.errorEndorse(orderno,"2020-08-17");
//    }
//    // 测试用例：支付企业未备案
//    @Test
//    public void errorKouan2() throws IOException {
//        BackDingdanKouan.errorPayCompany(orderno,"2020-8-16");
//    }

    // 常见的错误回执报文
    // 测试用例：总署回执--支付企业不一致(申报终止,可重推)
    @Test
    public void errCompany() throws IOException {
        BackDingdanZongshu.errorCompany(Data.orderno,Data.ebpCode,Data.ebcCode,"20200818130000001");
    }

}
