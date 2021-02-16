package qimen;

import client.ApiClient;
import org.junit.Test;
import qimen.dto.Params;
import qimen.dto.cancel.OrderCancel;
import qimen.dto.stockout.OutOrderDetailFrom;
import qimen.dto.stockout.Stockout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockoutApi extends Data {

    @Test
    public void stockoutOrder(){
        String orderNo = "QM"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        // 组装商品
        List<OutOrderDetailFrom> outOrderDetailFromList = new ArrayList<>();
        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2101141457","LOT210131000012",1,1,10));
//        outOrderDetailFromList.add(new OutOrderDetailFrom("SKU2101141454","210129003",1,1,10));
        // 组装单据
        Stockout stockout = new Stockout("QM20210216195707",warehouseCode,ownerCode,3,outOrderDetailFromList);
        // 组装参数
        Params params = new Params(orderNo,"5",stockout);

        ApiClient.doPostJson(URL,null,null,params);
    }

    @Test
    public void orderCancel(){
        String orderno = "QM20210216195707";
        OrderCancel orderCancel = new OrderCancel(orderno,"-2",warehouseCode,ownerCode);
        Params params = new Params(orderno,"8",orderCancel);

        ApiClient.doPostJson(URL,null,null,params);
    }
}
