package test.erp.testcase.wmsMockFuchun;

import org.testng.annotations.Test;
import test.erp.testcase.wmsMockFuchun.dto.ParamsWms;
import test.erp.testcase.wmsMockFuchun.dto.sn.Product;
import test.erp.testcase.wmsMockFuchun.dto.sn.SnData;
import utils.client.apiclientDTO.ApiClient;
import utils.util.UtilsXml;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 11:21
 */
public class SnBackApi {
    String orderno = "DE1002630001";

    @Test
    public void snBack(){
        //组装商品
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123"));

        //组装bizdata
        SnData snData = new SnData(orderno,Data.warehouseCode,Data.ownerCode,"01",products);

        //组装请求参数
        ParamsWms params = new ParamsWms(UtilsXml.objToXml(snData), "wms.sn.update","1.0");

        //接口推送
        ApiClient.doPostForm(Data.URL,null,null,params);
    }

}
