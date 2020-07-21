package orderutils;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.DeclareBack;
import domain.ShipBack;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/21 9:10
 */
public class ShipOrder {

    //模拟运单回执
    public static void shipBackPush(String orderno) throws IOException {
        String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
        ShipBack shipBack = new ShipBack(orderno);

        ApiClient client = new ApiClient(url);
        client.doPostForm(shipBack);
    }

}
