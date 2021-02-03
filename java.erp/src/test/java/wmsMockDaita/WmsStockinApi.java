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
    String orderno = "ET202102031815100260904846";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU2101141456","20201110001",1000,1,1,"2020-10-10","2022-10-10"));
//        skuParams.add(new SkuParam("SKU2101141454","210128001",100,1,1,"2021-01-01","2022-02-25"));
//        skuParams.add(new SkuParam("SKU2101141454","210128002",200,2,1,"2021-01-01","2022-02-26"));
//        skuParams.add(new SkuParam("SKU2101141454","210128003",100,1,1,"2021-01-01","2022-02-20"));
//        skuParams.add(new SkuParam("SKU2101141454","210128004",100,2,1,"2021-01-01","2022-02-21"));
//        skuParams.add(new SkuParam("SKU2101141455","210128001",50,1,1,"2021-01-01","2022-02-25"));
//        skuParams.add(new SkuParam("SKU2101141455","210128002",50,2,1,"2021-01-01","2022-02-26"));
//        skuParams.add(new SkuParam("SKU2101141455","210128003",100,1,1,"2021-01-01","2022-02-20"));
//        skuParams.add(new SkuParam("SKU2101141455","210128004",100,2,1,"2021-01-01","2022-02-21"));
//        skuParams.add(new SkuParam("SKU2101141457","210128001",30,1,1,"2021-01-01","2022-02-25"));
//        skuParams.add(new SkuParam("SKU2101141457","210128002",20,2,1,"2021-01-01","2022-02-26"));
//        skuParams.add(new SkuParam("SKU2101141457","210128003",30,1,1,"2021-01-01","2022-02-20"));
//        skuParams.add(new SkuParam("SKU2101141457","210128004",20,2,1,"2021-01-01","2022-02-21"));

        StockinOrder stockinOrder = new StockinOrder(orderno,warehouseCode,ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2021-01-27 10:00:00");

        ApiClient.doPostJson(urlStockin,null,null,stockinOrder);
    }

}
