package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.AppId;
import domain.Params;
import domain.ServiceName;
import domain.deliver.DeliverOrder;
import domain.stockin.Sku;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 17:40
 */
public class DeliverApi {

    String url = "http://outtest.order.yang800.cn/open/testV3";
    ApiClient client = new ApiClient(url);

    String whCode = "TESTDEPOT001";
    String accessCode = "DS15628267317912";

    String orderno = "DE1002630096";

    //推送发货单
    @Test
    public void deliverPush() throws IOException {
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("JHK000123",100));

        DeliverOrder deliver = new DeliverOrder(accessCode,whCode,orderno,skuList);
        Params params = new Params(JSON.toJSON(deliver).toString(), ServiceName.DELIVER_CREATE, AppId.WMSV3);

        client.doPostForm(params);
    }

}
