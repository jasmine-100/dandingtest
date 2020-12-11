package wmsMockDaita;

import client.ApiClient;
import wmsMockDaita.dto.stockin.SkuParam;
import wmsMockDaita.dto.stockout.StockoutOrder;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/29 14:53
 */
public class WmsStockoutApi {

    @Test
    public void backOrder(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("G1607669101361","20201210",100,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));

        StockoutOrder order = new StockoutOrder("OB202012111609570804204528",Data.warehouseCode,Data.ownerCode,"SF","SF"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(Data.urlStockout,null,null,order);
    }

}
