package wms.api;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.ServiceType;
import wms.domain.deliver.Product;
import wms.domain.outbound.OutboundData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 10:59
 */
public class OutboundBackApi {

    String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    ApiClient client = new ApiClient(url);

    String whCode = "01";
    String hzid = "GL01";
    String orderno = "JOB2020001";

    //出库单回执
    @Test
    public void outboundBack() throws IOException {
//组装商品
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123", "100236", 10, "2020-1-2", "2020-9-1", "ZP"));

//组装bizdata
        OutboundData outboundData = new OutboundData(orderno, whCode, hzid, "SF", "QTCK", 1.68, products);

//组装请求参数
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), ServiceType.OUTBOUND_BACK, "1.0");

        //接口推送
        client.doPostForm(param);

    }
}
