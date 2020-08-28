package apijxc;

import client.ApiClient;
import domainout.Method;
import domainout.Param;
import domainout.returnorder.RequestOrderReturn;
import domainout.returnorder.ReturnOrder;
import domainout.stockin.*;
import org.junit.Test;
import utils.XmlUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :奇门接口--采购入库单
 * @Date : Created in 2020/7/24 13:43
 */
public class OrderStockin {
    //外部订单号，相同货主内唯一
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    String expressCode = "YT"+new Random().nextInt(999999);
    String sku = "";
    /**
     * 采购入库单
     * @throws Exception
     */
    @Test
    public void orderSet() throws Exception {
        //组装商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(Data.ownerCode, sku, 100, "ZP"));
        //组装订单项
        EntryOrder entryOrder = new EntryOrder(orderno, Data.ownerCode, Data.whCode, "CGRK", "S200827133843428257");
        //组装请求body
        OrderData orderData = new OrderData(entryOrder, orderLines);

        ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
    }

    /**
     * 退货入库单
     * @throws Exception
     */
    @Test
    public void order() throws Exception {
        // 组装body的商品项
        List<domainout.deliver.OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new domainout.deliver.OrderLine(Data.ownerCode,sku,"ZP",100));
        // 组装body的订单项
        ReturnOrder returnOrder = new ReturnOrder(orderno,Data.whCode,"THRK",expressCode,new SenderInfo("浙江省","杭州市","西湖区"));
        // 组装body消息体
        RequestOrderReturn request = new RequestOrderReturn(returnOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("returnorder.create",Data.customerId),null, XmlUtil.objToXml(request));
    }

    /**
     * 调拨入库单
     * 说明：和采购入库单一样，orderType不同
     */
    @Test
    public void orderDiaobo() throws Exception {
        //组装商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(Data.ownerCode, sku, 1001, "ZP"));
        //组装订单项
        EntryOrder entryOrder = new EntryOrder(orderno, Data.ownerCode, Data.whCode, "DBRK", "S200827133843428257");
        //组装请求body
        OrderData orderData = new OrderData(entryOrder, orderLines);

        ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
    }
}
