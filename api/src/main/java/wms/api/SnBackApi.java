package wms.api;

import client.ApiClient;
import org.testng.annotations.Test;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.ServiceType;
import wms.domain.sn.OrderType;
import wms.domain.sn.Product;
import wms.domain.sn.SnData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 11:21
 */
public class SnBackApi {

    String whCode = "01";
    String hzid = "GL01";
    String orderno = "DE1002630001";

    @Test
    public void snBack() throws IOException {
        //组装商品
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123"));

        //组装bizdata
        SnData snData = new SnData(orderno,Data.whCode,Data.ownerCode,"01",products);

        //组装请求参数
        ParamsWms params = new ParamsWms(XmlUtil.objToXml(snData), "wms.sn.update","1.0");

        //接口推送
        ApiClient.doPostForm(Data.URL,null,null,params);
    }

}
