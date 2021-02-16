package qimen;

import client.ApiClient;
import org.junit.Test;
import qimen.dto.Params;
import qimen.dto.stockin.InOrderDetailParamList;
import qimen.dto.stockin.Stockin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockinApi extends Data {

    @Test
    public void stockinOrder(){
        String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 组装商品信息
        List<InOrderDetailParamList> detailParamLists = new ArrayList<>();
        detailParamLists.add(new InOrderDetailParamList("G1612339450609","RMB",10,100));
        // 组装单据信息
        Stockin stockin = new Stockin(orderno,1,outShopId,warehouseCode,ownerCode,detailParamLists);
        // 组装接口参数
        Params params = new Params(orderno,"1","4",stockin);

        ApiClient.doPostJson(URL,null,null,params);
    }

}
