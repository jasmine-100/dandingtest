package api;

import client.ApiClient;
import dto.stockout.Detail;
import dto.stockout.Order;
import org.testng.annotations.Test;

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
        detailList.add(new Detail("JHY20201125145455",1,1));
        Order order = new Order(orderNo,Data.warehouseCode,Data.cargoCode,"YUNDA",detailList);

        ApiClient.doPostJson(Data.addStockoutUrl,null,null,order);
    }

}
