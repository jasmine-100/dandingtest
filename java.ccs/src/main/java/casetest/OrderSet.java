package casetest;

import client.ApiClient;
import jxc.BaseParam;
import domain.Item;
import domain.Order;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 批量下单
 * @Date : Created in 2020/8/17 15:23
 */
public class OrderSet {
    // 下单
    @Test
    public static void orderSet()  {
        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("JHY11051404","SKU11051404",3,9));
        items.add(new Item("JHY10131610","SKU10131610",10,2));

        // 组装申报单
//        Order order = new Order("xiaoyuer","小鱼儿",outOrderno,"SF",Data.logiticsNo,Data.routeCode,items);
        Order order = new Order("xiaoyuer","小鱼儿", Data.outOrderNo,Data.declareOrderNo,"SF",Data.logiticsNo,Data.routeCode,items);
//        Order order = new Order("xiaoyuer","小鱼儿",outOrderno,"SF",Data.logiticsNo,Data.routeCode,"浙江省","杭州市","江干区",items);
        //接口：推送申报单
        ApiClient.doPostJson(BaseParam.URL_ORDER,null,null,order);
    }

}
