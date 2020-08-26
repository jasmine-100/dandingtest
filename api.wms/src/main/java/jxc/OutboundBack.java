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
 * @Date : Created in 2020/8/26 14:22
 */
public class OutboundBack {

    // 出库单回执
    @Test
    public void backOutbound() throws Exception {
        // 出库单编号
        String outboundOrderNo = "OB20200826141416395008";

        List<Product> products = new ArrayList<>();
        products.add(new Product("HW001", "", 100, "", "", "ZP"));
        OutboundData outboundData = new OutboundData(outboundOrderNo,BaseParams.warehouseCode,BaseParams.hzid,"ZTO","PFCKD",1.68,products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }
}
