package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import jxc.BaseParam;
import domain.Stock;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 添加账册库存
 * @Date : Created in 2020/8/12 15:20
 */
public class StockAddApi {

    // 单一添加商品库存
    @Test
    public void addStock() throws IOException {
        Stock stock = new Stock(Data.goodsSeqNo,Data.productId,Data.bookId);
        new ApiClient(BaseParam.URL_STOCK).doPostJson(JSON.toJSON(stock));
    }

    // 批量添加账册库存
    @Test
    public void addStocks() throws IOException {
        Stock stock = null;
        for(int i=1;i<5000;i++){
            stock = new Stock("SK1"+i,"JHY1"+i,"13");
            new ApiClient(BaseParam.URL_STOCK).doPostJson(JSON.toJSON(stock));
        }
    }
}
