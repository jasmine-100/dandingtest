package test.erp.testcase.outapi.qimen;

import org.testng.annotations.Test;
import test.erp.testcase.outapi.Data;
import test.erp.testcase.outapi.qimen.dto.Params;
import test.erp.testcase.outapi.qimen.dto.cancel.OrderCancel;
import test.erp.testcase.outapi.qimen.dto.stockout.OutOrderDetailFrom;
import test.erp.testcase.outapi.qimen.dto.stockout.Stockout;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockoutApi extends Data {

    @Test
    public void stockoutOrder(){
        String orderNo = "QM"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        String orderNo = "QM20210218115030";
        // 组装商品
        List<OutOrderDetailFrom> outOrderDetailFromList = new ArrayList<>();
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000161",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000162",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000163",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000164",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000165",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000301",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000302",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000303",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000304",null,1,10,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000305",null,1,10,10));

        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000161",null,2,10,10));
        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2104082000305",null,2,10,10));
        // 组装单据
        Stockout stockout = new Stockout(orderNo, logicWarehouseCode,ownerCode,3,outOrderDetailFromList);
        // 组装参数
        Params params = new Params(orderNo,"5",stockout);

        ApiClient.doPostJson(URL,null,null,params);
    }

    @Test
    public void orderCancel(){
        String orderno = "QM20210309090035000";
        OrderCancel orderCancel = new OrderCancel(orderno,"-2", logicWarehouseCode,ownerCode);
        Params params = new Params(orderno,"8",orderCancel);

        ApiClient.doPostJson(URL,null,null,params);
    }
}
