package api;

import client.ApiClient;
import dto.Good.ErpSku;
import dto.Good.Good;
import org.testng.annotations.Test;

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
    public void addGood(){
        String skuCode = "JHY"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<ErpSku> skus = new ArrayList<>();
        skus.add(new ErpSku(Data.warehouseCode,Data.cargoCode,skuCode,"小面包","1","PANPAN","盼盼","1","150","10","20"));
        Good good = new Good(skus);

        ApiClient.doPostJson(Data.addGoodUrl,null,null,good);

    }
}
