package test.erp.testcase.outapi.wmsdaita;

import org.testng.annotations.Test;
import test.erp.testcase.outapi.Data;
import test.erp.testcase.outapi.wmsdaita.dto.stockout.StockoutOrder;
import test.erp.testcase.outapi.wmsdaita.dto.stockout.SkuParam;
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
    String orderno = "OB202103261821370550543828";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU03161311_4","21031613561",1,1,1,null,null));
//        skuParams.add(new SkuParam("SKU202103160","LOT210317000017",2,1,1,null,null));
//        skuParams.add(new SkuParam("SKU202103163","LOT210317000015",3,1,1,null,null));

        StockoutOrder order = new StockoutOrder(orderno,"2121001",1,warehouseCode,ownerCode,"SF","sf199923",1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(urlStockout,null,null,order);
    }
}
