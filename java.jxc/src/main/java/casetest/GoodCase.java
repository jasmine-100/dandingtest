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

    @Test
    public void goodAdd() throws Exception {
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Good good = new Good(str,"小西瓜",1,200,"12.6");

        GoodApi.goodAdd(good);
    }
}
