package wmsMockDaita;

import client.ApiClient;
import database.ErpOrder;
import wmsMockDaita.dto.stockin.SkuParam;
import wmsMockDaita.dto.stockin.StockinOrder;
import org.testng.annotations.Test;
import wmsMockDaita.dto.stockout.StockoutOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:40
 */
public class WmsStockinApi {
    String orderno = "ET202012241620430918322468";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU20122404","20101001001",80,1,1,"2020-11-20 00:00:00","2023-12-07 00:00:00"));
        skuParams.add(new SkuParam("SKU20122404","20101001002",10,1,2,"2020-11-20 00:00:00","2023-12-07 00:00:00"));
        skuParams.add(new SkuParam("SKU20122404","20101001003",10,2,3,"2020-11-20 00:00:00","2023-12-07 00:00:00"));

        StockinOrder stockinOrder = new StockinOrder(orderno,Data.warehouseCode,Data.ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2020-10-20 15:00:00");

        ApiClient.doPostJson(Data.urlStockin,null,null,stockinOrder);
    }

}
