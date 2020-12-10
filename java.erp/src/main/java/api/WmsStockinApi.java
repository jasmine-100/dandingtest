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
        int count =1;
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("G1607425274829",20201002,1,1,1,"2020-11-20 00:00:00","2020-12-07 00:00:00"));
        skuParams.add(new SkuParam("G1607425274829",20201003,2,1,2,"2020-11-20 00:00:00","2020-12-07 00:00:00"));
        skuParams.add(new SkuParam("G1607425274829",20201004,3,1,3,"2020-11-20 00:00:00","2020-12-07 00:00:00"));

        StockinOrder stockinOrder = new StockinOrder("ET202012101011090743088811",Data.warehouseCode,Data.ownerCode,1,"1",skuParams,"2020-10-10 12:00:00","2020-10-20 15:00:00");

        ApiClient.doPostJson(Data.urlStockin,null,null,stockinOrder);
    }

}
