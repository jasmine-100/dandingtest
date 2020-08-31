package wms.jxc;

import client.ApiClient;
import wms.domain.ParamsWms;
import wms.domain.deliver.DeliverData;
import wms.domain.deliver.Product;
import wms.domain.outbound.OutboundData;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/26 15:40
 */
public class BackStockout {

    // 销售单回执（B单和C单回执通用）
    public static void backDeliver(String orderId,String sku,String batchCode,int qty,String batchValue1,String batchValue2,String inventoryType) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(sku, batchCode, qty, batchValue1, batchValue2, inventoryType));
        DeliverData deliverData = new DeliverData(orderId, BaseParams.warehouseCode, "ZTO", 1.68, BaseParams.hzid, products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }

    // 调拨出库单回执
    public static void backOutDiaobo(String orderId,String sku,String batchCode,int qty,String batchValue1,String batchValue2,String inventoryType) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(sku, batchCode, qty, batchValue1, batchValue2, inventoryType));
        OutboundData outboundData = new OutboundData(orderId, BaseParams.warehouseCode, BaseParams.hzid,"ZTO","DBCKD",1.68 ,products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }

}
