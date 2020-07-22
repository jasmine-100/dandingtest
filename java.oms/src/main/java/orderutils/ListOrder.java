package orderutils;

import client.ApiClient;
import oms.domain.ListBack;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 海关清单回执
 * @Date : Created in 2020/7/21 9:18
 */
public class ListOrder {
    public static String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    public static ApiClient client = new ApiClient(url);


    //放行
    public static void listSuccess(String orderno) throws IOException {
        client.doPostForm(new ListBack(orderno,"放行"));
    }

    public static void listLogicPass(String orderno) throws IOException {
        client.doPostForm(new ListBack(orderno,"逻辑校验通过"));
    }

    public static void listAddSuccess(String orderno) throws IOException {
        client.doPostForm(new ListBack(orderno,"新增申报成功"));
    }

    public static void listPayinfoNotExist(String orderno) throws IOException {
        client.doPostForm(new ListBack(orderno,"支付信息不存在"));
    }
    public static void listTelNotFit(String orderno) throws IOException {
        client.doPostForm(new ListBack(orderno,"清单上的订购人电话号码与订单上的订购人电话号码不一致"));
    }
    public static void listMoneyOutLimit(String orderno) throws IOException {
        client.doPostForm(new ListBack(orderno,"海关超限"));
    }

}
