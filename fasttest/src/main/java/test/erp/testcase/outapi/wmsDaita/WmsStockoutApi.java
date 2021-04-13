package test.erp.testcase.outapi.wmsDaita;

import org.testng.annotations.Test;
import test.erp.testcase.outapi.Data;
import test.erp.testcase.outapi.wmsDaita.dto.stockout.StockoutOrder;
import test.erp.testcase.outapi.wmsDaita.dto.stockout.SkuParam;
import utils.client.apiclientDTO.ApiClient;
import utils.database.ErpOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/24 16:51
 */
public class WmsStockoutApi extends Data {
    String orderno = "OB202104131751080565457223";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();

        skuParams.add(new SkuParam("SKU2104131731521","2104131749181",10,1,10,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2104131731311","2104131736031",10,1,10,"2020-10-10","2022-10-10"));

        StockoutOrder order = new StockoutOrder(orderno,"2121001",0,warehouseCode,ownerCode,"SF","sf"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(urlStockout,null,null,order);
    }
}
