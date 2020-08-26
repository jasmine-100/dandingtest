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

    // 采购入口单回执
    @Test
    public void stockinBack() throws Exception {
        String stockinOrderNo = "ET20200826143926023902";
        List<Product> products = new LinkedList<>();
        products.add(new Product("HW001","",150));
        StockinData stockinData = new StockinData(stockinOrderNo,BaseParams.warehouseCode,BaseParams.hzid,"CGRKD","1",products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.purchaseorderinfo.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }
}
