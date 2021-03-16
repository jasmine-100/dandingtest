package test.erp.testcase.outapi.qimen;

import org.testng.annotations.Test;
import test.erp.testcase.outapi.Data;
import test.erp.testcase.outapi.qimen.dto.Params;
import test.erp.testcase.outapi.qimen.dto.good.Good;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodApi extends Data {

    @Test
    public void addGoods(){
        for (int i=0;i<10;i++){
            String goodNo = "SKU20210315" + i;
            Good good = new Good(goodNo,"小仓鼠",goodNo, logicWarehouseCode,ownerCode);
            Params params = new Params(goodNo,"3",good);

            ApiClient.doPostJson(URL,null,null,params);
        }
    }

    @Test
    public void addGood(){
        String str = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
        String goodNo = "SK" + str;
//        String goodNo = "SK210222112519";
        Good good = new Good(goodNo,"小仓鼠",str, logicWarehouseCode,ownerCode);
        Params params = new Params(goodNo,"3",good);

        ApiClient.doPostJson(URL,null,null,params);
    }

}
