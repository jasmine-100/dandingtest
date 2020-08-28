package apijxc;

import client.ApiClient;
import domainout.Param;
import domainout.deliver.*;
import domainout.stockin.SenderInfo;
import org.junit.Test;
import utils.XmlUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 奇门接口-发货出库单
 * @Date : Created in 2020/7/27 9:54
 */
public class OrderStockout {

    //外部订单号，相同货主内唯一
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    //进销存存在的店铺名称
    String shopNick = "jasmine的小店";
    // 商品编码
    String sku = "sku08260904";
    String batchCode = "20200811";
    int planQty = 100;

    /**
     * 发货单出库
     * @throws Exception
     */
    @Test
    public void deliverOrder() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(orderno,Data.ownerCode,sku,"", planQty,batchCode));
        // 组装body的订单项
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK",Data.whCode, shopNick,orderLines,"SF",new SenderInfo(),new ReceiverInfo());
        // 组装body消息体
        RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
    }

    /**
     * 发货单物流公司使用德邦，即自动转换为批发出库单
     * @throws Exception
     */
    @Test
    public void outboundOrder() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(orderno,Data.ownerCode,sku,"",planQty,batchCode));
        // 组装body的订单项
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK",Data.whCode, shopNick,orderLines,"DBL",new SenderInfo(),new ReceiverInfo());
        // 组装body消息体
        RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
    }

    /**
     * 调拨出库单：和发货单一样，改一下ordertype
     * @throws Exception
     */
    @Test
    public void diaoboOrder() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(orderno,Data.ownerCode,sku,"",planQty,batchCode));
        // 组装body的订单项
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"QTCK",Data.whCode, shopNick,orderLines,"SF",new SenderInfo(),new ReceiverInfo());
        // 组装body消息体
        RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
    }

    /**
     * @Author jasmine
     * @Desc 奇门接口--取消订单
     */
    @Test
    public void orderCancel () throws Exception {
        // 接口参数
        Param param = new Param("order.cancel",Data.customerId);
        // 接口消息体
        Cancel cancel = new Cancel(orderno,"JYCK",Data.whCode, Data.ownerCode);

        ApiClient.doPostXml(Data.url,param,null,XmlUtil.objToXml(cancel));
    }

}
