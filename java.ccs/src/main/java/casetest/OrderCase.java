package casetest;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import dao.BaseParam;
import domain.Item;
import domain.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description : 批量下单
 * @Date : Created in 2020/8/17 15:23
 */
public class OrderCase {

    // 批量下单
    @Test
    public void orderSet() throws IOException {
        for(int i=0;i<5;i++){
            // 渠道订单号和申报单号:随机生成
            String orderno = "JA"+new SimpleDateFormat("MMddHHmmss").format(new Date())+i;
            // 添加商品项
            List<Item> items = new ArrayList<Item>();
            items.add(new Item("pd1406",3,10));
            // 组装申报单
            Order order = new Order("xiaoyuer","小鱼儿",orderno,"SF","SF"+new Random().nextInt(999999),Data.routeCode, items);
            //接口：推送申报单
            new ApiClient(BaseParam.URL_ORDER).doPostJson(JSON.toJSON(order));
        }
    }

}
