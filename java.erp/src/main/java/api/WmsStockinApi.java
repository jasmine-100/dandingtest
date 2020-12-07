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
        int count =1;
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("G1607331601994","202012901",1,1,count++,"2020-11-20 00:00:00","2020-12-06 00:00:00"));
        skuParams.add(new SkuParam("G1607331601994","202011902",2,2,count++,"2020-11-20 00:00:00","2021-12-07 00:00:00"));
        skuParams.add(new SkuParam("G1607331601994","202011903",3,1,count++,"2020-11-20 00:00:00","2021-12-08 00:00:00"));
        skuParams.add(new SkuParam("G1607331601994","202011904",4,1,count++,"2020-11-20 00:00:00","2021-12-09 00:00:00"));
        skuParams.add(new SkuParam("G1607331601994","202011905",5,2,count++,"2020-11-20 00:00:00","2021-01-05 00:00:00"));
        skuParams.add(new SkuParam("G1607331601994","202011906",6,2,count++,"2020-11-20 00:00:00","2021-01-06 00:00:00"));
        skuParams.add(new SkuParam("G1607331601994","202011907",7,1,count++,"2020-11-20 00:00:00","2021-01-07 00:00:00"));
        skuParams.add(new SkuParam("G1607331601994","202011908",8,1,count++,"2020-11-20 00:00:00","2021-01-08 00:00:00"));
        skuParams.add(new SkuParam("G1607331601994","202011909",90,2,count++,"2020-11-20 00:00:00","2021-01-09 00:00:00"));

        StockinOrder stockinOrder = new StockinOrder("ET202012071701350561873739",Data.warehouseCode,Data.ownerCode,1,"1",skuParams,"2020-10-10 12:00:00","2020-10-20 15:00:00");

        ApiClient.doPostJson(Data.urlStockin,null,null,stockinOrder);
    }

}
