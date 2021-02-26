package test.qimen;

import org.testng.annotations.Test;
import test.qimen.dto.Param;
import test.qimen.dto.stockout.outbound.*;
import utils.client.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 奇门出库单创建接口
 * @Date : Created in 2021/2/24 13:48
 */
public class StockoutOutboundApi extends Data {

    @Test
    public void order(){
        String orderno = "QMOB"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 接口参数
        Param param = new Param("stockout.create");

        // 接口报文体
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(ownerCode,"QSKU210225210304",1,"ZP",null));

        SenderInfo senderInfo = new SenderInfo();
        ReceiverInfo receiverInfo = new ReceiverInfo();
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"DBCK",logicWarehouCode,"ZTO",senderInfo,receiverInfo);//调拨出库
//        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"PTCK",logicWarehouCode,"ZTO",senderInfo,receiverInfo);//销售出库

        RequestData requestData = new RequestData(deliveryOrder,orderLines);

        ApiClient.doPostXml(URL,param,null,requestData);

    }

}
