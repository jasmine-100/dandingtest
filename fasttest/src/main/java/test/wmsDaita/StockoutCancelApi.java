package test.wmsDaita;

import org.testng.annotations.Test;
import test.wmsDaita.dto.cancel.Cancel;
import utils.client.ApiClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/25 18:03
 */
public class StockoutCancelApi {

    @Test
    public void cancelOrder(){
        String orderno = "JOT20201126164012";
        Cancel cancel = new Cancel(Data.warehouseCode,Data.cargoCode,orderno);

        ApiClient.doPostJson(Data.cancelOrderUrl,null,null,cancel);
    }

}
