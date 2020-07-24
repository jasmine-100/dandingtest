package api;

import client.ApiClient;
import domain.ParamsWms;
import domain.ServiceType;
import domain.deliver.Product;
import domain.deliver.DeliverData;
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
public class DeliverBackApi {
    String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    ApiClient client = new ApiClient(url);

    String whCode = "01";
    String hzid = "GL01";
    String orderno = "DE1002630001";

    //发货单回执
    @Test
    public void deliverBack() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123","100236",10,"2020-1-2","2020-9-1","ZP"));

        //组装bizdata
        DeliverData deliverData = new DeliverData(orderno,whCode,"ZTO",1.68,hzid,products);

        //组装请求参数
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), ServiceType.DELIVER_BACK,"1.0");

        client.doPostForm(param);

    }

}
