package test.qimen;

import org.testng.annotations.Test;
import test.qimen.dto.Param;
import test.qimen.dto.stockin.returnorder.OrderLine;
import test.qimen.dto.stockin.returnorder.RequestData;
import test.qimen.dto.stockin.returnorder.ReturnOrder;
import test.qimen.dto.stockin.returnorder.SenderInfo;
import utils.client.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 16:50
 */
public class StockinReturnApi extends Data {

    @Test
    public void createOrder(){
        String orderno = "QMIR"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Param param = new Param("returnorder.create");

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("QSKU20210224182139","ZP",10,ownerCode));

        ReturnOrder returnOrder = new ReturnOrder(orderno,logicWarehouCode,"THRK","SF",new SenderInfo());
        RequestData requestData = new RequestData(returnOrder,orderLines);

        ApiClient.doPostXml(URL,param,null,requestData);
    }

}
