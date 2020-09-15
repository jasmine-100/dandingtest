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

    // 推送OMS订单上报
    @Test
    public void orderSync(){
        Order order = new Order("DO2009151625109271959","FYH20200915162510","FYH20200915162510","jxc");
        ApiClient.doPostJson(BaseParam.URL_DECLARE,null,null,order);
//        ApiClient.doPostJson("http://192.168.20.212:8083/xhr/order/syncDockerOrder",null,null,order);
    }
}
