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

    // 添加有批次的商品
    @Test
    public void goodAdd1() throws Exception {
        Good good = new Good("SKU08281752","小南瓜","B2008260905166930","巴拉巴拉",1,200,"12.6");
        GoodApi.goodAdd(good);
    }

    // 添加无批次的商品
    @Test
    public void goodAdd2() throws Exception {
        Good good = new Good("SKU08261504","小西瓜","B2008260905166930","巴拉巴拉",0,0,"12.6");
        GoodApi.goodAdd(good);
    }

}
