package api;

import client.ApiClient;
import domain.Stock;
import jxc.BaseParam;
import domain.Good;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 添加备案商品
 * @Date : Created in 2020/8/12 14:23
 */
public class GoodStockApi {
    String goosname = DataEnum.getGoodName();
    String str = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
    String skuNo = "SKU"+str;
    String productId = "JHKY"+str;
    String goodsSeqNo = "GSN"+str;
    int bookId = 13;

    // 单一添加商品备案和账册库存
    @Test
    public void addGood() {
        // 添加备案商品
        Good good = new Good(skuNo,goosname,productId,bookId);
        ApiClient.doPostJson(BaseParam.URL_GOOD,null,null,good);

        // 添加账册库存
        Stock stock = new Stock(goodsSeqNo,goosname,productId,bookId);
        ApiClient.doPostJson(BaseParam.URL_STOCK,null,null,stock);
    }

}
