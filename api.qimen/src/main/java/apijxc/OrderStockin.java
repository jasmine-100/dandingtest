package apijxc;

import client.ApiClient;
import domainout.Method;
import domainout.Param;
import domainout.stockin.*;
import org.junit.Test;
import utils.XmlUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :奇门接口推送采购入库单
 * @Date : Created in 2020/7/24 13:43
 */
public class OrderStockin {
    //外部订单号，相同货主内唯一
    String orderno = "QM_S"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    @Test
    public void orderSet() throws Exception {

        //组装商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(Data.ownerCode, "sku08260904", 1001, "ZP"));
        //组装订单项
        EntryOrder entryOrder = new EntryOrder(orderno, Data.ownerCode, Data.whCode, "CGRK", "S200827133843428257");

        //组装请求body
        OrderData orderData = new OrderData(entryOrder, orderLines);

        ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));

    }

}
