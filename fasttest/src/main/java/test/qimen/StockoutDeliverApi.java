package test.qimen;

import org.testng.annotations.Test;
import test.qimen.dto.Param;
import test.qimen.dto.stockout.deliver.*;
import test.qimen.dto.stockoutdeliver.*;
import utils.client.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 奇门发货单创建接口
 * @Date : Created in 2021/2/24 13:48
 */
public class StockoutDeliverApi extends Data {

    @Test
    public void order(){
        String orderno = "QMO"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 接口参数
        Param param = new Param("deliveryorder.create");

        // 接口报文体
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(1,ownerCode,"",1,""));

        SenderInfo senderInfo = new SenderInfo();
        ReceiverInfo receiverInfo = new ReceiverInfo();
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK",logicWarehouCode,"",orderLines,"SF",senderInfo,receiverInfo);

        RequestData requestData = new RequestData(deliveryOrder,orderLines);

        ApiClient.doPostXml(URL,param,null,requestData);

    }

}
