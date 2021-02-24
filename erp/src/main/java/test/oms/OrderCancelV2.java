package test.oms;

import utils.util.BizData;
import utils.client.ApiClient;
import test.oms.v2.ApiV2ServiceName;
import test.oms.v2.orderV2Cancel.OrderCancel;
import org.junit.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/2 11:28
 */
public class OrderCancelV2 extends Data {
    String orderNo = "JOS20210202115931";

    @Test
    public void run2_New1() {
        OrderCancel orderCancel = new OrderCancel(accessCode1,orderNo);
        BizData orderBiz = new BizData(orderCancel, ApiV2ServiceName.ORDER_CANCEL,partnerId,token);

        ApiClient.doPostForm(V2Url,orderBiz,null,null);

    }
}
