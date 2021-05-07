package test.erp.testcase.outQimen;

import org.testng.annotations.Test;
import test.erp.testcase.outQimen.dto.Params;
import test.erp.testcase.outQimen.dto.cancel.OrderCancel;
import test.erp.testcase.outQimen.dto.stockin.InOrderDetailParam;
import test.erp.testcase.outQimen.dto.stockin.ReceiveSendInfoParam;
import test.erp.testcase.outQimen.dto.stockin.Stockin;
import test.erp.testcase.Data;
import utils.client.apiclientDTO.ApiClient;

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
//        detailParamLists.add(new InOrderDetailParam("sku10200000",10,1000));
//        detailParamLists.add(new InOrderDetailParam("sku10100000",10,2000));
        detailParamLists.add(new InOrderDetailParam("SKU21050717250310",10,1,1000));
//        detailParamLists.add(new InOrderDetailParam("SKU2104151920322",10,1000));

        // 组装单据信息
//        Stockin stockin = new Stockin(orderno,1,"",warehouseCode,ownerCode,detailParamLists);
        ReceiveSendInfoParam receiveInfo = new ReceiveSendInfoParam("浙江省","杭州市","江干区");
        Stockin stockin = new Stockin(orderno,1,"", logicWarehouseCode,ownerCode,detailParamLists,receiveInfo);
        // 组装接口参数
        Params params = new Params(orderno,"4",stockin);

        ApiClient.doPostJson(urlQimen,null,null,params);
    }

    @Test
    public void stockinCancel(){
        String orderno = "QM20210218114546";
        OrderCancel orderCancel = new OrderCancel(orderno,"-1", logicWarehouseCode,ownerCode);
        Params params = new Params(orderno,"8",orderCancel);

        ApiClient.doPostJson(urlQimen,null,null,params);
    }

}
