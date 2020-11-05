package casetest;

import domainout.BackQingdanKouan;
import domainout.BackQingdanZongshu;
import domainout.BackTax;
import domainout.BackYundanZongshu;
import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description : 测试用例--用于测试清单申报回执
 * @Date : Created in 2020/8/17 14:36
 */
public class OrderYundanCase {

    // 测试用例：清单回执--新增申报成功
    @Test
    public static void backAddOk()  {
        BackYundanZongshu.backAddOk(Data.logiticsNo,Data.agentCode,"20200817150000001");
    }

    // 测试用例：清单回执--逻辑校验通过
    @Test
    public static void backLogic()  {
        BackYundanZongshu.backLogic(Data.logiticsNo,Data.agentCode,"20200817140000001");
    }


}
