package v3.api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;
import v3.domain.Params;
import v3.domain.good.Good;
import v3.domain.good.Search;
import v3.domain.good.Sku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:14
 */
public class GoodApi {

    //添加商品
    @Test
    public void goodAdd() {
//组装商品
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("JHK000123", "小苹果", "100236"));

//组装 originJson
        Good good = new Good(Data.whcode, Data.accessCode, skuList);

//组装params
        Params params = new Params(JSON.toJSON(good).toString(), "goods.create", "WMSV3");

//接口推送
        ApiClient.doPostForm(Data.URL, params, null, null);

    }

    //查询商品
    @Test
    public void goodSearch() throws IOException {
        //组装originJson
        Search search = new Search(Data.whcode, Data.accessCode, "1", "10");
        //组装params
        Params params = new Params(JSON.toJSON(search).toString(), "goods.query", "WMSV3");

        //接口推送
        ApiClient.doPostForm(Data.URL,params,null,null);

    }
}
