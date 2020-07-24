package api;

import client.ApiClient;
import domain.ParamsWms;
import domain.ServiceType;
import domain.deliver.DeliverData;
import domain.deliver.Product;
import domain.stockin.BillType;
import domain.stockin.StockinData;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 17:35
 */
public class StockinBackApi {
    String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    ApiClient client = new ApiClient(url);

    String whCode = "01";
    String hzid = "GL01";
    String orderno = "PS100239901";

    //采购入库单回执
    @Test
    public void orderBack1() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123","000123",100,"2020-1-1","2023-6-6","ZP"));

        StockinData wmsRequestRoot = new StockinData(orderno,whCode,hzid, BillType.CAIGOU,products);

        ParamsWms param = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), ServiceType.STOCKIN_BACK,"1.0");

        client.doPostForm(param);
    }

}
