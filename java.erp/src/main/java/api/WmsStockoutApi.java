package api;

import client.ApiClient;
import dto.stockin.SkuParam;
import dto.stockout.StockoutOrder;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/29 14:53
 */
public class WmsStockoutApi {

    @Test
    public void backOrder(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("G1606550810909","20201128",10,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));
        skuParams.add(new SkuParam("G1606549582326","20201128",20,1,2,"2020-11-20 00:00:00","2022-11-10 00:00:00"));
        StockoutOrder order = new StockoutOrder("OB202011292014530350508707",Data.warehouseCode,Data.ownerCode,"SF","SF"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()),1,skuParams);

        ApiClient.doPostJson(Data.urlStockout,null,null,order);
    }

}
