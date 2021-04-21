package test.erp.testcase.wmsMockDaita;

import org.testng.annotations.Test;
import test.erp.testcase.Data;
import test.erp.testcase.wmsMockDaita.dto.stockout.StockoutOrder;
import test.erp.testcase.wmsMockDaita.dto.stockout.SkuParam;
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
    String orderno = "OB202104211830150612957704";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();

        skuParams.add(new SkuParam("SKU210421181749","2104211825431",10,1,10,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU210415203850","2104152042132",10,2,10,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2104121602143","21041310024",2,2,1,"2020-10-10","2022-10-10"));

        StockoutOrder order = new StockoutOrder(orderno,"2121001",0,warehouseCode,ownerCode,"ZTO","zto"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(urlStockout,null,null,order);
    }
}
