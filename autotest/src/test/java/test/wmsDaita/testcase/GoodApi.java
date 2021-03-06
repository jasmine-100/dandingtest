package test.wmsDaita.testcase;

import org.testng.annotations.Test;
import test.wmsDaita.testcase.dto.good.ErpSku;
import test.wmsDaita.testcase.dto.good.Good;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 17:08
 */
public class GoodApi {

    @Test
    public void more(){
        for (int i=0;i<2;i++){
            addGood();
        }
    }

    @Test
    public void addGood(){
        String skuCode = "JHY"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        List<ErpSku> skus = new ArrayList<>();
        skus.add(new ErpSku(Data.warehouseCode,Data.cargoCode,skuCode,"小面包","1","PANPAN","盼盼","-1","","10","20"));
        Good good = new Good(skus);

        ApiClient.doPostJson(Data.addGoodUrl,null,null,good);
    }
}
