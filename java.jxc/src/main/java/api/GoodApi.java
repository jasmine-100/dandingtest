package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.Good;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:30
 */
public class GoodApi {

    @Test
    public void testAddGoods() throws IOException {

        //组装商品
        Good good = new Good("JO"+System.currentTimeMillis(),"红豆"+System.currentTimeMillis(),"0","100","12.6","AAA");

        //接口：创建商品
        ApiClient client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/pro/upsert");
        client.doPostJson(JSON.toJSON(good));

    }
}
