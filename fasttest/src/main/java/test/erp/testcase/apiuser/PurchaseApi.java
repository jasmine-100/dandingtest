package test.erp.testcase.apiuser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import org.testng.annotations.Test;
import test.erp.testcase.apiuser.dto.purchase.PurchasePage;
import test.erp.testcase.apiuser.dto.purchase.PurchaseSubmit;
import utils.client.gatewayDTO.BaseTest;
import utils.client.gatewayDTO.GatewayHttpClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/23 14:14
 */
public class PurchaseApi extends LoginErpUser {

    @Test
    public void selectPage(){
        //查询待审核数据
        String purchasePage = GatewayHttpClient.send(client,"/ares-web/purchase/selectPage",accessToken,new PurchasePage(1,1,"ACTIVE"));
        String data = JSON.parseObject(purchasePage).get("data").toString();
        String datalist = JSON.parseObject(data).get("dataList").toString();
        JSONArray jsonArray = JSONArray.parseArray(datalist);

        //提交审核操作
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
