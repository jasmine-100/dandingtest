package api;

import client.ApiClient;
import com.alibaba.fastjson.JSONObject;
import casetest.BaseParam;
import casetest.Cookie;
import domainout.stockin.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 采购入库单
 * @Date : Created in 2020/7/20 12:32
 */
public class PurchaseApi {

    // 创建采购单
    public static String createPurchaseOrder(String procode,int num,String supplierCode,String billCurrency) throws Exception{
        // 采购商品项
        List<PurOrderItem> purOrderItems = new ArrayList<PurOrderItem>();
        purOrderItems.add(new PurOrderItem(procode,10,num));

        // 采购单信息
        PurchaseOrder purchaseOrder = new PurchaseOrder(purOrderItems,supplierCode,billCurrency);

        // 接口推送
        String response = ApiClient.doPostJson(BaseParam.PURCHASE_ADD,null, Cookie.getCookie(),purchaseOrder);
        Thread.sleep(1000);
        // 获取采购单号
        JSONObject jsonObject = (JSONObject) JSONObject.parse(response);
        JSONObject object = (JSONObject) jsonObject.get("result");
        String purchaseId = (String) object.get("purOrderId");

        return purchaseId;
    }

    // 采购单审核通过
    public static void examine(String purchaseId){
        ApiClient.doPostForm(BaseParam.PURCHASE_EXAMINE+"?purOrderId="+purchaseId,null,Cookie.getCookie(),null);
    }

}
