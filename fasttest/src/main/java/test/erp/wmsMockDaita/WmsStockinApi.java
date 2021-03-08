package test.erp.wmsMockDaita;

import org.testng.annotations.Test;
import test.erp.wmsMockDaita.dto.stockin.SkuParam;
import test.erp.wmsMockDaita.dto.stockin.StockinOrder;
import utils.client.apiclientDTO.ApiClient;
import utils.database.ErpOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:40
 */
public class WmsStockinApi extends Data {
    String orderno = "ET202103080927330318525190";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("ID20210308092534","202103080928",100,1,1,"2020-10-10","2022-10-10",true));
//        skuParams.add(new SkuParam("ID20210305154143","202103051818",2,2,2,"2020-10-10","2022-10-10",true));

        StockinOrder stockinOrder = new StockinOrder(orderno,"KJ"+orderno,warehouseCode,ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2021-01-27 10:00:00");

        ApiClient.doPostJson(urlStockin,null,null,stockinOrder);
    }

}
