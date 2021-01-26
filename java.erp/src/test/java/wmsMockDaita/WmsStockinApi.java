package wmsMockDaita;

import client.ApiClient;
import database.ErpOrder;
import wmsMockDaita.dto.stockin.SkuParam;
import wmsMockDaita.dto.stockin.StockinOrder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:40
 */
public class WmsStockinApi extends Data {
    String orderno = "ET202101181752480793064403";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU2101141458","210115001",10000,1,1,"2021-01-01","2021-01-31"));
//        skuParams.add(new SkuParam("SKU2101141456","210115002",50,2,2,"2021-01-01","2021-01-31"));
//        skuParams.add(new SkuParam("SKU2101141456","210115003",50,2,3,"2021-01-01","2021-01-31"));

        StockinOrder stockinOrder = new StockinOrder(orderno,warehouseCode,ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2020-10-20 15:00:00");

        ApiClient.doPostJson(urlStockin,null,null,stockinOrder);
    }

}
