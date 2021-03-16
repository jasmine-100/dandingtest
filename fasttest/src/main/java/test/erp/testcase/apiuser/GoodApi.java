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

    @Test
    public void addGood(){
        String goodId = "SKU"+new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        String supplierCode = "S642180";

        //添加货品
        Good good = new Good(goodId,"棉花糖","BR1611112740116","BONDED",100,"NO");
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
    }

    // 添加新货品
    @Test
    public void addGoods(){
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        for(int i=1;i<=5;i++){
            String goodId = "SKU03161311_"+i;
            String supplierCode = "S642180";

            //添加货品
            Good good = new Good(goodId,"口香糖"+i,"BR1611112740116","DUTY_PAID",100,"NO");
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
        }
    }

}
