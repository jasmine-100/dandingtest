package test.qimen;

import org.testng.annotations.Test;
import test.qimen.dto.Param;
import test.qimen.dto.stockin.purchase.EntryOrder;
import test.qimen.dto.stockin.purchase.OrderLine;
import test.qimen.dto.stockin.purchase.RequestData;
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
public class StockinPurchaseApi extends Data {

    @Test
    public void createOrder(){
        String orderno = "QMIC"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Param param = new Param("entryorder.create");

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(ownerCode,"QSKU20210224182139",ownerCode,100));

        EntryOrder entryOrder = new EntryOrder(orderno,logicWarehouCode,ownerCode,"JYCK","1",orderLines);
        RequestData requestData = new RequestData(entryOrder,orderLines);

        ApiClient.doPostXml(URL,param,null,requestData);
    }

}
