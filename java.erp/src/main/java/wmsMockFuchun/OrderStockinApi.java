package wmsMockFuchun;

import client.ApiClient;
import org.testng.annotations.Test;
import utils.UtilsXml;
import wmsMockFuchun.dto.ParamsWms;
import wmsMockFuchun.dto.deliver.Product;
import wmsMockFuchun.dto.stockin.StockinData;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 17:35
 */
public class OrderStockinApi {

    //采购入库单回执
    @Test
    public void orderBack1() {

        List<Product> products = new ArrayList<>();
        products.add(new Product("G1607589928737", "201033", 10, "2020-1-1", "2023-6-6", "1"));

        StockinData wmsRequestRoot = new StockinData("ET202012111046300776613457", Data.whCode, Data.ownerCode, "CGRK", 1,1, products);

        ParamsWms param = new ParamsWms(UtilsXml.objToXml(wmsRequestRoot), "wms.purchaseorderinfo.update", "1.0");

        ApiClient.doPostForm(Data.URL, param, null, null);
    }

}
