package api;

import client.ApiClient;
import domainout.ParamsWms;
import domainout.ServiceType;
import domainout.sn.OrderType;
import domainout.sn.Product;
import domainout.sn.SnData;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 11:21
 */
public class SnBackApi {
    String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    ApiClient client = new ApiClient(url);

    String whCode = "01";
    String hzid = "GL01";
    String orderno = "DE1002630001";

    @Test
    public void snBack() throws IOException {
        //组装商品
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123"));

        //组装bizdata
        SnData snData = new SnData(orderno,whCode,hzid, OrderType.STOCKIN,products);

        //组装请求参数
        ParamsWms params = new ParamsWms(XmlUtil.objToXml(snData), ServiceType.SN_BACK,"1.0");

        //接口推送
        client.doPostForm(params);
    }

}
