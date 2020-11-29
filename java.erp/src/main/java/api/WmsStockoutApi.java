package api;

import client.ApiClient;
import dto.stockin.SkuParam;
import dto.stockout.StockoutOrder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/29 14:53
 */
public class WmsStockoutApi {

    @Test
    public void backOrder(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("G1606625613173","20201128",10,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));
        StockoutOrder order = new StockoutOrder("OB202011291716330271244295",Data.warehouseCode,Data.ownerCode,"SF","sf123565656",1,skuParams);

        ApiClient.doPostJson(Data.urlStockout,null,null,order);
    }

}
