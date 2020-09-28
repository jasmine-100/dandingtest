package v3.api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;
import v3.domain.Params;
import v3.domain.stockin.Order;
import v3.domain.stockin.Sku;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:41
 */
public class StockinApi {

    //推送入库单
    @Test
    public void stockinOrder() {
        String orderno = "PS"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        //组装商品项
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("JHK000123",100));
        //组装originJson
        Order stockin = new Order(orderno, Data.whcode,Data.accessCode, "CGRKD",skuList); //采购单

        //组装接口参数params
        Params params = new Params(JSON.toJSON(stockin).toString(), "stockin.create", "WMSV3");

        //接口推送
        ApiClient.doPostForm(Data.URL,params,null,null);
    }


}
