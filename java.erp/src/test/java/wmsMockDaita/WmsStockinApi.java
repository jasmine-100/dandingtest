package wmsMockDaita;

import client.ApiClient;
import database.ErpOrder;
import org.testng.annotations.Test;
import wmsMockDaita.dto.stockin.SkuParam;
import wmsMockDaita.dto.stockin.StockinOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:40
 */
public class WmsStockinApi extends Data {
    String orderno = "ET202102181817290187743935";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU2101141455","2021021801001",2000,1,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141455","2021021801002",1000,1,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141455","2021021801003",3000,1,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141455","2021021801004",2000,2,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141455","2021021801005",2000,2,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141456","2021021802001",1000,1,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141456","2021021802002",1000,1,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141456","2021021802003",1000,1,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141456","2021021802004",1000,2,1,"2020-10-10","2022-10-10"));
        skuParams.add(new SkuParam("SKU2101141456","2021021802005",1000,2,1,"2020-10-10","2022-10-10"));

        StockinOrder stockinOrder = new StockinOrder(orderno,warehouseCode,ownerCode,1,"1",skuParams,"2020-10-10 12:00:00","2021-01-27 10:00:00");

        ApiClient.doPostJson(urlStockin,null,null,stockinOrder);
    }

}
