package api;

import domainout.BackHefang;
import domainout.BackHefangHezhu;
import domainout.BackHezhu;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/10 10:38
 */
public class HefangApi {

    String etpsPreentNo = "HF2008101327000181";  // 系统内部核放单编号
    String SeqNo = "YHF08101328";  // 预录入编号
    String businessId = "QDHF08101328";  // 核放单号

    @Test
    public void hefangPass() throws IOException {
        // 核放单：调用成功
//        BackHefangHezhu.callPass(etpsPreentNo,SeqNo);

        // 核放单：审核通过
//        BackHefang.backExaminePass(SeqNo,businessId);

        // 核放单：过卡回执
        BackHefang.backCheckPass(SeqNo,businessId);
    }
}
