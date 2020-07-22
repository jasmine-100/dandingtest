package orderutils;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import oms.domain.PayInfo;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 推送海关支付信息
 * @Date : Created in 2020/7/21 9:39
 */
public class Pay {
    public static String url = "http://pangu.admintest.yang800.cn/docking/api/customs/pay/info/upload";
    public static ApiClient client = new ApiClient(url);

    //模拟推送海关支付信息
    public static void payInfoPush(String orderNo) throws IOException {
        PayInfo payInfo = new PayInfo(orderNo);
        client.doPostJson(JSON.toJSON(payInfo));
    }

}
