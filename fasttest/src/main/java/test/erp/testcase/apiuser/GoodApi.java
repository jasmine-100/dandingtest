package test.erp.testcase.apiuser;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import test.erp.testcase.apiuser.dto.good.Good;
import test.erp.testcase.apiuser.dto.goodPrice.PurPrice;
import test.erp.testcase.apiuser.dto.goodPrice.PurPriceSubmit;
import test.erp.testcase.apiuser.dto.goodPrice.PurSupplier;
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
public class GoodApi extends LoginErpUser {

    // 添加新货品
    @Test
    public void addGoods() throws Exception{

        for(int i=1;i<=1000;i++){
//            String goodId = "SKU0100"+i;// 无效期
            String goodId = "SKU0200"+i;// 有效期
            String supplierCode = "S706796";

            //添加货品
//            Good good = new Good(goodId,"签字笔(无效期)","BR1619056691692","DUTY_PAID",100,"NO");
            Good good = new Good(goodId,"奶粉(有效期)","BR1619056691692","DUTY_PAID",100,"YES");
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
//        System.out.println(json);
            String priceId = json.getString("data");//获取采购价id
            PurPriceSubmit priceSubmit = new PurPriceSubmit(priceId);
            GatewayHttpClient.send(client,"/ares-web/goodsMixedSupplier/submitAudit",accessToken,priceSubmit);

//            Thread.sleep(1000);
        }
    }

}
