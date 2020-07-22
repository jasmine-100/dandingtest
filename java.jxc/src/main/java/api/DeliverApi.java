package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.deliver.Deliver;
import domain.deliver.Order;
import domain.deliver.OrderSku;
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
public class DeliverApi {

    @Test
    public void deliverOrder() throws IOException {
        //组装商品项
        List<OrderSku> orderSkus = new ArrayList<>();
        orderSkus.add(new OrderSku("DTS2236220",10));
//        orderSkus.add(new OrderSku("",50));

        //组装发货单
        Deliver deliver = new Deliver("J2006291514500970",orderSkus);

        //接口推送发货单
        ApiClient client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/dealorder/submit");
        String response = client.doPostJson(JSON.toJSON(deliver));

        //从返回值提取发货单的平台单号
        String orderStr = JsonUtils.getJsonStr(response,"orderNo").toString();

        //审核通过
        client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/dealorder/examineOrder");
        client.doPostForm(new Order(orderStr));

        //配货成功
        client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/dealorder/packingOrder");
        client.doPostForm(new Order(orderStr));

    }
}
