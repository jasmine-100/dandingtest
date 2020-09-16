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

    String etpsPreentNo = "HF2009161746000230";  // 系统内部核放单编号
    String SeqNo = "Y"+etpsPreentNo;  // 预录入编号
    String businessId = "QD"+etpsPreentNo;  // 核放单号

    @Test
    public void hefangPass() throws InterruptedException {
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
    public void callPass() {
        BackHefangHezhu.callPass(etpsPreentNo,SeqNo);
    }
    @Test
    public void backExaminePass() {
        BackHefang.backExaminePass(SeqNo,businessId,"2020-09-15 10:20:30");
    }
    @Test
    public void backCheckPass() {
        BackHefang.backCheckPass(SeqNo,businessId,"2020-09-15 12:20:30");
    }

    @Test
    public void backCancel(){
        BackHefang.backCancel(SeqNo,businessId,"2020-09-15 15:20:10");
    }
}
