package erp.qimen;

import erp.qimen.dto.cancel.OrderCancel;
import erp.qimen.dto.stockout.OutOrderDetailFrom;
import erp.qimen.dto.stockout.Stockout;
import utils.client.ApiClient;
import org.junit.Test;
import erp.qimen.dto.Params;

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
        outOrderDetailFromList.add(new OutOrderDetailFrom("SK210222112519",null,1,1,10));
        // 组装单据
        Stockout stockout = new Stockout(orderNo,warehouseCode,ownerCode,3,outOrderDetailFromList);
        // 组装参数
        Params params = new Params(orderNo,"5",stockout);

        ApiClient.doPostJson(URL,null,null,params);
    }

    @Test
    public void orderCancel(){
        String orderno = "QM20210218120257";
        OrderCancel orderCancel = new OrderCancel(orderno,"-2",warehouseCode,ownerCode);
        Params params = new Params(orderno,"8",orderCancel);

        ApiClient.doPostJson(URL,null,null,params);
    }
}
