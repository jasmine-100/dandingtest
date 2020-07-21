package orderutils;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.DeclareBack;
import domain.PayInfo;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/21 9:39
 */
public class Pay {

    //模拟推送海关支付信息
    public static void payInfoPush(String orderNo) throws IOException {
        String url = "http://pangu.admintest.yang800.cn/docking/api/customs/pay/info/upload";
        PayInfo pay = new PayInfo(orderNo);
        ApiClient client = new ApiClient(url);
        client.doPostJson(JSON.toJSON(pay));
    }


}
