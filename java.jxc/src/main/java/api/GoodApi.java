package api;

import client.ApiClient;
import casetest.BaseParam;
import casetest.Cookie;
import domainout.good.Good;
import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 添加商品
 * @Date : Created in 2020/7/20 12:30
 */
public class GoodApi {

    // 商品有批次1，无批次0
    @Test
    public void goodAdd() {
        Good good = new Good("SKU09211739","小南瓜","B2008260905166930","巴拉巴拉","1",200,"12.6");

        ApiClient.doPostJson(BaseParam.GOOD_ADD,null, Cookie.getCookie(),good);
    }

}
