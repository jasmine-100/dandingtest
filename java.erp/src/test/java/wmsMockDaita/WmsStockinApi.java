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
    String orderno = "ET202101281627440247643515";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU2101141454","210115001",2,1,1,"2021-01-01","2022-01-25"));
        skuParams.add(new SkuParam("SKU2101141454","210115002",6,1,1,"2021-01-01","2022-01-26"));
        skuParams.add(new SkuParam("SKU2101141454","210115003",5,1,1,"2021-01-01","2022-01-27"));
        skuParams.add(new SkuParam("SKU2101141455","210115004",3,2,1,"2021-01-01","2022-01-20"));
        skuParams.add(new SkuParam("SKU2101141455","210115005",7,2,1,"2021-01-01","2022-01-21"));
        skuParams.add(new SkuParam("SKU2101141455","210115006",2,2,1,"2021-01-01","2022-01-22"));
        skuParams.add(new SkuParam("SKU2101141456","210115007",4,1,1,"2021-01-01","2022-01-23"));
        skuParams.add(new SkuParam("SKU2101141456","210115008",5,1,1,"2021-01-01","2022-01-24"));
        skuParams.add(new SkuParam("SKU2101141456","210115009",2,2,1,"2021-01-01","2022-01-25"));
        skuParams.add(new SkuParam("SKU2101141457","210115010",5,1,1,"2021-01-01","2022-01-26"));
        skuParams.add(new SkuParam("SKU2101141457","210115011",4,2,1,"2021-01-01","2022-01-27"));
        skuParams.add(new SkuParam("SKU2101141457","210115012",1,2,1,"2021-01-01","2022-01-28"));

        StockinOrder stockinOrder = new StockinOrder(orderno,warehouseCode,ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2020-10-20 15:00:00");

        ApiClient.doPostJson(urlStockin,null,null,stockinOrder);
    }

}
