package api;

import client.ApiClient;
import jxc.BaseParam;
import jxc.Cookie;
import domainout.good.Good;

/**
 * @Author： jasmine
 * @Description : 添加商品
 * @Date : Created in 2020/7/20 12:30
 */
public class GoodApi {

    // 添加商品
    public static void goodAdd(Good good) throws Exception {
        ApiClient.doPostJson(BaseParam.GOOD_ADD,null, Cookie.getCookie(),good);
    }

}
