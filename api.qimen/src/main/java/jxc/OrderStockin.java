package jxc;

import client.ApiClient;
import domainout.stockin.OrderLine;
import domainout.Param;
import domainout.returnorder.RequestOrderReturn;
import domainout.returnorder.ReturnOrder;
import domainout.stockin.*;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :奇门接口--采购入库单
 * @Date : Created in 2020/7/24 13:43
 */
public class OrderStockin {

    /**
     * 采购入库单
     * @throws Exception
     */
    public static void orderPurchase(String sku,int num,String orderno) throws Exception {
        //组装商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(sku, num, ""));
        //组装订单项
        EntryOrder entryOrder = new EntryOrder(orderno, Data.whCode, "CGRK", "S200827133843428257");
        //组装请求body
        OrderData orderData = new OrderData(entryOrder, orderLines);

        ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
    }

    /**
     * 退货入库单
     * @throws Exception
     */
    public static void orderTuihuo(String sku,int num,String orderno) throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("",sku,num,"",""));
        // 组装body的订单项
        ReturnOrder returnOrder = new ReturnOrder(orderno,Data.whCode,"THRK","",new SenderInfo("浙江省","杭州市","西湖区"));
        // 组装body消息体
        RequestOrderReturn request = new RequestOrderReturn(returnOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("returnorder.create",Data.customerId),null, XmlUtil.objToXml(request));
    }

    /**
     * 调拨入库单
     * 说明：和采购入库单一样，orderType不同
     */
    public static void orderDiaobo(String sku,int num,String orderno) throws Exception {
        //组装商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(sku, num, ""));
        //组装订单项
        EntryOrder entryOrder = new EntryOrder(orderno, Data.whCode, "DBRK", "S200827133843428257");
        //组装请求body
        OrderData orderData = new OrderData(entryOrder, orderLines);

        ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
    }
}
