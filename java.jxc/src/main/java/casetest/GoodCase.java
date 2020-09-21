package casetest;

import api.GoodApi;
import domainout.good.Good;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/25 16:51
 */
public class GoodCase {

    // 商品有批次1，无批次0
    @Test
    public void goodAdd() throws Exception {
        Good good = new Good("SKU09211739","小南瓜","B2008260905166930","巴拉巴拉",1,200,"12.6");
        GoodApi.goodAdd(good);
    }

}
