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
        skuParams.add(new SkuParam("G1607390668904",20201002,1,1,1,"2020-11-20 00:00:00","2020-12-07 00:00:00"));
//        skuParams.add(new SkuParam("G1607390668904",202001,2,1,1,"2020-11-20 00:00:00","2020-12-07 00:00:00"));
//        skuParams.add(new SkuParam("G1607390668904",202002,3,1,2,"2020-11-20 00:00:00","2020-12-08 00:00:00"));
//        skuParams.add(new SkuParam("G1607390668904",202003,4,1,count++,"2020-11-20 00:00:00","2020-12-09 00:00:00"));
//        skuParams.add(new SkuParam("G1607390668904",202004,4,1,count++,"2020-11-20 00:00:00","2020-12-10 00:00:00"));
//        skuParams.add(new SkuParam("G1607390668904",202005,6,1,count++,"2020-11-20 00:00:00","2021-01-06 00:00:00"));
//        skuParams.add(new SkuParam("G1607390668904",202006,7,1,count++,"2020-11-20 00:00:00","2021-01-07 00:00:00"));
//        skuParams.add(new SkuParam("G1607390668904",202007,8,1,count++,"2020-11-20 00:00:00","2021-01-08 00:00:00"));
//        skuParams.add(new SkuParam("G1607390668904",202008,9,1,count++,"2020-11-20 00:00:00","2021-01-09 00:00:00"));

        StockinOrder stockinOrder = new StockinOrder("ET202012091022280939087998",Data.warehouseCode,Data.ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2020-10-20 15:00:00");

        ApiClient.doPostJson(Data.urlStockin,null,null,stockinOrder);
    }

}
