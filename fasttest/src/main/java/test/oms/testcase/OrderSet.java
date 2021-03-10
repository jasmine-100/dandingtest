package test.oms.testcase;

import org.testng.annotations.Test;
import test.oms.testcase.dto.order.Item;
import test.oms.testcase.dto.order.OrderDTO;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 新版OMS 内部下单接口
 * @Date : Created in 2021/01/06 14:08
 */
public class OrderSet extends Data {
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String orderNo = "JOS"+str;
    String expressNo = "SF"+str;
    List<Item> items = new ArrayList<>();

    @Test
    public void order1(){ // 哈哈科技有限公司，黑店
        items.add(new Item("sku03090930","外部完税商品","",50,1));
        OrderDTO order = new OrderDTO(orderNo,items,null,null,"V2",accessCode1,"浙江省","杭州市","江干区");
//        OrderDTO order = new OrderDTO(orderNo,items,"SF",saleChannel,null,"V2",accessCode1);
//        OrderDTO order = new OrderDTO(orderNo,items,"ZTO",saleChannel,null,"V2",accessCode1);
//        OrderDTO order = new OrderDTO(orderNo,items,null,null,"V2",Data.accessCode1);

        ApiClient.doPostJson(OrderUrl,null,null,order);
    }

    @Test
    public void order2(){ // 小花花的花店
        items.add(new Item("SKU202101191103",null,"",50,1));//保税
//        OrderDTO order = new OrderDTO(orderNo,items,"SF",expressNo,"V2",Data.accessCode2);
//        OrderDTO order = new OrderDTO(orderNo,items,null,expressNo,"V2",accessCode2);

//        ApiClient.doPostJson(OrderUrl,null,null,order);
    }

}