package test.qimen.testcase;

import org.testng.annotations.Test;
import test.qimen.testcase.dto.Param;
import test.qimen.testcase.dto.stockout.cancel.Cancel;
import utils.client.apiclientDTO.ApiClient;

/**
 * @Author： jasmine
 * @Description : 奇门取消订单
 * @Date : Created in 2021/2/24 17:45
 */
public class OrderCancelApi extends Data{

    @Test
    public void orderCancel(){
        String orderno = "QMOB20210226143946";

        Param param = new Param("order.cancel");

        Cancel cancel = new Cancel(orderno,"DBCK",logicWarehouseCode,ownerCode);

        ApiClient.doPostXml(URL,param,null,cancel);
    }

}
