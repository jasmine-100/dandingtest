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
    String orderno = "ET202102041730050802038225";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("G1612339450609","323230001",500,1,1,null,null));
        skuParams.add(new SkuParam("G1612339450609","9500001",400,1,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("G1612339450609","8989560001",100,2,1,null,null));
//        skuParams.add(new SkuParam("SKU2101141457",null,10,1,1,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2101141457","20201110",10,1,1,null,null));
//        skuParams.add(new SkuParam("SKU2101141457","20201110",10,1,1,"2020-10-10","2022-10-10"));

        StockinOrder stockinOrder = new StockinOrder(orderno,warehouseCode,ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2021-01-27 10:00:00");

        ApiClient.doPostJson(urlStockin,null,null,stockinOrder);
    }

}
