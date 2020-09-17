package api;

import domainout.BackHefang;
import domainout.BackHefangHezhu;
import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/10 10:38
 */
public class HefangApi {

    String etpsPreentNo = "HF2009171636000247";  // 系统内部核放单编号
    String seqNo = "Y"+etpsPreentNo;  // 预录入编号
    String businessId = "QD"+etpsPreentNo;  // 核放单号

    @Test // 调用成功
    public void callPass() {
        BackHefangHezhu.callPass(etpsPreentNo, seqNo);
    }
    @Test  // 审核通过
    public void backExaminePass() {
        BackHefang.backExaminePass(seqNo,businessId,"2020-09-15 10:20:30");
    }
    @Test  // 过卡回执
    public void backCheckPass() {
        BackHefang.backCheckPass(seqNo,businessId,"2020-09-15 12:20:30");
    }

    @Test  // 退单
    public void backCancel(){
        BackHefang.backQuit(seqNo,businessId,"2020-09-15 15:20:10");
    }

    @Test  // 异常
    public void backError(){
        BackHefangHezhu.callFail(etpsPreentNo);
    }
}
