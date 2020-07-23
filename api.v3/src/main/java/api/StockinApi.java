package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.AppId;
import domain.Params;
import domain.ServiceName;
import domain.stockin.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:41
 */
public class StockinApi {
    String url = "http://outtest.order.yang800.cn/open/testV3";
    ApiClient client = new ApiClient(url);

    String whCode = "TESTDEPOT001";
    String accessCode = "DS15628267317912";

    String orderno = "JY100237";

    //推送入库单
    @Test
    public void stockinOrder() throws IOException {
        //组装商品项
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("JHK000123",100));
        //组装originJson
        Order stockin = new Order(orderno,whCode,accessCode, OrderType.CAIGOU,skuList); //采购单

        //组装接口参数params
        Params params = new Params(JSON.toJSON(stockin).toString(), ServiceName.STOCKIN_CREATE, AppId.WMSV3);

        //接口推送
        client.doPostForm(params);
    }


}
