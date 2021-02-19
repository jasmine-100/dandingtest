package erp.wmsMockFuchun;

import client.ApiClient;
import erp.wmsMockFuchun.dto.ParamsWms;
import erp.wmsMockFuchun.dto.deliver.Product;
import erp.wmsMockFuchun.dto.stockin.StockinData;
import org.testng.annotations.Test;
import Utils.UtilsXml;

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
        products.add(new Product("SKU2101141457", "201033001", 2000, "2021-01-01", "2021-01-31", "ZP"));

        StockinData wmsRequestRoot = new StockinData("ET202101181752480793064403", Data.warehouseCode, Data.ownerCode, "CGRK", 0,1, products);

        ParamsWms param = new ParamsWms(UtilsXml.objToXml(wmsRequestRoot), "wms.purchaseorderinfo.update", "1.0");

        ApiClient.doPostForm(Data.URL, param, null, null);
    }

}