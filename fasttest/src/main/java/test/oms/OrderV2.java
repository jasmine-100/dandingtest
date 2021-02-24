package test.oms;

import org.testng.annotations.Test;
import test.oms.dto.v2.ApiV2ServiceName;
import test.oms.dto.v2.orderV2.Item;
import test.oms.dto.v2.orderV2.OrderDTO;
import test.oms.dto.v2.orderV2Cancel.OrderCancel;
import utils.client.ApiClient;
import utils.util.BizData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : V2标准的渠道接口，下单
 * @Date : Created in 2021/1/15 9:48
 */
public class OrderV2 extends Data {

    @Test
    public static void orderSet(){
        // 订单号
        String orderNo = "JOS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        // 商品列表
        List<Item> items = new ArrayList<>();
        items.add(new Item("SKU02011134","进口咖啡",100.23,1,0,0,0));
        // 订单
        OrderDTO order = new OrderDTO(orderNo,accessCode1,items);
        //报文
        BizData orderBiz = new BizData(order, ApiV2ServiceName.ORDER_OUT_SET,partnerId,token);
        System.out.println(orderBiz);

        ApiClient.doPostForm(V2Url,orderBiz,null,null);
    }

    @Test
    public void orderCancel() {
        String orderNo = "JOS20210202115931";
        OrderCancel orderCancel = new OrderCancel(accessCode1,orderNo);
        BizData orderBiz = new BizData(orderCancel, ApiV2ServiceName.ORDER_CANCEL,partnerId,token);

        ApiClient.doPostForm(V2Url,orderBiz,null,null);

    }

}
