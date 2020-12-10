package wmsMockFuchun;

import client.ApiClient;
import org.testng.annotations.Test;
import utils.XmlUtil;
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
public class StockinBackApi {

    //采购入库单回执
    @Test
    public void orderBack1() throws Exception {

        List<Product> products = new ArrayList<>();
        products.add(new Product("G1607425274829", "201033", 10, "2020-1-1", "2023-6-6", "ZP"));

        StockinData wmsRequestRoot = new StockinData("ET202012101050120753597824", Data.whCode, Data.ownerCode, "CGRK", 1,1, products);

        ParamsWms param = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), "wms.stockin.update", "1.0");

        ApiClient.doPostXml(Data.URL, param, null, null);
    }

}
