package v3.api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;
import v3.domain.Params;
import v3.domain.outbound.OutboundOrder;
import v3.domain.stockin.Sku;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 18:29
 */
public class OutboundApi {

    //推送出库单
    @Test
    public void deliverPush() {
        String orderno = "JOB"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("JHK000123",100));

        OutboundOrder outboundOrder = new OutboundOrder("CGTHCKD",Data.accessCode,Data.whcode,orderno,skuList);
        Params params = new Params(JSON.toJSON(outboundOrder).toString(), "stockout.create", "WMSV3");

        ApiClient.doPostForm(Data.URL,params,null,null);

    }

}
