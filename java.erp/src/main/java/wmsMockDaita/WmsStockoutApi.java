package wmsMockDaita;

import client.ApiClient;
import database.ErpOrder;
import org.testng.annotations.Test;
import wmsMockDaita.dto.stockin.SkuParam;
import wmsMockDaita.dto.stockout.StockoutOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/24 16:51
 */
public class WmsStockoutApi {
    String orderno = "OB202012251049260905297864";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU20122403","20101001002",10,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));

        StockoutOrder order = new StockoutOrder(orderno,Data.warehouseCode,Data.ownerCode,"SF","SF"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(Data.urlStockout,null,null,order);
    }
}
