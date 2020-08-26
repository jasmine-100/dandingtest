package casetest;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import com.google.protobuf.Api;
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
    @Test
    public void testMore() throws Exception {
        for (int i =0;i<2;i++){
            orderSet();
        }
    }

    // 下单
    @Test
    public void orderSet() throws Exception {
        String str = new SimpleDateFormat("MMddHHmmssSSS").format(new Date());
        // 渠道订单号
        String outOrderno = "JC"+str;
        // 申报单号
        String declareOrderNo = "DC"+str;
        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("JHKY08241053","SKU08241053",3,9));
        items.add(new Item("JHKY08241046","SKU08241046",10,2));

        // 组装申报单
//        Order order = new Order("xiaoyuer","小鱼儿",outOrderno,"SF",Data.logiticsNo,Data.routeCode,items);
//        Order order = new Order("xiaoyuer","小鱼儿",outOrderno,declareOrderNo,"SF",Data.logiticsNo,Data.routeCode,"","","",items);
        Order order = new Order("xiaoyuer","小鱼儿",outOrderno,"SF",Data.logiticsNo,Data.routeCode,"浙江省","杭州市","江干区",items);
        //接口：推送申报单
        ApiClient.doPostJson(BaseParam.URL_ORDER,null,null,order);
    }

}
