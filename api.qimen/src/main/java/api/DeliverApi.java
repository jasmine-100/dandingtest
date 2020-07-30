package api;

import domain.OrderType;
import domain.Param;
import domain.deliver.DeliverData;
import domain.deliver.DeliveryOrder;
import domain.deliver.OrderLine;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/27 9:54
 */
public class DeliverApi {
    String orderno = "";

    @Test
    public void deliverOrder(){
        String customerId = "C1590459235731";

        //组装
        DeliveryOrder deliveryOrder = new DeliveryOrder();

        List<OrderLine > orderLines = new ArrayList<>();
        orderLines.add(new OrderLine());
        //组装body
        DeliverData deliverData = new DeliverData();

        // 组装接口参数
        Param param = new Param(OrderType.DELIVER,customerId);
        
    }
}
