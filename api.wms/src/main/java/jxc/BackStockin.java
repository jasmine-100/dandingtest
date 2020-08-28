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
    String stockinOrderNo = "ET20200828154919990727";
    // 入库商品sku
    String sku = "sku08281548";

    /**
     * 采购入库单回执
     */
    public static void backPurStockin(String orderId,String sku,int num,int batchNo,String batchCode,String batchValue1,String batchValue2,String inventoryType,int confirm) throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));
//        products.add(new Product(sku,"20200811",700,"2020-08-11 11:49:50","2022-8-12 11:49:50","ZP"));
        StockinData stockinData = new StockinData(orderId,BaseParams.warehouseCode,BaseParams.hzid,"CGRKD",confirm,batchNo,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.purchaseorderinfo.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

    /**
     * 退货入库单回执
     * @throws Exception
     */
    public static void backTuihuo(String orderId,String sku,int num,int batchNo,String batchCode,String batchValue1,String batchValue2,String inventoryType,int confirm) throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));
        StockinData stockinData = new StockinData(orderId,BaseParams.warehouseCode,BaseParams.hzid,"SOTHRKD",confirm,batchNo,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

    /**
     * 调拨入库单回执
     * @throws Exception
     */
    public static void backDiaobo(String orderId, String sku, int num, int batchNo, String batchCode, String batchValue1, String batchValue2, String inventoryType, int confirm) throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));
        StockinData stockinData = new StockinData(orderId,BaseParams.warehouseCode,BaseParams.hzid,"DBRKD",confirm,batchNo,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

}
