package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.good.Good;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 添加商品
 * @Date : Created in 2020/7/20 12:30
 */
public class GoodApi {

    @Test
    public void testAddGoods() throws IOException {
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

        //组装商品
        Good good = new Good("JO"+str,"红豆"+str,"0","100","12.6","AAA");

        //接口：创建商品
        ApiClient client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/pro/upsert");
        client.doPostJson(JSON.toJSON(good));

    }
}
