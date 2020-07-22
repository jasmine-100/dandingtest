package gx.apigx;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import gx.domain.GoodList;
import gx.domain.GoodUp;
import gx.domain.Order;
import oms.api.OrderSet;
import oms.domain.Item;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 12:11
 */
public class GxApi {

    //小B账户：jasmineb
    String bUserId = "162";

    //大B账户：jasmine10
    String BUserId = "144";

    //第一步：获取供销平台大B商品
    @Test
    public void searchGood() throws IOException {
        String url = "http://npc.daily.yang800.com/backend/docking/api/item/queryItems?userId="+ BUserId +"&pageSize=1000&currentPage=1";

        ApiClient client = new ApiClient(url);
        client.doGetUrl();
    }

    //第二步：大B选品上架
    @Test
    public void selectGoodUp() throws IOException {
        //sku取上一步查询出来的sku
        GoodUp good = new GoodUp("明星挚爱水库面膜", BUserId,"SKU1594975799580");

        String url = "http://npc.daily.yang800.com/backend/docking/api/item/add";
        ApiClient client = new ApiClient(url);
        client.doPostJson(JSON.toJSON(good));

    }

    //第三步：小B选品加入清单
    @Test
    public void addList() throws IOException {
        // outeItemCode取第二步生成的外部商品编码（OMS大B的商品界面）
        GoodList goodList = new GoodList("明星挚爱水库面膜",bUserId,"GX20200722150113");

        String url = "http://npc.daily.yang800.com/backend/docking/api/item/insItem";
        ApiClient client = new ApiClient(url);
        client.doPostForm(goodList);
    }

    //第四步：小B下单，调用OMS内部下单接口
    @Test
    public void orderSet() throws IOException {
        //订单号
        String orderno = "JOS"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        //组装商品项：下单之前小B需要映射和上架商品、补足库存
        List<Item> items = new ArrayList<>();
        items.add(new Item("","FX1003",1,50));

        //组装并推送订单
        OrderSet.orderSet(orderno,"1009",items);
    }


    //第五步：大B下单
    @Test
    public void orderSetB() throws IOException {
        //组装商品
        List<gx.domain.Item> items = new ArrayList<>();
        items.add(new gx.domain.Item("GX20200722150113",50,1));

        // 组装订单:订单号 取小B订单的订单号
        String outOrderSn = "BY"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Order order = new Order("DO2007221503573171441",outOrderSn, BUserId,items);

        String url = "http://npc.daily.yang800.com/backend/docking/api/order/receive2bOrder";
        ApiClient client = new ApiClient(url);
        client.doPostJson(JSON.toJSON(order));
    }


}
