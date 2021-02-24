package v3.api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;
import v3.domain.Params;
import v3.domain.deliver.DeliverOrder;
import v3.domain.stockin.Sku;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 17:40
 */
public class DeliverApi {

    //推送发货单
    @Test
    public void deliverPush(){
        String orderno = "JOD"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("JHK000123", 100));

        DeliverOrder deliver = new DeliverOrder(Data.accessCode, Data.whcode, orderno, skuList);
        Params params = new Params(JSON.toJSON(deliver).toString(), "delivery.create", "WMSV3");

        ApiClient.doPostForm(Data.URL, params, null, null);
    }

}
