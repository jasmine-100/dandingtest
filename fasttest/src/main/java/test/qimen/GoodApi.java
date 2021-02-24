package test.qimen;

import org.testng.annotations.Test;
import test.qimen.dto.Param;
import test.qimen.dto.good.Good;
import test.qimen.dto.good.Item;
import utils.client.ApiClient;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 17:54
 */
public class GoodApi extends Data{

    @Test
    public void goodCreate(){
        Param param = new Param("singleitem.synchronize");

        String sku = "QSKU"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Good good = new Good("add",logicWarehouCode,ownerCode,new Item(sku,"泡腾片","SO"+sku));

        ApiClient.doPostXml(URL,param,null,good);
    }

}
