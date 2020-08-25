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

    // 添加商品
    public static void goodAdd(Good good) throws Exception {
        ApiClient.doPostJson(BaseParam.GOOD_ADD,null, Cookie.getCookie(),JSON.toJSON(good));
    }

}
