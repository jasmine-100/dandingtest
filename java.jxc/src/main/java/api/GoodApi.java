package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import dao.BaseParam;
import domainout.good.Good;
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
    public void goodAdd() throws IOException {
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

        Good good = new Good(str,"小西瓜","0","100","12.6","巴拉巴拉");

        new ApiClient(BaseParam.GOOD_ADD).doPostJson(JSON.toJSON(good));
    }
}
