package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.DeclareBack;
import domain.ListBack;
import domain.PayInfo;
import domain.ShipBack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    public void declareOrderPush(String orderNo) throws IOException {
        String url = "http://customstest.yang800.cn/orderOutHandle/mock/CUSTOMS_CEB_CALLBACK/fdccReceiveCustomsOrder";
        DeclareBack declareBack = new DeclareBack(orderNo);

        ApiClient client = new ApiClient(url);
        client.doPostForm(declareBack);
    }

    //模拟清单回执
    public void listBackPush(String orderno) throws IOException {
        String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
        ListBack listBack = new ListBack(orderno);

        ApiClient client = new ApiClient(url);
        client.doPostForm(listBack);
    }

    //模拟运单回执
    public void shipBackPush(String orderno) throws IOException {
        String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
        ShipBack shipBack = new ShipBack(orderno);

        ApiClient client = new ApiClient(url);
        client.doPostForm(shipBack);
    }

}
