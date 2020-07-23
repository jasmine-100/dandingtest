package api;

import client.ApiClient;
import domain.ServiceName;
import domain.wmsback.BillType;
import domain.wmsback.ParamsWms;
import domain.wmsback.Product;
import domain.wmsback.WmsRequestRoot;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 17:12
 */
public class StockinWmsBackApi {
    String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
    ApiClient client = new ApiClient(url);

    String whCode = "TESTDEPOT001";
    String hzid = "GL01";
    String orderno = "JY100237";

    //采购入库单回执
    @Test
    public void orderBack1() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123","000123",100,"ZP"));

        WmsRequestRoot wmsRequestRoot = new WmsRequestRoot(orderno,whCode,hzid, BillType.CAIGOU,products);

        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), ServiceName.STOCKIN_BACK,"1.0");

        client.doPostForm(paramsWms);
    }


    //换货入库单回执
    @Test
    public void orderBack2() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123","000123",100,"ZP"));

        WmsRequestRoot wmsRequestRoot = new WmsRequestRoot(orderno,whCode,hzid, BillType.HUANHUO,products);

        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), ServiceName.STOCKIN_BACK,"1.0");

        client.doPostForm(paramsWms);
    }

    //退货和其他入库单回执
    @Test
    public void orderBack3() throws IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123","000123",100,"ZP"));

        WmsRequestRoot wmsRequestRoot = new WmsRequestRoot(orderno,whCode,hzid, BillType.OTHER,products);

        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), ServiceName.STOCKIN_BACK,"1.0");

        client.doPostForm(paramsWms);
    }

}
