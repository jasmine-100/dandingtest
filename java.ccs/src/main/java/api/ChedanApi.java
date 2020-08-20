package api;

import domainout.BackChedan;
import domainout.BackTax;
import domainout.BackTuiHuo;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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

    // 取撤单列表的撤单申报编号，去掉CD
    String orderNo = "2008061450000167";


    // 撤单回执：申报
    @Test
    public void backShenbao() throws IOException {
        BackChedan.backShenbao(orderNo,ebpCode,ebcCode,agentCode,"20200806160000001");
    }
    // 撤单回执：逻辑校验通过
    @Test
    public void backLogic() throws IOException {
        BackChedan.backLogicpass(orderNo,ebpCode,ebcCode,agentCode,"20200806170000001");
    }
    @Test
    public void backPass() throws Exception {
        //回执：撤单成功
        BackChedan.backChedanSuccess(orderNo,ebpCode,ebcCode,agentCode,"20200806180000000");
    }
    @Test
    public void backTax() throws IOException {
        BackTax.backTaxCancel("","20200806190000001");
    }

    // 回执申报失败
    @Test
    public void backFail() throws IOException {
        BackChedan.backChedanFail(orderNo,ebpCode,ebcCode,agentCode,"20200806191310230");
    }

}
