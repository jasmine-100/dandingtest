package wmsMockFuchun;

import client.ApiClient;
import org.testng.annotations.Test;
import utils.XmlUtil;
import wmsMockFuchun.dto.ParamsWms;
import wmsMockFuchun.dto.deliver.Product;
import wmsMockFuchun.dto.outbound.OutboundData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 10:59
 */
public class OrderOutboundApi {

    //出库单回执
    @Test
    public void outboundBack() throws IOException {
        //组装商品
        List<Product> products = new ArrayList<>();
        products.add(new Product("G1607667598237", "20201210", 10, "2020-1-2", "2020-9-1", "ZP"));

        //组装bizdata
        OutboundData outboundData = new OutboundData("OB202012112004590679193046", Data.whCode, Data.ownerCode, "SF", "QTCK", 1.68, products);

        //组装请求参数
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), "wms.issueorderinfo.update", "1.0");

        //接口推送
        ApiClient.doPostForm(Data.URL,param,null,null);

    }
}