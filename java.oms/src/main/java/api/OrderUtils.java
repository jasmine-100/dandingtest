package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.PayInfo;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 17:18
 */
public class OrderUtils {

    //模拟推送海关支付信息
    public void payInfoPush(String orderNo) throws IOException {
        String url = "http://pangu.admintest.yang800.cn/docking/api/customs/pay/info/upload";
        PayInfo pay = new PayInfo(orderNo);
        ApiClient client = new ApiClient(url);
        client.doPostJson(JSON.toJSON(pay));
    }

    //模拟订单回执
    public void DeclareOrderPush(String orderNo){

    }

}
