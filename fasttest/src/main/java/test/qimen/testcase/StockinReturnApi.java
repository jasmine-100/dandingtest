package test.qimen.testcase;

import org.testng.annotations.Test;
import test.qimen.testcase.dto.Param;
import test.qimen.testcase.dto.stockin.returnorder.OrderLine;
import test.qimen.testcase.dto.stockin.returnorder.RequestData;
import test.qimen.testcase.dto.stockin.returnorder.ReturnOrder;
import test.qimen.testcase.dto.stockin.returnorder.SenderInfo;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 退货入库单
 * @Date : Created in 2021/2/24 16:50
 */
public class StockinReturnApi extends Data {

    @Test
    public void createOrder(){
        String orderno = "QMIR"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Param param = new Param("returnorder.create");

        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("QSKU210225210304","ZP",100,ownerCode));
//        orderLines.add(new OrderLine("QSKU20210224211314","CP",100,ownerCode));
//        orderLines.add(new OrderLine("QSKU20210224211344","ZP",100,ownerCode));

        ReturnOrder returnOrder = new ReturnOrder(orderno,logicWarehouseCode,"THRK","SF",new SenderInfo());//退货入库
        RequestData requestData = new RequestData(returnOrder,orderLines);

        ApiClient.doPostXml(URL,param,null,requestData);
    }

}
