package oms;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import oms.dto.V2Order.OrderBiz;
import oms.dto.V2Order.Item;
import oms.dto.V2Order.OrderDTO;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : V2标准的渠道接口，下单
 * @Date : Created in 2021/1/15 9:48
 */
public class OrderSetV2 extends Data {

    @Test
    public static void orderSet(){
        // 订单号
        String orderNo = "JOS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        // 商品列表
        List<Item> items = new ArrayList<>();
        items.add(new Item("SKU2101121328","进口咖啡",100.23,1,0,0,0));
        // 订单
        OrderDTO order = new OrderDTO(orderNo,accessCode1,items);
        System.out.println(JSON.toJSONString(order));
        //报文
        OrderBiz orderBiz = new OrderBiz(JSON.toJSONString(order),partnerId,token);
        System.out.println(orderBiz);

        ApiClient.doPostForm(V2Url,orderBiz,null,null);
    }

}
