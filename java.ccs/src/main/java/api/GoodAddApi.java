package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import dao.Data;
import domain.Good;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 添加备案商品
 * @Date : Created in 2020/8/12 14:23
 */
public class GoodAddApi {

    @Test
    public void createGood() throws IOException {
        Good good = null;
        for(int i=0;i<50000;i++){
            good = new Good("SK"+i,"JHY"+i,"9");
            new ApiClient(Data.URL_GOOD).doPostJson(JSON.toJSON(good));
        }

    }

}
