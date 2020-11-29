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
        skuParams.add(new SkuParam("G1606550810909","20201128",10,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));
        skuParams.add(new SkuParam("G1606549582326","20201128",20,1,1,"2020-11-20 00:00:00","2022-11-10 00:00:00"));

        StockinOrder stockinOrder = new StockinOrder("ET202011292014530430667541",Data.warehouseCode,Data.ownerCode,0,"2",skuParams);

        ApiClient.doPostJson(Data.urlStockin,null,null,stockinOrder);
    }

}
