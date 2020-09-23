package api;

import domainout.BackChedan;
import domainout.BackTax;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 撤单--回执 流程
 * @Date : Created in 2020/8/4 17:58
 */
public class OrderChedanApi {
    // 取撤单列表的撤单申报编号，去掉CD
    String orderNo = "2009161436000394";

    // 回执：新增申报成功
    @Test
    public void backShenbao() throws IOException {
        BackChedan.backShenbao(orderNo, Data.ebpCode,Data.ebcCode,Data.agentCode,"20200806160000001");
    }
    // 回执：逻辑校验通过
    @Test
    public void backLogic() throws IOException {
        BackChedan.backLogicpass(orderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,"20200806170000001");
    }
    // 回执：撤单成功
    @Test
    public void backPass() throws Exception {
        BackChedan.backChedanSuccess(orderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,"20200806180000000");
    }
    // 作废税金
    @Test
    public void backTax() throws IOException {
        BackTax.backTaxCancel(Data.invtNo,"20200806190000001");
    }

    // 回执申报失败
    @Test
    public void backFail() throws IOException {
        BackChedan.backChedanFail(orderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,"20200806191310230");
    }

}
