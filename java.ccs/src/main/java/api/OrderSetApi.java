package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.Item;
import domain.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:23
 */
public class OrderSetApi {

    @Test
    public void pushOrder() throws IOException, InterruptedException {

        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("NO0715J01",2,10));
        items.add(new Item("NO0715J02",6,11));
        items.add(new Item("NO0715J03",5,12));

        // 组装申报单
        String str = new SimpleDateFormat("MMddHHmmss").format(new Date());
        String orderno = "JOS"+str;
        Order order = new Order(orderno,"ZTO","Z"+str,"jasRoute", items);

        ApiClient client = new ApiClient("http://ccs.backend.daily.yang800.com/xhr/order/submit");
        client.doPostJson(JSON.toJSON(order));

    }
}
