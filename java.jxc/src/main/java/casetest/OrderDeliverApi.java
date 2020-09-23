package casetest;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import com.google.protobuf.Api;
import domainout.deliver.Deliver;
import domainout.deliver.Order;
import domainout.deliver.OrderSku;
import org.junit.jupiter.api.Test;
import utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 创建发货单--审核--配货
 * @Date : Created in 2020/7/20 14:45
 */
public class OrderDeliverApi {

    @Test
    public void deliverOrder() {
        //组装商品项
        List<OrderSku> orderSkus = new ArrayList<>();
        orderSkus.add(new OrderSku("DTNF07061102",10));
//        orderSkus.add(new OrderSku("",50));

        //组装发货单
        Deliver deliver = new Deliver("J2006291514500970",orderSkus);

        //接口推送发货单
        String response = ApiClient.doPostJson("http://logistics-api-fat.yang800.com/xhr/dealorder/submit",null,null,deliver);
        //从返回值提取发货单的平台单号
        String orderStr = JsonUtils.getJsonStr(response,"orderNo").toString();

        //审核通过
        ApiClient.doPostForm("http://logistics-api-fat.yang800.com/xhr/dealorder/examineOrder",null,null,new Order(orderStr));

        //配货成功
        ApiClient.doPostForm("http://logistics-api-fat.yang800.com/xhr/dealorder/packingOrder",null,null,new Order(orderStr));

    }
}
