package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.Params;
import domain.ServiceName;
import domain.stockin.OrderType;
import domain.stockin.Sku;
import domain.stockin.Stockin;
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

    //推送入库单
    @Test
    public void stockinOrder() throws IOException {
        //组装商品项
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("JHK000123",100));
        //组装originJson
        Stockin stockin = new Stockin("TESTDEPOT001","DS15628267317912", OrderType.CAIGOU,skuList); //采购单
//        Stockin stockin = new Stockin("TESTDEPOT001","DS15628267317912", OrderType.DIAOBO,skuList); //调拨单
//        Stockin stockin = new Stockin("TESTDEPOT001","DS15628267317912", OrderType.PFTUIHUO,skuList); //批发退货单
//        Stockin stockin = new Stockin("TESTDEPOT001","DS15628267317912", OrderType.SOTUIHUO,skuList); //销售退货单

        //组装接口参数params
        Params params = new Params(JSON.toJSON(stockin).toString(), ServiceName.STOCKIN_CREATE,"WMSV3");

        //接口推送
        String url = "http://outtest.order.yang800.cn/open/testV3";
        ApiClient client = new ApiClient(url);
        client.doPostForm(params);
    }
}
