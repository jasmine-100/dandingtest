package test.ccs;

import test.ccs.dtoBack.BackChedan;
import test.ccs.dtoBack.BackTax;
import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description : 撤单--回执 流程
 * @Date : Created in 2020/8/4 17:58
 */
public class OrderChedanApi {
    // 取撤单列表的撤单申报编号，去掉CD
    String orderNo = "2011161737000498";
    String invtNo = "";

    // 回执：新增申报成功
    @Test
    public void backShenbao()   {
        BackChedan.backShenbao(orderNo, Data.ebpCode,Data.ebcCode,Data.agentCode,"20200806160000001");
    }
    // 回执：逻辑校验通过
    @Test
    public void backLogic() {
        BackChedan.backLogicpass(orderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,"20200806170000001");
    }
    // 回执：撤单成功
    @Test
    public void backPass() {
        BackChedan.backChedanSuccess(orderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,"20200806180000000");
    }
    // 作废税金
    @Test
    public void backTax(){
        BackTax.backTaxCancel(invtNo,"20200806190000001");
    }

    // 回执申报失败
    @Test
    public void backFail() {
        BackChedan.backChedanFail(orderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,"20200806191310230");
    }

}
