package api;

import domainout.BackHefang;
import domainout.BackHefangHezhu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/10 10:38
 */
public class HefangApi {

    String etpsPreentNo = "HF2008111616000001";  // 系统内部核放单编号
    String SeqNo = "YHF08111616";  // 预录入编号
    String businessId = "QDHF08111616";  // 核放单号

    @Test
    public void hefangPass() throws IOException, InterruptedException {
        // 核放单：调用成功
        BackHefangHezhu.callPass(etpsPreentNo,SeqNo);
        Thread.sleep(1000);

        // 核放单：审核通过
        BackHefang.backExaminePass(SeqNo,businessId);
        Thread.sleep(1000);

        // 核放单：过卡回执
        BackHefang.backCheckPass(SeqNo,businessId);
    }
}
