package test.erp.qimen;

import test.erp.qimen.dto.cancel.OrderCancel;
import test.erp.qimen.dto.stockin.InOrderDetailParam;
import test.erp.qimen.dto.stockin.Stockin;
import utils.client.ApiClient;
import org.junit.Test;
import test.erp.qimen.dto.Params;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockinApi extends Data {

    @Test
    public void stockinOrder(){
        String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        String orderno = "QM20210218114546";

        // 组装商品信息
        List<InOrderDetailParam> detailParamLists = new ArrayList<>();
        detailParamLists.add(new InOrderDetailParam("SK210222112519","RMB",10,100));
        // 组装单据信息
        Stockin stockin = new Stockin(orderno,1,"",warehouseCode,ownerCode,detailParamLists);
        // 组装接口参数
        Params params = new Params(orderno,"4",stockin);

        ApiClient.doPostJson(URL,null,null,params);
    }

    @Test
    public void stockinCancel(){
        String orderno = "QM20210218114546";
        OrderCancel orderCancel = new OrderCancel(orderno,"-1",warehouseCode,ownerCode);
        Params params = new Params(orderno,"8",orderCancel);

        ApiClient.doPostJson(URL,null,null,params);
    }

}
