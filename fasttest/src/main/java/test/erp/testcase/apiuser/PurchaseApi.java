package test.erp.testcase.apiuser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import test.erp.testcase.apiuser.dto.purchase.PurchasePage;
import test.erp.testcase.apiuser.dto.purchase.PurchaseSubmit;
import utils.client.gatewayDTO.GatewayHttpClient;
import utils.util.UtilJson;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/23 14:14
 */
public class PurchaseApi extends LoginErpUser {

    @Test
    public void selectPage(){
        //查询待审核的采购单
        String purchasePage = GatewayHttpClient.send(client,"/ares-web/purchase/selectPage",accessToken,new PurchasePage(1,1,"ACTIVE"));
        String data = UtilJson.getValueFromJson(purchasePage,"data");
        String datalist = UtilJson.getValueFromJson(data,"dataList");
        JSONArray jsonArray = JSONArray.parseArray(datalist);

        //提交审核
        for (int i=0;i<jsonArray.size();i++){
            String orderData = jsonArray.get(i).toString();
            JSONObject object = JSON.parseObject(orderData);
            String orderno = object.getString("purchaseOrderNo");
//            System.out.println(orderno);
            GatewayHttpClient.send(client,"/ares-web/purchase/submitAudit",accessToken, new PurchaseSubmit(orderno));
        }
    }


    @Test
    public void orderSubmit(){//提交审核
        GatewayHttpClient.send(client,"/ares-web/purchase/submitAudit",accessToken, new PurchaseSubmit("DP2104252425"));
    }

}
