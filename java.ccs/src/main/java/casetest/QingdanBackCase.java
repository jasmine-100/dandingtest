package casetest;

import domainout.BackDingdanZongshu;
import domainout.BackQingdanKouan;
import domainout.BackQingdanZongshu;
import domainout.BackTax;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 测试用例--用于测试清单申报回执
 * @Date : Created in 2020/8/17 14:36
 */
public class QingdanBackCase {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";
    // 此项要配置，不要改
    static String agentCode = "330766K00W";

    // 申报单号
    String orderno = "JA08191700160";
    // 清单号
    String invtNo = "QD202008191439";

    // 测试用例：清单回执--口岸处理成功
    @Test
    public void backKouan() throws IOException {
        BackQingdanKouan.backPass(orderno,agentCode,"2020-8-17");
    }
    // 测试用例：清单回执--逻辑校验通过
    @Test
    public void backLogic() throws IOException {
        BackQingdanZongshu.backLogic(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817140000001");
    }
    // 测试用例：清单回执--新增申报成功
    @Test
    public void backAddOk() throws IOException {
        BackQingdanZongshu.backAddOk(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817150000001");
    }
    // 测试用例：清单回执--放行
    @Test
    public void backPass() throws IOException {
        BackQingdanZongshu.backPass(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817160000001");
    }
    // 测试用例：清单回执-税费
    @Test
    public void backTax() throws IOException {
        BackTax.backTaxrd(invtNo,901.52,10,5,"20200817170000001");
    }

    // 常见的错误回执报文
    // 测试用例：总署回执--清单和订单表体不一致(申报终止,可重推)
    @Test
    public void errorItem() throws IOException {
        BackQingdanZongshu.errorItem(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817180000001");
    }
    // 测试用例：总署回执--海关超限(申报失败,不可重推)
    @Test
    public void errorLimit() throws IOException {
        BackQingdanZongshu.errorLimit(orderno,ebpCode,ebcCode,agentCode,invtNo,"20200817180000001");
    }

}
