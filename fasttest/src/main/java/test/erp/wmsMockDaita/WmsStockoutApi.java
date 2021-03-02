package test.erp.wmsMockDaita;

import org.testng.annotations.Test;
import test.erp.wmsMockDaita.dto.stockin.SkuParam;
import test.erp.wmsMockDaita.dto.stockout.StockoutOrder;
import utils.client.ApiClient;
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
    String orderno = "OB202102051331290333053832";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String sku = "G1612339450609";
        String bacthCode = "9500001";
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();
//        skuParams.add(new SkuParam(sku,null,1,1,1,null,null));//完税
        skuParams.add(new SkuParam(sku,bacthCode,1,1,1,null,null));//完税
//        skuParams.add(new SkuParam(sku,null,1,1,1,"2020-10-10","2025-10-10"));//完税
//        skuParams.add(new SkuParam(sku,bacthCode,1,1,1,"",""));//完税
        StockoutOrder order = new StockoutOrder(orderno,"",warehouseCode,ownerCode,"SF","sf"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(urlStockout,null,null,order);

    }
}
