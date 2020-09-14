package outchannel.websc.api;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import outchannel.websc.domain.Params;
import outchannel.websc.domain.Item;
import outchannel.websc.domain.Order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 渠道接口下单--分销商城
 * @Date : Created in 2020/7/22 15:57
 */
public class OrderSetApi {

@Test
public void orderSet() throws IOException {
//店铺code
String accesscode = "49C9ADB18E44BE0711A94E827042F630";
//订单编号
String orderno = "fx" +new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

//组装商品项
List<Item> itemList = new ArrayList<>();
itemList.add(new Item("SPC1596438357513","小苹果","xpg001",1,12));
//组装订单项
    Order order = new Order(accesscode,orderno,itemList);
        //组装接口参数
        Params params = new Params(order,"order.out.set","WEBSC");

        String url = "http://outtest.order.yang800.cn/open/testV2";
    ApiClient.doPostForm(url,params,null,null);

    }

}
