package api;

import client.ApiClient;
import domain.OrderType;
import domain.Param;
import domain.stockin.EntryOrder;
import domain.stockin.OrderData;
import domain.stockin.OrderLine;
import org.junit.Test;
import utils.XmlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :  奇门接口推送采购入库单
 * @Date : Created in 2020/7/24 13:43
 */
public class StockinApi {
    String url = "http://outtest.order.yang800.cn/qimen/api";

    String whCode = "01";
    String ownerCode = "DS15712047230632";
    String orderno = "STI030000";

    @Test
    public void orderSet() throws Exception {
        //组装商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(ownerCode,"052903",10,"ZP"));

        //组装订单项
        EntryOrder entryOrder = new EntryOrder(orderno,ownerCode,whCode,"CGRK","123");

        //组装请求body
        OrderData orderData = new OrderData(entryOrder,orderLines);

        //组装接口头信息
        Param param = new Param(OrderType.STOCKIN,"C1590459235731");

        ApiClient.doPostXml(url,param,null, XmlUtil.objToXml(orderData));

    }

}
