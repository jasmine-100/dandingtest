package gx.apigx;

import oms.api.OrderSet;
import oms.domain.Item;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 模拟OMS小B下单
 * @Date : Created in 2020/7/27 14:51
 */
public class GxOrderApi {

    //小B下单，调用OMS内部下单接口
    @Test
    public void orderSet() throws Exception {
        //订单号
        String orderno = "JOS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        //组装商品项：下单之前小B需要映射和上架商品、补足库存
        List<Item> items = new ArrayList<>();
        items.add(new Item("","JO00001",1,50));
//        items.add(new Item("SPC1595404032469","XS001",2,50));

        //组装并推送订单
        OrderSet.orderSet(orderno,"1021",items);
    }

}
