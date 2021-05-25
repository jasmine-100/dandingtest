package test.erp.testcase.outPuluosi;

import org.testng.annotations.Test;
import test.erp.testcase.Data;
import test.erp.testcase.outPuluosi.dto.Stock;
import utils.client.apiclientDTO.ApiClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/14 15:42
 */
public class StockApi extends Data {

    @Test
    public void stock(){
//        Stock stock = new Stock("SKU210414164733,SKU210414164604",ownerCode,logicWarehouseCode,0);
        Stock stock = new Stock("*",ownerCode,logicWarehouseCode,0);

        ApiClient.doPostJson(urlPuluosi,null,null,stock);
    }

}
