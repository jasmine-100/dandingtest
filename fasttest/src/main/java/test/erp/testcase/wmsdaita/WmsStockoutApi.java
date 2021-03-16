package test.erp.testcase.wmsdaita;

import org.testng.annotations.Test;
import test.erp.testcase.wmsdaita.dto.stockout.SkuParam;
import test.erp.testcase.wmsdaita.dto.stockout.StockoutOrder;
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
    String orderno = "OB202103160946390929747900";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String sku = "SKU202103150";
        String bacthCode = "202103081736";
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam(sku,bacthCode,10,1,1,null,null));
        StockoutOrder order = new StockoutOrder(orderno,"",warehouseCode,ownerCode,"SF","sf"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(urlStockout,null,null,order);

    }
}
