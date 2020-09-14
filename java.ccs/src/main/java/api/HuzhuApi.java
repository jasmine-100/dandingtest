package api;

import domainout.BackHefangHezhu;
import domainout.BackHezhu;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/7 17:46
 */
public class HuzhuApi {

    // ccs系统内核注单 编号
    String EtpsPreentNo = "HZ2009141803000269";
    // 预录入核注单号
    String SeqNo = "Y"+EtpsPreentNo;
    String bondInvtNo = "QD"+EtpsPreentNo;

    @Test
    public void both(){
        // 核放单：调用成功
        BackHefangHezhu.callPass(EtpsPreentNo,SeqNo);
        // 核放单：未核扣、审核通过
        BackHezhu.backHezhuPass(EtpsPreentNo,SeqNo,bondInvtNo);
    }

    @Test
    public void backHezhuPass()  {
        // 核注单：已核扣、审核通过
        BackHezhu.backHezhuSuccess(EtpsPreentNo,SeqNo,bondInvtNo);
    }

    // 退单
    @Test
    public void backError(){
        BackHezhu.backError(EtpsPreentNo,SeqNo,bondInvtNo);
    }

}
