package wmsMockDaita;

import client.ApiClient;
import database.ErpOrder;
import org.testng.annotations.Test;
import wmsMockDaita.dto.stockin.SkuParam;
import wmsMockDaita.dto.stockout.StockoutOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/24 16:51
 */
public class WmsStockoutApi extends Data {
    String orderno = "OB202102031820190100643425";

    @Test
    public void updateStatusOut(){
        ErpOrder.updateStatus(orderno,"out");
    }
    @Test
    public void backStockout(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU2101141456","20201110001",10,1,1,"2020-10-10","2022-10-10"));//完税
//        skuParams.add(new SkuParam("SKU2101141458","210115001",3,1,1,"2020-12-01","2020-12-31"));//保税
        StockoutOrder order = new StockoutOrder(orderno,warehouseCode,ownerCode,"SF","sf"+str,1,skuParams,"2020-12-01 10:00:00","2020-12-01 11:00:00");

        ApiClient.doPostJson(urlStockout,null,null,order);

    }
}
