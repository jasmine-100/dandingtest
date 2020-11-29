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
        skuParams.add(new SkuParam("G1606550810909","20201128",100,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));

        StockinOrder stockinOrder = new StockinOrder("ET202011291202040530270431",Data.warehouseCode,Data.ownerCode,0,"1",skuParams);

        ApiClient.doPostJson(Data.urlStockin,null,null,stockinOrder);
    }

}
