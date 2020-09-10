package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import jxc.BaseParam;
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
        Good good = new Good(Data.skuNo,Data.productId,Data.bookId);
        ApiClient.doPostJson(BaseParam.URL_GOOD,null,null,good);
    }

    //  批量添加商品
    @Test
    public void addGoods() throws IOException {
        Good good = null;
//        for(int i=1;i<=201;i++){
//            good = new Good("SKA"+i,"SKA"+i,"13");
//            ApiClient.doPostJson(BaseParam.URL_GOOD,null,null,good);
//        }
        for(int i=202;i<=202;i++){
            good = new Good("SKA"+i,"SKA"+i,"13");
            ApiClient.doPostJson(BaseParam.URL_GOOD,null,null,good);
        }
    }

}
