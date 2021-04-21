package test.erp.testcase.outQimen;

import org.testng.annotations.Test;
import test.erp.testcase.outQimen.dto.Params;
import test.erp.testcase.outQimen.dto.good.Good;
import test.erp.testcase.Data;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodApi extends Data {

    @Test
    public void addGoods(){
        String str =new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        for (int i=1;i<=1;i++){
            String goodNo = "SKU" + str + i;
//            Good good = new Good(goodNo,"牛奶"+str+i,goodNo,1,logicWarehouseCode,ownerCode);//开启效期
            Good good = new Good(goodNo,"纸巾"+str+i,goodNo,2,logicWarehouseCode,ownerCode);//关闭效期
            Params params = new Params(goodNo,"3",good);

            ApiClient.doPostJson(urlQimen,null,null,params);
        }
    }

    @Test
    public void addGood(){
        String str = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        String goodNo = "SK" + str;
//        String goodNo = "SK210222112519";
        Good good = new Good(goodNo,"咖啡豆",str, 1,logicWarehouseCode,ownerCode);
        Params params = new Params(goodNo,"3",good);

        ApiClient.doPostJson(urlQimen,null,null,params);
    }

}
