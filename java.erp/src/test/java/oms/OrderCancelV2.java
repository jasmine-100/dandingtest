package oms;

import Utils.OrderBiz;
import client.ApiClient;
import com.alibaba.fastjson.JSON;
import oms.v2.ApiV2ServiceName;
import oms.v2.orderV2Cancel.OrderCancel;
import org.junit.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/2 11:28
 */
public class OrderCancelV2 extends Data {

    @Test
    public void run2_New1() {
        OrderCancel orderCancel = new OrderCancel(accessCode1,"");
        OrderBiz orderBiz = new OrderBiz(JSON.toJSONString(orderCancel), ApiV2ServiceName.ORDER_CANCEL,partnerId,token);

        ApiClient.doPostForm(V2Url,orderBiz,null,null);

    }
}
