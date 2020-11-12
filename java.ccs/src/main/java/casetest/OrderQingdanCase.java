package casetest;

import domainout.BackQingdanKouan;
import domainout.BackQingdanZongshu;
import domainout.BackTax;
import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description : 测试用例--用于测试清单申报回执
 * @Date : Created in 2020/8/17 14:36
 */
public class OrderQingdanCase {

    // 测试用例：清单回执--口岸处理成功
    @Test
    public static void backKouan()  {
        BackQingdanKouan.backPass(Data.declareOrderNo,Data.agentCode,"2020-8-17");
    }

    // 测试用例：清单回执--新增申报成功
    @Test
    public static void backAddOk()  {
        BackQingdanZongshu.backAddOk(Data.declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,Data.invtNo,"20201112100000001");
    }
    // 测试用例：清单回执--逻辑校验通过
    @Test
    public static void backLogic()  {
        BackQingdanZongshu.backLogic(Data.declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,Data.invtNo,"20201112110000001");
    }

    // 测试用例：清单回执--放行
    @Test
    public static void backPass() {
        BackQingdanZongshu.backPass(Data.declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,Data.invtNo,"20201112120000001");
//        BackQingdanZongshu.backPass("DOS0910142536",Data.ebpCode,Data.ebcCode,Data.agentCode,"QD20200910142547","20200817160000001");
    }
    // 测试用例：清单回执-税费
    @Test
    public static void backTax()  {
        BackTax.backTaxrd(Data.invtNo,Data.ebcCode,600.6,10,30,"20201112130000001");
    }

    // 常见的错误回执报文
    // 测试用例：总署回执--清单和订单表体不一致(申报终止,可重推)
    @Test
    public static void errorItem() {
        BackQingdanZongshu.errorItem(Data.declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,Data.invtNo,"20201112140000001");
    }
    // 测试用例：总署回执--海关超限(申报失败,不可重推)
    @Test
    public static void errorLimit(){
        BackQingdanZongshu.errorLimit(Data.declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,Data.invtNo,"20201112150000001");
    }

}
