package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import dao.BaseParam;
import dao.Cookie;
import domainout.good.Good;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author： jasmine
 * @Description : 添加商品
 * @Date : Created in 2020/7/20 12:30
 */
public class GoodApi {

    // 添加普通、无批次商品
    @Test
    public void goodAdd() throws Exception {
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

        Good good = new Good(str,"小西瓜","0","100","12.6","巴拉巴拉");
        ApiClient.doPostJson(BaseParam.GOOD_ADD,null, Cookie.getCookie(),JSON.toJSON(good));
    }

}
