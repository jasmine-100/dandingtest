package qimen.jxc.casetest;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import qimen.domain.Param;
import qimen.domain.deliver.DeliveryOrder;
import qimen.domain.deliver.OrderLine;
import qimen.domain.deliver.ReceiverInfo;
import qimen.domain.deliver.RequestOrderDeliver;
import qimen.domain.stockin.SenderInfo;
import qimen.jxc.api.Data;
import qimen.jxc.api.OrderStockout;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.Product;
import wms.domain.outbound.OutboundData;
import wms.jxc.BackStockout;
import wms.jxc.BaseParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 10:25
 */
public class StockoutDiaobo {
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    @Test
    // 下单
    public void diaoboOrder() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("","SKU09090853",10,""));
        orderLines.add(new OrderLine("","SKU09090854",10,"20200901"));
        orderLines.add(new OrderLine("","SKU09090854",10,"20200902"));
        // 组装body的订单项
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"DBCK","LSS6TSGHGT", "谁的店",orderLines,"SF",new SenderInfo(),new ReceiverInfo());
        // 组装body消息体
        RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);
        ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
    }

    @Test
    // 调拨出库单回执
    public void backOutDiaobo() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("SKU09090853", "", 10, "", "", "ZP"));
//        products.add(new Product("SKU09090853", "", 100, "", "", "CP"));
        products.add(new Product("SKU09090854", "20200901", 10, "","", "ZP"));
        products.add(new Product("SKU09090854", "20200902", 10, "","", "ZP"));
//        products.add(new Product("SKU09021657", "20200902", 100, "","", "CP"));
        OutboundData outboundData = new OutboundData("OB20200909095813191796", "LSS6TSGHGT", "GL01","ZTO","DBCKD",1.68 ,products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }
}
