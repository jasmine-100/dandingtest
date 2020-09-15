package apiout;

import client.ApiClient;
import domain.Order;
import jxc.BaseParam;
import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/15 16:31
 */
public class OrderSyncApi {

    @Test
    public void orderSync(){
        Order order = new Order("","","","");
        ApiClient.doPostJson(BaseParam.URL_DECLARE,null,null,order);
    }
}
