package apijxc;

import client.ApiClient;
import domainout.Param;
import domainout.deliver.OrderLine;
import domainout.returnorder.RequestOrderReturn;
import domainout.returnorder.ReturnOrder;
import domainout.stockin.SenderInfo;
import org.junit.Test;
import utils.XmlUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/27 14:10
 */
public class OrderTuihuo {
    String orderno = "JTH"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    String expressCode = "YT"+new Random().nextInt(999999);

    @Test
    public void order() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(Data.ownerCode,"sku07301047","ZP",10));

        // 组装body的订单项
        ReturnOrder returnOrder = new ReturnOrder(orderno,Data.whCode,"THRK",expressCode,new SenderInfo("浙江省","杭州市","西湖区"));

        // 组装body消息体
        RequestOrderReturn request = new RequestOrderReturn(returnOrder,orderLines);

        ApiClient.doPostXml(Data.url,new Param("returnorder.create",Data.customerId),null, XmlUtil.objToXml(request));

    }
}
