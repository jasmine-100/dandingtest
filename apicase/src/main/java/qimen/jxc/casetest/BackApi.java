package qimen.jxc.casetest;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import qimen.jxc.api.Data;
import qimen.jxc.api.StockinModel;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.DeliverData;
import wms.domain.deliver.Product;
import wms.jxc.BackStockin;
import wms.jxc.BackStockout;
import wms.jxc.BaseParams;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 15:38
 */
public class BackApi {

    @Test
    public static void backDelivers(String orderId,String sku,String batchCode,int qty,String batchValue1,String batchValue2,String inventoryType) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product(sku, batchCode, qty, batchValue1, batchValue2, inventoryType));
        DeliverData deliverData = new DeliverData(orderId, "", "ZTO", 1.68, BaseParams.hzid, products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }
    // 出库单回执
    @Test
    public void deliverBack() throws Exception {
        BackStockout.backDeliver("OB20200831164225566786","SKU08311328","",99,"","","ZP");
    }

    // 调拨出库
    @Test
    public void backDiaoboOut() throws Exception {
        BackStockout.backOutDiaobo("OB20200831155629230645","SKU08311329","20200810",10,"","","ZP");
    }
    @Test
    public void backDiaoboIn() throws Exception {
        BackStockin.backStockinDetail("LSHRGHWLRN","DBRKD","ET20200831155624062313","SKU08311329",10,1,"20200810","2020-08-11 10:00:50","2023-08-11 10:00:50","ZP",0);
    }

}
