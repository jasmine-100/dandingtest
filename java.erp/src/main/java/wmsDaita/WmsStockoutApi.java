package wmsDaita;

import client.ApiClient;
import wmsDaita.dto.stockin.SkuParam;
import wmsDaita.dto.stockout.StockoutOrder;
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
        skuParams.add(new SkuParam("G1607390668904",20201002,1,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));
//        skuParams.add(new SkuParam("G1606549582326","20201128",20,1,2,"2020-11-20 00:00:00","2022-11-10 00:00:00"));

        StockoutOrder order = new StockoutOrder("OB202012091022280819950846",Data.warehouseCode,Data.ownerCode,"SF","SF"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(Data.urlStockout,null,null,order);
    }

}
