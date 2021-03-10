package test.erp.testcase.api;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import test.erp.testcase.api.dto.good.Good;
import test.erp.testcase.api.dto.good.PurPrice;
import test.erp.testcase.api.dto.good.PurSupplier;
import utils.client.gatewayDTO.GatewayHttpClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/5 15:05
 */
public class GoodApi extends LoginErp {

    // 添加新货品
    @Test
    public void goodAdd(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String goodId = "ID"+str;
        String supplierCode = "S642180";

        //添加货品
        Good good = new Good(goodId,"棒棒糖","BR1611112740116","DUTY_PAID",100,"NO");
        GatewayHttpClient.send(client,"/ares-web/goods/save",accessToken,good);

        //采购价：添加供应商关联
        List<String> supplierList = new ArrayList<>();
        supplierList.add(supplierCode);
        PurSupplier supplier = new PurSupplier(goodId,supplierList);
        GatewayHttpClient.send(client,"/ares-web/supplier/mixSupplierByCode",accessToken,supplier);

        // 采购价：添加采购价
        PurPrice purPrice = new PurPrice(supplierCode,goodId,"HKD",100,"20201010000000","20210510000000");
        String response = GatewayHttpClient.send(client,"/ares-web/supplier/mixOnePriceWithGood",accessToken,purPrice);

        //采购价：提交审核
        JSONObject json = JSONObject.parseObject(response);
        System.out.println(json);
        String msg = json.getString("message");//获取采购价id
        System.out.println(msg);

    }

}
