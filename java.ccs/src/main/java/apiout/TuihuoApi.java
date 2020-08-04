package apiout;

import domainout.BackTuiHuo;
import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/4 15:12
 */
public class TuihuoApi {

    @Test
    public void order() throws Exception {
        String orderNo = "20073016420197";
        // 地址不详
//        TuiHuoBack.backAddressError(orderNo);
        //待人工审核
//        TuiHuoBack.backWaitExamine(orderNo);
        //放行
        BackTuiHuo.backPass(orderNo);
    }
}
