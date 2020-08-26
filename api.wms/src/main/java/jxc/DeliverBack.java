package jxc;

import client.ApiClient;
import domainout.ParamsWms;
import domainout.deliver.DeliverData;
import domainout.deliver.Product;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/26 14:08
 */
public class DeliverBack {

    // 发货单回执
    @Test
    public void backDeliver() throws Exception {
        // 出库单编号
        String deliverOrderNo = "OB20200826135543817686";

        List<Product> products = new ArrayList<>();
        products.add(new Product("", "", 100, "", "", "ZP"));
        DeliverData deliverData = new DeliverData(deliverOrderNo, BaseParams.warehouseCode, "ZTO", 1.68, BaseParams.hzid, products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }

}
