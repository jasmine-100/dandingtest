package casetest;

import domainout.BackDingdanZongshu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/17 15:17
 */
public class OrderDingdanCase {

    // 订单回执：新增申报成功
    @Test
    public void backAddOk() throws IOException {
        BackDingdanZongshu.declareAddOk(Data.declareOrderNo,Data.ebpCode,Data.ebcCode,"20200818150000001");
    }
    // 订单回执：逻辑校验通过
    @Test
    public void backLogic() throws IOException {
        BackDingdanZongshu.logicOk(Data.declareOrderNo,Data.ebpCode,Data.ebcCode,"20200818160000001");
    }

    // 常见的错误回执报文
    // 测试用例：总署回执--支付企业不一致(申报终止,可重推)
    @Test
    public void errCompany() throws IOException {
        BackDingdanZongshu.errorCompany(Data.declareOrderNo,Data.ebpCode,Data.ebcCode,"20200818130000001");
    }
}
