package gx.apigx;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import gx.domain.GoodList;
import gx.domain.GoodUp;
import gx.domain.Order;
import oms.api.OrderSet;
import oms.api.OrderSetApiBaoshui;
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

    //第一步：获取供销平台大B商品
    @Test
    public void searchGood() throws IOException {
        String url = "http://npc.daily.yang800.com/backend/docking/api/item/queryItems?userId=144&pageSize=10&currentPage=1";

        ApiClient client = new ApiClient(url);
        client.doGetUrl();
    }

    //第二步：大B选品上架
    @Test
    public void selectGoodUp() throws IOException {
        //sku取上一步查询出来的sku
        GoodUp good = new GoodUp("好喝的奶粉","144","SKU1594975802146");

        String url = "http://npc.daily.yang800.com/backend/docking/api/item/add";
        ApiClient client = new ApiClient(url);
        client.doPostJson(JSON.toJSON(good));

    }

    //第三步：小B选品加入清单
    @Test
    public void addList() throws IOException {
        // outeItemCode取第二步生成的外部商品编码（OMS大B的商品界面）
        GoodList goodList = new GoodList("好喝的奶粉","161","GX20200722123316");

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
        items.add(new Item("","FX10002",10,50));

        //组装并推送订单
        OrderSet.orderSet(orderno,"1008",items);
    }


    //第五步：大B下单
    @Test
    public void orderSetB() throws IOException {
        //组装商品
        List<gx.domain.Item> items = new ArrayList<>();
        items.add(new gx.domain.Item("GX20200722123316",50,10));

        /**
         * 组装订单
         * 订单号:取小B订单的订单号
         * userId:取大B的用户id
         */
        String outOrderSn = "BY"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Order order = new Order("DO2007221342514461440",outOrderSn,"144",items);

        String url = "http://npc.daily.yang800.com/backend/docking/api/order/receive2bOrder";
        ApiClient client = new ApiClient(url);
        client.doPostJson(JSON.toJSON(order));
    }


}
