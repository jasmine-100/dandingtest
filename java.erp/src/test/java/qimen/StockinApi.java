package qimen;

import utils.client.ApiClient;
import org.junit.Test;
import qimen.dto.Params;
import qimen.dto.cancel.OrderCancel;
import qimen.dto.stockin.InOrderDetailParam;
import qimen.dto.stockin.Stockin;

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
        detailParamLists.add(new InOrderDetailParam("SK210220152624","RMB",10,100));
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
