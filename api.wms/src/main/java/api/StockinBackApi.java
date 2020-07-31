package api;

import client.ApiClient;
import com.google.protobuf.Api;
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

    //采购入库单回执
    @Test
    public void orderBack1() throws IOException {
        String url = "http://depottest.yang800.cn/xhr/depot/message/fuchun/1.0/FUCHUN/receive";
        ApiClient client = new ApiClient(url);

        String whCode = "01";
        String hzid = "GL01";
        String orderno = "PS100239902";


        List<Product> products = new ArrayList<>();
        products.add(new Product("JHK000123","000123",100,"2020-1-1","2023-6-6","ZP"));

        StockinData wmsRequestRoot = new StockinData(orderno,whCode,hzid, BillType.CAIGOU,"0",products);

        ParamsWms param = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), ServiceType.STOCKIN_BACK,"1.0");

        client.doPostForm(param);
    }

    /**
     * 入库单回执--进销存
     * @throws IOException
     */
    @Test
    public void orderBack2() throws Exception {
        String url = "http://hwms-notify-fat.yang800.com/dt/notify";
        String whCode = "01";
        String hzid = "GL01";
        String orderno = "jos132156165";

        List<Product> products = new ArrayList<>();
        products.add(new Product("xhs950001","000123",10,"2020-1-1","2023-6-6","ZP"));

        StockinData wmsRequestRoot = new StockinData(orderno,whCode,hzid, BillType.CAIGOU,"0",products);

        ParamsWms param = new ParamsWms(XmlUtil.objToXml(wmsRequestRoot), ServiceType.STOCKIN_BACK,"1.0");

        System.out.println(param);
        ApiClient.doPostXml(url,param,null,null);
    }

}
