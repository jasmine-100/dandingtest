package test.qimen.testcase;

import org.testng.annotations.Test;
import test.qimen.testcase.dto.Param;
import test.qimen.testcase.dto.stockin.purchase.EntryOrder;
import test.qimen.testcase.dto.stockin.purchase.OrderLine;
import test.qimen.testcase.dto.stockin.purchase.RequestData;
import utils.client.apiclientDTO.ApiClient;

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
//        orderLines.add(new OrderLine(ownerCode,"SKU2101141460",ownerCode,1000));
        orderLines.add(new OrderLine(ownerCode,"QSKU210508165539",ownerCode,200));
//        orderLines.add(new OrderLine(ownerCode,"QSKU20210224211344",ownerCode,300));

//        EntryOrder entryOrder = new EntryOrder(orderno,logicWarehouCode,ownerCode,"CGRK","1",orderLines);//采购入库
        EntryOrder entryOrder = new EntryOrder(orderno,logicWarehouseCode,ownerCode,"DBRK","1",orderLines);//调拨入库
        RequestData requestData = new RequestData(entryOrder,orderLines);

        ApiClient.doPostXml(URL,param,null,requestData);
    }

}
