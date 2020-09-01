package qimen.jxc.casetest;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import qimen.jxc.api.Data;
import qimen.jxc.api.StockinModel;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.DeliverData;
import wms.domain.deliver.Product;
import wms.domain.stockin.StockinData;
import wms.jxc.BackStockin;
import wms.jxc.BackStockout;
import wms.jxc.BaseParams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 15:38
 */
public class BackApi {
    // 采购入库单回执
    @Test
    public void stockinBack() throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product("sku","",100,"","","ZP"));
        StockinData stockinData = new StockinData("","","GL01","CGRK",0,1,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }

    // 发货单回执
    @Test
    public static void backDelivers() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("SKU08311329", "batchCode", 100, "", "", "ZP"));
        DeliverData deliverData = new DeliverData("", "", "ZTO", 1.68, BaseParams.hzid, products);
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
        BackStockin.backStockinDetail("LSHRGHWLRN","DBRKD","ET20200901105000339288","SKU08311328",100,1,"","","","ZP",0);
    }

}
