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

    String etpsPreentNo = "HF2009091533000200";  // 系统内部核放单编号
    String SeqNo = "Y"+etpsPreentNo;  // 预录入编号
    String businessId = "QD"+etpsPreentNo;  // 核放单号

    @Test
    public void hefangPass() throws IOException, InterruptedException {
        // 核放单：调用成功
        callPass();
        Thread.sleep(1000);

        // 核放单：审核通过
        backExaminePass();
        Thread.sleep(1000);

        // 核放单：过卡回执
        backCheckPass();
    }

    @Test
    public void callPass() throws IOException {
        BackHefangHezhu.callPass(etpsPreentNo,SeqNo);
    }
    @Test
    public void backExaminePass() throws IOException {
        BackHefang.backExaminePass(SeqNo,businessId);
    }
    @Test
    public void backCheckPass() throws IOException {
        BackHefang.backCheckPass(SeqNo,businessId);
    }
}
