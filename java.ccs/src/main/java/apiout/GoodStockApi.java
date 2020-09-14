package apiout;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.GoodWare;
import domainout.BackGood;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 仓储系统：添加商品
 * @Date : Created in 2020/8/24 14:57
 */
public class GoodStockApi {
    GoodWare good = new GoodWare("D2019042501274160","DS15979766114883","SkuJS003","小苹果");

    // 仓库添加商品
    @Test
    public void goodAdd() throws IOException {
        String url = "http://depottest.yang800.cn/api/sku/sync";
        ApiClient.doPostJson(url,null,null,good);
    }

    // ccs同步备案商品
    @Test
    public void goodUpdate() throws IOException {
        BackGood.backAddGood("20200807",good,"1901900000");
    }

}
