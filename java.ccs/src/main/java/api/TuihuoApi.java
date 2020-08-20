package api;

import domainout.BackTax;
import domainout.BackTuiHuo;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 退货流程--回执海关放行
 * @Date : Created in 2020/8/4 15:12
 */
public class TuihuoApi {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";
    // 此项要配置，不要改
    static String agentCode = "330766K00W";

    // 取退货单列表的退货单号，去掉TH
    String orderNo = "20081916490225";

    // 回执：待人工审核
    @Test
    public void backExamine() throws Exception {
        BackTuiHuo.backExamine(orderNo,ebpCode,ebcCode,agentCode,"20200816070000001");
    }
    // 回执：放行
    @Test
    public void backPass() throws Exception {
        BackTuiHuo.backPass(orderNo,ebpCode,ebcCode,agentCode,"20200816080000001");
    }
    // 回执：税金作废
    @Test
    public void backTax() throws IOException {
        BackTax.backTaxCancel("","20200816090000001");
    }

    // 异常回执：地址不详
    @Test
    public void backFail() throws Exception {
        BackTuiHuo.backAddressError(orderNo,ebpCode,ebcCode,agentCode,"20200816080000001");
    }

}
