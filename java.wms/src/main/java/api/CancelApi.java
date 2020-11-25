package api;

import client.ApiClient;
import dto.Cancel.Cancel;
import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/25 18:03
 */
public class CancelApi {

    @Test
    public void cancelOrder(){
        String orderno = "JOT20201125180632";
        Cancel cancel = new Cancel(Data.warehouseCode,Data.cargoCode,orderno);

        ApiClient.doPostJson(Data.cancelOrderUrl,null,null,cancel);
    }
}
