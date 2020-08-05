package api;

import domainout.BackChedan;
import domainout.BackTuiHuo;
import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 撤单--回执 流程
 * @Date : Created in 2020/8/4 17:58
 */
public class ChedanApi {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";
    // 此项要配置，不要改
    static String agentCode = "330766K00W";


    @Test
    public void order() throws Exception {
        // 取退货单列表的退货单号，去掉TH
        String orderNo = "2008051734000161";

//        BackChedan.backShenbao(orderNo,ebpCode,ebcCode,agentCode);

//        BackChedan.backLogicpass(orderNo,ebpCode,ebcCode,agentCode);

        BackChedan.backChedanSuccess(orderNo,ebpCode,ebcCode,agentCode);
    }
}
