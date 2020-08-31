package jxc;

import client.ApiClient;
import domainout.Param;
import domainout.deliver.*;
import domainout.stockin.SenderInfo;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 奇门接口-发货出库单
 * @Date : Created in 2020/7/27 9:54
 */
public class OrderStockout {

    /**
     * 发货单出库
     * @throws Exception
     */
    public static void deliverOrder(String orderno,String shopNick,String sku,String batchCode,int qty) throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("",sku,qty,batchCode));
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
    public static void outboundOrder(String orderno,String shopNick,String sku,String batchCode,int qty) throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("",sku,qty,batchCode));
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
    public static void diaoboOrder(String orderno,String shopNick,String sku,String batchCode,int qty) throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("",sku,qty,batchCode));
        // 组装body的订单项
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"DBCK",Data.whCode, shopNick,orderLines,"SF",new SenderInfo(),new ReceiverInfo());
        // 组装body消息体
        RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
    }

    /**
     * @Author jasmine
     * @Desc 奇门接口--取消订单
     */
    public static void orderCancel (String orderCode) throws Exception {
        // 接口参数
        Param param = new Param("order.cancel",Data.customerId);
        System.out.println(param);
        // 接口消息体
        Cancel cancel = new Cancel(orderCode,"JYCK",Data.whCode, "");
        System.out.println(XmlUtil.objToXml(cancel));

        ApiClient.doPostXml(Data.url,param,null,XmlUtil.objToXml(cancel));
    }

}
