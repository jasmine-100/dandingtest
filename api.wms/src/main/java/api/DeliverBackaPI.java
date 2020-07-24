package api;

import client.ApiClient;
import domain.ParamsWms;
import domain.ServiceType;
import domain.deliver.Product;
import domain.deliver.WmsRequestRoot;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 9:01
 */
public class DeliverBackaPI {
    String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    ApiClient client = new ApiClient(url);

    String whCode = "TESTDEPOT001";
    String hzid = "GL01";
    String orderno = "JY100237";

    //发货单回执
    @Test
    public void deliverBack() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("sku123","100236",10,"2020-1-2","2020-9-1","ZP"));

        //组装bizdata
        WmsRequestRoot wmsRequestRoot = new WmsRequestRoot(orderno,whCode,"ZTO",1.68,hzid,products);

        //组装请求参数
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), ServiceType.STOCKIN_BACK,"1.0");

        client.doPostForm(paramsWms);

    }

}
