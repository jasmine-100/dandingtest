package outchannel.websc.api;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import outchannel.websc.domain.Cancel;
import outchannel.websc.domain.Params;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 取消订单--分销商城渠道
 * @Date : Created in 2020/7/22 16:22
 */
public class CancelApi {

@Test
public void orderCancel() throws IOException {
String accesscode = "49C9ADB18E44BE0711A94E827042F630";
//订单编号
String orderno = "websc20200722163121";

Cancel cancel = new Cancel(orderno,accesscode);
Params params = new Params(cancel,"order.cancel","WEBSC");

String url = "http://outtest.order.yang800.cn/open/testV2";
    ApiClient.doPostForm(url,params,null,null);
}
}
