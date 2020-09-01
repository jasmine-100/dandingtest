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
public class CaseStockoutDeliver {
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 发货出库单--无批次--下单
    @Test
    public void deliver() throws Exception {
        OrderStockout.deliverOrder(orderno, Data.shopNick,Data.sku,"",100);
        System.out.println(orderno);
    }
    // 回传
    @Test
    public void deliverBack() throws Exception {
        BackStockout.backDeliver("OB20200901172116083169",Data.sku,"",100,"","","ZP");
    }

    // 有批次--下单
    @Test
    public void deliverBatch() throws Exception {
        OrderStockout.deliverOrder(orderno,Data.shopNick,Data.skuBatch,"",100);
        System.out.println(orderno);
    }
    // 回传
    @Test
    public void deliverBackBatch() throws Exception {
        BackStockout.backDeliver("OB20200831150037390820",Data.skuBatch,Data.batch,9,"","","ZP");
    }

    // 取消c单和B单
    @Test
    public void cancel () throws Exception {
        OrderStockout.orderCancel("QM20200831150155873");
    }

    // 发货单
    // 下单
    @Test
    public void deliverOrder() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("","SKU09011642",10,""));
        orderLines.add(new OrderLine("","SKU09011645",12,"20200901"));
        orderLines.add(new OrderLine("","SKU09011512",8,"20200901"));
        // 组装body的订单项
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK","LSBNV8LQYC", "我的店",orderLines,"SF",new SenderInfo(),new ReceiverInfo());
        // 组装body消息体
        RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
    }
    // 回执
    @Test
    public void backDeliver() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("SKU09011642", "", 10, "", "", "ZP"));
        products.add(new Product("SKU09011645", "20200901", 12, "", "", "ZP"));
        products.add(new Product("SKU09011512", "20200901", 8, "", "", "ZP"));
        DeliverData deliverData = new DeliverData("OB20200901174524721188","GLB", "ZTO", 1.68, "GL01", products);
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), "wms.saleorderinfo.update", "1.0");
        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
    }

}
