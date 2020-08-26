package api;

import client.ApiClient;
import domainout.ParamsWms;
import domainout.ServiceType;
import domainout.deliver.Product;
import domainout.stockin.BillType;
import domainout.stockin.StockinData;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.LinkedList;
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
        String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
        String whCode = "01";
        String hzid = "GL01";
        String orderno = "PS100239902";

        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123", "000123", 100, "2020-1-1", "2023-6-6", "ZP"));

        StockinData wmsRequestRoot = new StockinData(orderno, whCode, hzid, BillType.CAIGOU, "0", products);

        ParamsWms param = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), ServiceType.STOCKIN_BACK, "1.0");

        ApiClient.doPostXml(url, param, null, null);
    }


}
