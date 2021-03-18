package test.erp.testcase.outapi.qimen;

import org.testng.annotations.Test;
import test.erp.testcase.outapi.Data;
import test.erp.testcase.outapi.qimen.dto.Params;
import test.erp.testcase.outapi.qimen.dto.cancel.OrderCancel;
import test.erp.testcase.outapi.qimen.dto.stockin.InOrderDetailParam;
import test.erp.testcase.outapi.qimen.dto.stockin.ReceiveSendInfoParam;
import test.erp.testcase.outapi.qimen.dto.stockin.Stockin;
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
        detailParamLists.add(new InOrderDetailParam("SKU202103160","RMB",10,1000));
        detailParamLists.add(new InOrderDetailParam("SKU202103160","HKD",10,1000));
//        detailParamLists.add(new InOrderDetailParam("SKU202103162","RMB",10,1000));

        // 组装单据信息
//        Stockin stockin = new Stockin(orderno,1,"",warehouseCode,ownerCode,detailParamLists);
        ReceiveSendInfoParam receiveInfo = new ReceiveSendInfoParam("浙江省","杭州市","江干区");
        Stockin stockin = new Stockin(orderno,1,"", logicWarehouseCode,ownerCode,detailParamLists,receiveInfo);
        // 组装接口参数
        Params params = new Params(orderno,"4",stockin);

        ApiClient.doPostJson(URL,null,null,params);
    }

    @Test
    public void stockinCancel(){
        String orderno = "QM20210218114546";
        OrderCancel orderCancel = new OrderCancel(orderno,"-1", logicWarehouseCode,ownerCode);
        Params params = new Params(orderno,"8",orderCancel);

        ApiClient.doPostJson(URL,null,null,params);
    }

}
