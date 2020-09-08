package wms.jxc;

import client.ApiClient;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.Product;
import wms.domain.stockin.StockinData;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/26 14:05
 */
public class BackStockin {

    /**
     * 采购入库单回执
     */
    public static void backStockin(String billType,String orderId,String sku,int num,int batchNo,String batchCode,String batchValue1,String batchValue2,String inventoryType,int confirm) throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));
        StockinData stockinData = new StockinData(orderId,BaseParams.warehouseCode,BaseParams.hzid,billType,confirm,batchNo,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

    public static void backStockinDetail(String whcode,String billType,String orderId,String sku,int num,int batchNo,String batchCode,String batchValue1,String batchValue2,String inventoryType,int confirm) throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));
        StockinData stockinData = new StockinData(orderId,whcode,BaseParams.hzid,billType,confirm,batchNo,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

//    /**
//     * 退货入库单回执
//     * @throws Exception
//     */
//    public static void backTuihuo(String orderId,String sku,int num,int batchNo,String batchCode,String batchValue1,String batchValue2,String inventoryType,int confirm) throws Exception {
//        List<Product> products = new LinkedList<>();
//        products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));
//        StockinData stockinData = new StockinData(orderId,BaseParams.warehouseCode,BaseParams.hzid,"SOTHRKD",confirm,batchNo,products);
//        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");
//        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
//    }
//
//    /**
//     * 调拨入库单回执
//     * @throws Exception
//     */
//    public static void backDiaobo(String orderId, String sku, int num, int batchNo, String batchCode, String batchValue1, String batchValue2, String inventoryType, int confirm) throws Exception {
//        List<Product> products = new LinkedList<>();
//        products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));
//        StockinData stockinData = new StockinData(orderId,BaseParams.warehouseCode,BaseParams.hzid,"DBRKD",confirm,batchNo,products);
//        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");
//        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
//    }

}
