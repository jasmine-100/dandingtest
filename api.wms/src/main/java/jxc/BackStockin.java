package jxc;

import client.ApiClient;
import domainout.ParamsWms;
import domainout.deliver.Product;
import domainout.stockin.StockinData;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/26 14:05
 */
public class BackStockin {
    // 入库单编号
    String stockinOrderNo = "ET20200828112826879288";
    // 入库商品sku
    String sku = "SKU08261503";
    /**
     * 采购入库单回执
     */
    @Test
    public void backPurStockin() throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,"20200811",10,"2020-08-11 11:49:50","2022-8-12 11:49:50","CP"));
        StockinData stockinData = new StockinData(stockinOrderNo,BaseParams.warehouseCode,BaseParams.hzid,"CGRKD",0,2,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.purchaseorderinfo.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }
    /**
     * 退货入库单回执
     * @throws Exception
     */
    @Test
    public void backTuihuo() throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,"20200817",17,"2020-08-11 11:49:50","2022-8-12 11:49:50","ZP"));
        products.add(new Product(sku,"20200818",8,"2020-08-30 11:49:50","2025-8-12 11:49:50","CP"));
        StockinData stockinData = new StockinData(stockinOrderNo,BaseParams.warehouseCode,BaseParams.hzid,"SOTHRKD",0,10,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

    /**
     * 调拨入库单回执
     * @throws Exception
     */
    @Test
    public void backDiaobo() throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,"20200813",90,"2020-08-11 11:49:50","2022-8-12 11:49:50","ZP"));
        products.add(new Product(sku,"20200814",10,"2020-08-11 11:49:50","2022-8-12 11:49:50","CP"));
        StockinData stockinData = new StockinData(stockinOrderNo,BaseParams.warehouseCode,BaseParams.hzid,"DBRKD",0,1,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

}
