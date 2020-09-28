package apiout;

import client.ApiClient;
import jxc.BaseParam;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/15 16:31
 */
public class OrderSyncApi {

    // 推送OMS订单上报
    @Test
    public void orderSync(){
        OrderOms order = new OrderOms("DO2009161456354311954","FYH202009161356","FYH202009161356","jxc");
        ApiClient.doPostJson(BaseParam.URL_DECLARE,null,null,order);
//        ApiClient.doPostJson("http://192.168.20.212:8083/xhr/order/syncDockerOrder",null,null,order);
    }

}
