package test.wmsDaita;

import org.testng.annotations.Test;
import test.wmsDaita.dto.stockout.Detail;
import test.wmsDaita.dto.stockout.StockoutOrder;
import utils.client.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/25 17:03
 */
public class StockoutApi {

    @Test
    public void orderSet(){
        String orderNo = "JOT"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<Detail> detailList = new ArrayList<>();
        detailList.add(new Detail("JHY20201125131444",10,1));
        StockoutOrder order = new StockoutOrder(orderNo,Data.warehouseCode,Data.cargoCode,"YUNDA",detailList);

        ApiClient.doPostJson(Data.addStockoutUrl,null,null,order);
    }

}
