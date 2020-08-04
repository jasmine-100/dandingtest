package domainInner;

import client.ApiClient;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/4 17:06
 */
public class BackQingdan {
    static String url = "http://ccs.backend.daily.yang800.com/xhr/order/mockReceive";
    static String data = null;
    static String ebpCode = "1234650123";
    static String ebcCode = "1234650123";

    public static void backFangxing(String orderno) throws IOException {
        new ApiClient(url).doPostForm(new Qingdan(orderno,"800",ebpCode));
    }

    public static void backLogicPass(String orderno) throws IOException {
        new ApiClient(url).doPostForm(new Qingdan(orderno,"120",ebpCode));
    }

    public static void backDelarePass(String orderno) throws IOException {
        new ApiClient(url).doPostForm(new Qingdan(orderno,"2",ebpCode));
    }
}
