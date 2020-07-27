package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.good.Good;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 添加商品
 * @Date : Created in 2020/7/20 12:30
 */
public class GoodApi {

    @Test
    public void testAddGoods() throws IOException {
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

        List<Good> goods = new ArrayList<>();
        goods.add(new Good(str+1,"小西瓜","0","100","12.6","AAA"));
        goods.add(new Good(str+2,"小西瓜","0","100","12.6","AAA"));
        goods.add(new Good(str+3,"小西瓜","0","100","12.6","AAA"));

        for (Good good:goods){
            //接口：创建商品
            ApiClient client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/pro/upsert");
            client.doPostJson(JSON.toJSON(good));
        }

    }
}
