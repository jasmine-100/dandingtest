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
    String orderno = "OB202104071159450205540357";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SK210407115659208","21040711582",10,1,1,null,null));
//        skuParams.add(new SkuParam("SK210407085959162","21040711491",2,2,2,null,null));
//        skuParams.add(new SkuParam("SKU202103163","LOT210317000015",3,1,1,null,null));

        StockoutOrder order = new StockoutOrder(orderno,"2121001",0,warehouseCode,ownerCode,"SF","sf"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(urlStockout,null,null,order);
    }
}
