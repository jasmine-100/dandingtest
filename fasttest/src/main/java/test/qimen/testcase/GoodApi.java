package test.qimen.testcase;

import org.testng.annotations.Test;
import test.qimen.testcase.dto.Param;
import test.qimen.testcase.dto.good.Good;
import test.qimen.testcase.dto.good.Item;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :同步货品的接口
 * @Date : Created in 2021/2/24 17:54
 */
public class GoodApi extends Data{

    @Test
    public void goodCreate(){
        Param param = new Param("singleitem.synchronize");

        String sku = "QSKU"+new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        Good good = new Good("add",logicWarehouseCode,ownerCode,new Item(sku,"苹果手机","SO"+sku));

        ApiClient.doPostXml(URL,param,null,good);
    }

}
