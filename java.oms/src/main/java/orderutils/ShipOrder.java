package orderutils;

import client.ApiClient;
import oms.domain.ShipBack;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 推送运单回执
 * @Date : Created in 2020/7/21 9:10
 */
public class ShipOrder {
    public static  String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    public static  ApiClient client = new ApiClient(url);

    //模拟运单回执
    public static void shipBackPush(String orderno) throws IOException {
        ShipBack shipBack = new ShipBack(orderno);
        client.doPostForm(shipBack);
    }

    //模拟运单回执
    public static void shipBackPush(String orderno,String shipCompany,String shipCode,String operateDate) throws IOException {
        ShipBack shipBack = new ShipBack(orderno,shipCompany,shipCode,operateDate);
        client.doPostForm(shipBack);
    }

}
