package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.ParamsV3;
import domain.ServiceName;
import domain.good.Good;
import domain.good.Search;
import domain.good.Sku;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:14
 */
public class GoodApi {
    String url = "http://outtest.order.yang800.cn/open/testV3";
    ApiClient client = new ApiClient(url);

    //添加商品
    @Test
    public void goodAdd() throws IOException {
        //组装商品
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("JHK000123","小苹果","100236"));

        //组装 originJson
        Good good = new Good("TESTDEPOT001","DS15628267317912",skuList);

        //组装params
        ParamsV3 params = new ParamsV3(JSON.toJSON(good).toString(), ServiceName.GOOD_CREATE,"WMSV3");

        //接口推送
        client.doPostForm(params);

    }

    //查询商品
    @Test
    public void goodSearch() throws IOException {
        //组装originJson
        Search search = new Search("TESTDEPOT001","DS15628267317912","1","10");
        //组装params
        ParamsV3 params = new ParamsV3(JSON.toJSON(search).toString(),ServiceName.GOOD_QUERY,"WMSV3");

        //接口推送
        client.doPostForm(params);

    }
}
