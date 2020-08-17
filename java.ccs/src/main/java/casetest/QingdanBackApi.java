package casetest;

import domainout.BackQingDan;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 测试用例--用于测试清单申报回执
 * @Date : Created in 2020/8/17 14:36
 */
public class QingdanBackApi {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";
    // 此项要配置，不要改
    static String agentCode = "330766K00W";

    String orderno = "";
    String invtNo = "QD"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

    // 测试用例：清单回执--口岸处理成功
    @Test
    public void backKouan() throws IOException {
        BackQingDan.kouan(orderno,agentCode);
    }

    // 测试用例：清单回执--逻辑校验通过
    @Test
    public void backLogic () throws IOException {
        BackQingDan.backLogicPass(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817140000001");
    }

    // 测试用例：清单回执--新增申报成功
    @Test
    public void backAddOk() throws IOException {
        BackQingDan.backAddOk(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817150000001");
    }

    // 测试用例：清单回执--放行
    @Test
    public void backPass() throws IOException {
        BackQingDan.backAddOk(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817160000001");
    }

    // 测试用例：清单回执--订购人电话不一致
    @Test
    public void backInfoError() throws IOException {
        BackQingDan.backInfoError(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817170000001");
    }

    // 测试用例：清单回执--海关超限
    @Test
    public void backMoneyLimit() throws IOException {
        BackQingDan.backMoneyLimit(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817170000001");
    }

}
