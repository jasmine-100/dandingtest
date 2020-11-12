package api;

import domainout.BackHefangHezhu;
import domainout.BackHezhu;
import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/7 17:46
 */
public class HezhuApi {

    // ccs系统内核注单 编号
    String etpsPreentNo = "HZ2011091721000761";
    // 预录入核注单号
    String seqNo = "Y"+ etpsPreentNo;
    String bondInvtNo = "QD"+ etpsPreentNo;

    @Test
    public void callPass(){
        // 核放单：调用成功
        BackHefangHezhu.callPass(etpsPreentNo, seqNo);
    }
    @Test
    public void backHezhuPass(){
        // 核放单：未核扣、审核通过
        BackHezhu.backHezhuPass(etpsPreentNo, seqNo,bondInvtNo);
    }
    @Test
    public void backHezhuSuccess()  {
        // 核注单：已核扣、审核通过
        BackHezhu.backHezhuSuccess(etpsPreentNo, seqNo,bondInvtNo);
    }

    // 退单
    @Test
    public void backCancel(){
        BackHezhu.backError(etpsPreentNo, seqNo,bondInvtNo);
    }
    // 异常(推送不成功)
    @Test
    public void backError(){
        BackHefangHezhu.callFail(etpsPreentNo);
    }
}
