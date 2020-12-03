package api;

import client.ApiClient;
import dto.stockin.SkuParam;
import dto.stockin.StockinOrder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:40
 */
public class WmsStockinApi {

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("G1606879207390","20201203",3,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));
//        skuParams.add(new SkuParam("G1606795289366","20201129",20,2,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));
//        skuParams.add(new SkuParam("G1606795328412","20201130",30,2,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));

        StockinOrder stockinOrder = new StockinOrder("ET202012031023180312876075",Data.warehouseCode,Data.ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2020-10-20 15:00:00");

        ApiClient.doPostJson(Data.urlStockin,null,null,stockinOrder);
    }

}
