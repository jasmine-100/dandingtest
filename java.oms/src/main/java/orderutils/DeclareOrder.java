package orderutils;

import client.ApiClient;
import domain.DeclareBack;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/21 9:16
 */
public class DeclareOrder {
    //模拟订单回执--逻辑校验通过
    public static void declareLogicPass(String orderNo) throws IOException {
        String url = "http://customstest.yang800.cn/orderOutHandle/mock/CUSTOMS_CEB_CALLBACK/fdccReceiveCustomsOrder";
        DeclareBack declareBack = new DeclareBack(orderNo,"逻辑校验通过");

        ApiClient client = new ApiClient(url);
        client.doPostForm(declareBack);
    }

    //模拟订单回执--新增申报成功
    public static void declareSuccess(String orderNo) throws IOException {
        String url = "http://customstest.yang800.cn/orderOutHandle/mock/CUSTOMS_CEB_CALLBACK/fdccReceiveCustomsOrder";
        DeclareBack declareBack = new DeclareBack(orderNo,"新增申报成功");

        ApiClient client = new ApiClient(url);
        client.doPostForm(declareBack);
    }
}