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
public class StockinBack {
    String sku = "SKU08261503";

    /**
     * 采购入库单回执
     */
    @Test
    public void backPurStockin() throws Exception {
        String stockinOrderNo = "ET20200828103451109026";
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,"GW001",90,"2020-8-11","2020-8-12","ZP"));
        products.add(new Product(sku,"GW001",10,"2020-8-11","2020-8-12","CP"));
        StockinData stockinData = new StockinData(stockinOrderNo,BaseParams.warehouseCode,BaseParams.hzid,"CGRKD",0,1,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.purchaseorderinfo.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }
    /**
     * 退货入库单回执
     * @throws Exception
     */
    @Test
    public void backTuihuo() throws Exception {
        String stockinOrderNo = "ET20200828095715359400";
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,"20200811",100,"2020-8-11","2020-8-12","ZP"));
        StockinData stockinData = new StockinData(stockinOrderNo,BaseParams.warehouseCode,BaseParams.hzid,"SOTHRKD",0,1,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

    /**
     * 调拨入库单回执
     * @throws Exception
     */
    @Test
    public void backDiaobo() throws Exception {
        String stockinOrderNo = "ET20200828095724917016";
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,"20200811",1001,"2020-8-11","2020-8-12","ZP"));
        StockinData stockinData = new StockinData(stockinOrderNo,BaseParams.warehouseCode,BaseParams.hzid,"DBRKD",0,1,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

}
