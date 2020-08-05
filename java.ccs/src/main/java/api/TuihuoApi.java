package api;

import domainout.BackTuiHuo;
import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 退货--回执海关报文
 * @Date : Created in 2020/8/4 15:12
 */
public class TuihuoApi {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";
    // 此项要配置，不要改
    static String agentCode = "330766K00W";


    @Test
    public void order() throws Exception {
        // 取退货单列表的退货单号，去掉TH
        String orderNo = "20080517300210";

        // 回执：地址不详
//        BackTuiHuo.backAddressError(orderNo,ebpCode,ebcCode);
        // 回执：待人工审核
//        BackTuiHuo.backWaitExamine(orderNo,ebpCode,ebcCode);
        // 回执：海关放行
        BackTuiHuo.backPass(orderNo,ebpCode,ebcCode,agentCode);
    }

}
