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
    String orderno = "OB202104121832350962586686";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();
//        skuParams.add(new SkuParam("SKU2104121603162","21041218291",10,1,1,null,null));
//        skuParams.add(new SkuParam("SKU2104121602141","21041216391",10,1,2,null,null));
        skuParams.add(new SkuParam("SKU2104121602141","21041216391",10,1,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2104121603162","21041218291",10,1,2,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2104082000165","21040820181",10,1,5,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2104082000301","21040820123",10,1,6,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2104082000302","21040820152",10,1,7,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2104082000303","21040820161",10,1,8,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2104082000304","21040820162",10,1,9,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2104082000305","21040820173",10,1,10,"2020-10-10","2022-10-10"));

//        skuParams.add(new SkuParam("SKU2104082000161","21040820064",10,2,10,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2104082000305","21040820174",10,2,10,"2020-10-10","2022-10-10"));

        StockoutOrder order = new StockoutOrder(orderno,"2121001",0,warehouseCode,ownerCode,"SF","sf"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(urlStockout,null,null,order);
    }
}
