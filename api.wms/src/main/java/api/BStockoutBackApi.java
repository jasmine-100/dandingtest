package api;

import client.ApiClient;
import domain.ParamsWms;
import domain.ServiceType;
import domain.outbound.OutboundData;
import domain.outbound.Product;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 10:59
 */
public class BStockoutBackApi {

    String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    ApiClient client = new ApiClient(url);

    String whCode = "TESTDEPOT001";
    String hzid = "GL01";
    String orderno = "JOB2020072401";

    //出库单回执
    @Test
    public void outboundBack() throws IOException {
        //组装商品
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123","100236",10,"2020-1-2","2020-9-1","ZP"));

        //组装bizdata
        OutboundData outboundData = new OutboundData(orderno,whCode,hzid,"SF","QTCK",1.68,products);

        //组装请求参数
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), ServiceType.OUTBOUND_BACK,"1.0");

        //接口推送
        client.doPostForm(param);

    }
}
