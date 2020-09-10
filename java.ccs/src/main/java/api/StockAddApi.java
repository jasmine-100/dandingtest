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
        ApiClient.doPostJson(BaseParam.URL_STOCK,null,null,stock);
    }

    // 批量添加账册库存
    @Test
    public void addStocks() throws IOException {
        Stock stock = null;
        for(int i=202;i<=202;i++){
            stock = new Stock("SKA"+i,"SKA"+i,"13");
            ApiClient.doPostJson(BaseParam.URL_STOCK,null,null,stock);
        }
    }
}
