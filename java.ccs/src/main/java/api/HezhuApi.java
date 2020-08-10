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
 * @Date : Created in 2020/8/7 17:46
 */
public class HezhuApi {

    // ccs系统内核注单 编号
    String EtpsPreentNo = "HZ2008101313000173";
    // 预录入核注单号
    String SeqNo = "YHZ08101326";
    String bondInvtNo = "HZQD08101326";

    @Test
    public void backHezhu() throws IOException {

        // 核放单：调用成功
//        BackHefangHezhu.callPass(EtpsPreentNo,SeqNo);

        // 核放单：未核扣、审核通过
        BackHezhu.backHezhuPass(EtpsPreentNo,SeqNo,bondInvtNo);

    }

    @Test
    public void backHezhuPass() throws IOException {
        // 核注单：已核扣、审核通过
        BackHezhu.backHezhuSuccess(EtpsPreentNo,SeqNo,bondInvtNo);
    }


}
