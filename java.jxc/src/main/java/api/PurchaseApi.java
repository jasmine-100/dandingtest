package api;

import client.ApiClient;
import com.alibaba.fastjson.JSONObject;
import dao.BaseParam;
import dao.Cookie;
import dao.WmsData;
import domainout.deliverback.Product;
import domainout.deliverback.WmsRequestRoot;
import domainout.stockin.*;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 采购入库单
 * @Date : Created in 2020/7/20 12:32
 */
public class PurchaseApi {

    // 创建采购单
    public static String createPurchaseOrder(String procode,int num) throws Exception{
        // 采购商品项
        List<PurOrderItem> purOrderItems = new ArrayList<PurOrderItem>();
        purOrderItems.add(new PurOrderItem(procode,10,num));

        // 采购单信息
        PurchaseOrder purchaseOrder = new PurchaseOrder(purOrderItems);

        // 接口推送
        String response = ApiClient.doPostJson(BaseParam.PURCHASE_ADD,null, Cookie.getCookie(),purchaseOrder);

        // 获取采购单号
        JSONObject jsonObject = (JSONObject) JSONObject.parse(response);
        JSONObject object = (JSONObject) jsonObject.get("result");
        String purchaseId = (String) object.get("purOrderId");

        return purchaseId;
    }

    // 采购单审核通过
    public static void examine(String purchaseId) throws Exception {
        ApiClient.doPostForm(BaseParam.PURCHASE_EXAMINE+"?purOrderId="+purchaseId,null,Cookie.getCookie(),null);
    }



}
