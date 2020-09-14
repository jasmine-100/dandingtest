package qimen.jxc.casetest;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import qimen.domain.Param;
import qimen.domain.returnorder.RequestOrderReturn;
import qimen.domain.returnorder.ReturnOrder;
import qimen.domain.stockin.OrderLine;
import qimen.domain.stockin.SenderInfo;
import qimen.jxc.api.Data;
import qimen.jxc.api.OrderStockin;
import qimen.jxc.api.StockinModel;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.Product;
import wms.domain.stockin.StockinData;
import wms.jxc.BaseParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 9:53
 */
public class StockinTuihuo {
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 下单
    @Test
    public void orderTuihuo() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("","SKU09090853",1000,"",""));
        orderLines.add(new OrderLine("","SKU09090854",1000,"",""));
        // 组装body的订单项
        ReturnOrder returnOrder = new ReturnOrder(orderno,"LSS6TSGHGT","THRK","",new SenderInfo("浙江省","杭州市","西湖区"));
        // 组装body消息体
        RequestOrderReturn request = new RequestOrderReturn(returnOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("returnorder.create",Data.customerId),null, XmlUtil.objToXml(request));
    }

    // 回执
    @Test
    public void backStockin() throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product("SKU09090853","",1000,"","","ZP"));
        products.add(new Product("SKU09090853","",10,"","","CP"));
        products.add(new Product("SKU09090854","20200901",500,"2020-10-10 10:00:20","2025-10-10 10:00:20","ZP"));
        products.add(new Product("SKU09090854","20200902",300,"2020-10-10 10:00:20","2025-10-10 10:00:20","ZP"));
        products.add(new Product("SKU09090854","20200903",200,"2020-10-10 10:00:20","2025-10-10 10:00:20","ZP"));
        products.add(new Product("SKU09090854","20200904",10,"2020-10-10 10:00:20","2025-10-10 10:00:20","CP"));
        StockinData stockinData = new StockinData("ET20200909095338132551", "LSS6TSGHGT","GL01","SOTHRKD",0,1,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }
}