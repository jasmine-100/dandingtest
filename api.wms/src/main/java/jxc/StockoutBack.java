package jxc;

import client.ApiClient;
import domainout.ParamsWms;
import domainout.deliver.DeliverData;
import domainout.deliver.Product;
import domainout.outbound.OutboundData;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/26 15:40
 */
public class StockoutBack {
    // 出库单编号
    String orderId = "OB20200826135543817686";
    // 出库商品sku编码
    String sku = "";

    // 销售单回执（B单和C单回执通用）
    @Test
    public void backDeliver() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(sku, "", 100, "", "", "ZP"));
        DeliverData deliverData = new DeliverData(orderId, BaseParams.warehouseCode, "ZTO", 1.68, BaseParams.hzid, products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }

    // 调拨出库单回执
    @Test
    public void backOutDiaobo() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(sku, "", 10, "", "", "ZP"));
        OutboundData outboundData = new OutboundData(orderId, BaseParams.warehouseCode, BaseParams.hzid,"ZTO","DBCKD",1.68 ,products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }

}
