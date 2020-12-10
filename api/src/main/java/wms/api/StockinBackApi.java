package wms.api;

import client.ApiClient;
import org.testng.annotations.Test;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.ServiceType;
import wms.domain.deliver.Product;
import wms.domain.stockin.BillType;
import wms.domain.stockin.StockinData;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 17:35
 */
public class StockinBackApi {

    //采购入库单回执
    @Test
    public void orderBack1() throws Exception {
        String orderno = "PS100239902";

        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123", "000123", 100, "2020-1-1", "2023-6-6", "ZP"));

        StockinData wmsRequestRoot = new StockinData(orderno, Data.whCode, Data.ownerCode, "CGRK", 1,1, products);

        ParamsWms param = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), "wms.stockin.update", "1.0");

        ApiClient.doPostXml(Data.URL, param, null, null);
    }


}
