package test.wmsDaita.testcase;

import org.testng.annotations.Test;
import test.wmsDaita.testcase.dto.cancel.Cancel;
import utils.client.apiclientDTO.ApiClient;

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
