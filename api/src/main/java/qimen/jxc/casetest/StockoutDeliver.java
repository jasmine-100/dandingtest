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
import wms.domain.deliver.DeliverData;
import wms.domain.deliver.Product;
import wms.jxc.BackStockout;
import wms.jxc.BaseParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/28 18:11
 */
public class StockoutDeliver {
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 发货单
    // 下单
    @Test
    public void deliverOrder() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("","SKU09021031",100,""));
        orderLines.add(new OrderLine("","SKU09021032",10,"20200902"));
        orderLines.add(new OrderLine("","SKU09021032",5,"20200900"));
        orderLines.add(new OrderLine("","SKU09021032",6,"20200901"));
        // 组装body的订单项
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK","LSBNV8LQYC", "黑店",orderLines,"SF",new SenderInfo(),new ReceiverInfo());
        // 组装body消息体
        RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
    }
    // 回执
    @Test
    public void backDeliver() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("SKU09021031", "", 100, "", "", "ZP"));
        products.add(new Product("SKU09021032", "20200902", 10, "", "", "ZP"));
        products.add(new Product("SKU09021032", "20200900", 5, "", "", "ZP"));
        products.add(new Product("SKU09021032", "20200901", 6, "", "", "ZP"));
        DeliverData deliverData = new DeliverData("OB20200902172912664555","GLB", "ZTO", 1.68, "GL01", products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }

}
