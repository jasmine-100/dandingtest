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
 * @Date : Created in 2020/7/20 11:20
 */
public class OrderSetApi {
    @Test
    public void orderSet() throws IOException {
        //组装商品列表
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("SPC1594975991833",1,12));
        items.add(new Item("SPC1595216228153",5,10));

        //组装订单项
        String orderNo = "JS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Order order = new Order(orderNo,"869",items,10,20,5);

        //接口推送订单
        ApiClient client = new ApiClient("http://pangu.admintest.yang800.cn/docking/api/order/push");
        client.doPostJson(JSON.toJSON(order));
    }

}
