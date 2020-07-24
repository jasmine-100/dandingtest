package api;

import client.ApiClient;
import domain.deliverback.Params;
import domain.deliverback.Product;
import domain.deliverback.WmsRequestRoot;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : WMS回执发货单回执
 * @Date : Created in 2020/7/22 17:11
 */
public class DeliverBackApi {

    @Test
    public void orderBack() throws IOException {
        //组装商品项
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("NF07061102","",10,"ZP"));

        //组装bizdata
        WmsRequestRoot wmsRequestRoot = new WmsRequestRoot("OB20200722183931349259","LSVUACUHBM","SF",productList);
//        System.out.println(XmlUtil.objToXml(wmsRequestRoot));

        Params params = new Params("1.0","wms.saleorderinfo.update",XmlUtil.objToXml(wmsRequestRoot).toString());

        String url = "http://hwms-notify-fat.yang800.com/dt/notify";
        ApiClient client = new ApiClient(url);
        client.doPostForm(params);
    }


}