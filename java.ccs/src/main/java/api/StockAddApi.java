package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import dao.Data;
import domain.Stock;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 添加账册库存
 * @Date : Created in 2020/8/12 15:20
 */
public class StockAddApi {

    @Test
    public void stockAdd() throws IOException {
        Stock stock = null;
        for(int i=1;i<50000;i++){
            stock = new Stock("SK"+i,"JHY"+i,"9");
            new ApiClient(Data.URL_STOCK).doPostJson(JSON.toJSON(stock));
        }
//        stock = new Stock("SK1","JHY1","9");
        new ApiClient(Data.URL_STOCK).doPostJson(JSON.toJSON(stock));
    }
}
