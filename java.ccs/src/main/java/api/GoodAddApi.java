package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import dao.BaseParam;
import domain.Good;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 添加备案商品
 * @Date : Created in 2020/8/12 14:23
 */
public class GoodAddApi {

    // 单一添加商品备案信息
    @Test
    public void addGood() throws IOException {
        Good good = new Good("sku1409","pd1409","13");
        new ApiClient(BaseParam.URL_GOOD).doPostJson(JSON.toJSON(good));
    }

    //  批量添加商品
    @Test
    public void addGoods() throws IOException {
        Good good = null;
        for(int i=0;i<5000;i++){
            good = new Good("SK1"+i,"JHY1"+i,"13");
            new ApiClient(BaseParam.URL_GOOD).doPostJson(JSON.toJSON(good));
        }
    }

}
