package gx.apigx;

import client.ApiClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 获取供销平台大B商品
 * @Date : Created in 2020/7/22 12:11
 */
public class GoodSearch {
    String url = "http://npc.daily.yang800.com/backend/docking/api/item/queryItems?userId=144&pageSize=10&currentPage=1";

    @Test
    public void searchGood() throws IOException {
        ApiClient client = new ApiClient(url);
        client.doGetUrl();
    }
}
