package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.Item;
import domain.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : OMS接口：保税订单推送--推送支付单--订单回执--清单回执--运单回执
 * @Date : Created in 2020/7/20 11:20
 */
public class OrderSetApiBaoshui {
    String orderNo = "JOS0011136";

    // 保税订单
    @Test
    public void orderSet() throws IOException {
//        String orderNo = "JS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //组装商品列表
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("SPC1583123976043",1,12));

        //组装订单项
        Order order = new Order(orderNo,"869",items,10,20,5);

        //接口推送订单
        ApiClient client = new ApiClient("http://pangu.admintest.yang800.cn/docking/api/order/push");
        client.doPostJson(JSON.toJSON(order));

        //推送海关支付单
        new OrderUtils().payInfoPush(orderNo);
    }

    //推送订单回执
    @Test
    public void pushDeclareBack() throws IOException {
        new OrderUtils().declareOrderPush(orderNo);
    }

    //推送清单回执
    @Test
    public void pushListBack() throws IOException {
        new OrderUtils().listBackPush(orderNo);
    }

    //推送运单回执
    @Test
    public void pushShipBack() throws IOException {
        new OrderUtils().shipBackPush(orderNo);
    }


}
