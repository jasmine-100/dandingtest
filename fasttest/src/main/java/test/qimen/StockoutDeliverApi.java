package test.qimen;

import org.testng.annotations.Test;
import test.qimen.dto.Param;
import test.qimen.dto.stockout.deliver.*;
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
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String orderno = "QMOC"+ str;

        // 接口参数
        Param param = new Param("deliveryorder.create");

        // 接口报文体
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(1,ownerCode,"SKU2101141460","奇门外部商品",1,null));

        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK",logicWarehouCode,orderLines,"ZTO","ZTO"+str);//C单出库
//        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK",logicWarehouCode,orderLines,"DB");//B单出库

        // 保税订单--保税信息
        ExtendProps extendProps = new ExtendProps(orderno,0,10,5,0,0,deliveryOrder,orderLines);

        RequestData requestData = new RequestData(deliveryOrder,orderLines,extendProps);

        ApiClient.doPostXml(URL,param,null,requestData);

    }

}
