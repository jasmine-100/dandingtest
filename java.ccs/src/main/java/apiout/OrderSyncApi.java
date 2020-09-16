package apiout;

import client.ApiClient;
import jxc.BaseParam;
import org.junit.jupiter.api.Test;

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
        OrderOms order = new OrderOms("DO"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()),
                "FYH202009161024","FYH202009161024","jxc");
        ApiClient.doPostJson(BaseParam.URL_DECLARE,null,null,order);
//        ApiClient.doPostJson("http://192.168.20.212:8083/xhr/order/syncDockerOrder",null,null,order);
    }

}
