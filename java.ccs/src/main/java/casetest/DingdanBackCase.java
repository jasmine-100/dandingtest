package casetest;

import domainout.BackDingdanKouan;
import domainout.BackDingdanZongshu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/17 15:17
 */
public class DingdanBackCase {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";

    static String orderno = "A08181532092";

    // 订单回执：新增申报成功
    @Test
    public void backAddOk() throws IOException {
        BackDingdanZongshu.declareAddOk(orderno,ebcCode,ebcCode,"20200817150000001");
    }
    // 订单回执：逻辑校验通过
    @Test
    public void backLogic() throws IOException {
        BackDingdanZongshu.logicOk(orderno,ebcCode,ebcCode,"20200817160000001");
    }

    // 失败的回执--口岸
    @Test
    public void errorKouan1() throws IOException {
        BackDingdanKouan.errorEndorse(orderno,"2020-08-17");
    }
    @Test
    public void errorKouan2() throws IOException {
        BackDingdanKouan.errorPayCompany(orderno,"2020-8-16");
    }
    @Test
    public void errorKouan3 () throws IOException {
        BackDingdanKouan.errorBusCompany(orderno,"2020-08-15");
    }

    // 失败的回执--总署
    @Test
    public void errorZongshu1() throws IOException {
        BackDingdanZongshu.errorID(orderno,ebpCode,ebcCode,"20200818130000001");
    }
    @Test
    public void errorZongshu2() throws IOException {
        BackDingdanZongshu.errorItem(orderno,ebpCode,ebcCode,"20200818130000001");
    }
    @Test
    public void errorZongshu3() throws IOException {
        BackDingdanZongshu.errorPayer(orderno,ebpCode,ebcCode,"20200818130000001");
    }

}
