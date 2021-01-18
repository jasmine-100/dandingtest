package wmsMockFuchun;

import client.ApiClient;
import org.testng.annotations.Test;
import utils.UtilsXml;
import wmsMockFuchun.dto.ParamsWms;
import wmsMockFuchun.dto.deliver.DeliverData;
import wmsMockFuchun.dto.deliver.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 9:01
 */
public class OrderDeliverApi {

    //发货单回执--奇门接口
    @Test
    public void deliverBack() throws Exception {
        String orderno = "DE1002630001";

        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123", "100236", 10, "2020-1-2", "2020-9-1", "ZP"));

        //组装bizdata
        DeliverData deliverData = new DeliverData(orderno, Data.warehouseCode, "ZTO", 1.68, Data.ownerCode, products);

        //组装请求参数
        ParamsWms param = new ParamsWms(UtilsXml.objToXml(deliverData), "wms.cstockout.update", "1.0");

        System.out.println(param);
        ApiClient.doPostForm(Data.URL, param, null, null);
    }

}
