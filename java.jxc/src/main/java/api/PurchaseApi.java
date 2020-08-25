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
//
//    public void stockin() throws Exception {
//        // 创建采购单
//        String purchaseId = createPurchaseOrder();
//        Thread.sleep(1000);
//        // 审核通过
//        examine(purchaseId);
//    }

    // 创建采购单
    @Test
    public String createPurchaseOrder() throws Exception{
        // 采购商品项
        List<PurOrderItem> purOrderItems = new ArrayList<PurOrderItem>();
        purOrderItems.add(new PurOrderItem("20200825172332",10,1000));

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
    @Test
    public void examine(String purchaseId) throws Exception {
        ApiClient.doPostForm(BaseParam.PURCHASE_EXAMINE+"?purOrderId="+purchaseId,null,Cookie.getCookie(),null);
    }

    @Test
    public void stockin() throws Exception {
        String purchaseId = "PS20200825180608624369";
        // 入库单商品项
        List<StoOrderItem> stoOrderItems = new LinkedList<>();
        stoOrderItems.add(new StoOrderItem("20200825172332",1000));

        // 入库单信息
        StockinOrder stockinOrder = new StockinOrder("LSMSMJQJMW",purchaseId,stoOrderItems);

        // 借口推送
        ApiClient.doPostJson(BaseParam.STOCKIN_ADD,null,Cookie.getCookie(),stockinOrder);
    }

//    @Test
//    public void orderBack() throws Exception {
//        String stockinOrderNo = "ET20200728140915928315";
//
//        List<Product> products = new ArrayList<Product>();
//        for (Good good:goods){
//            int num = 10000;
//            //入库单回执商品列表
//            int i = good.getIsbatch();
//            if(i==1){
//                products.add(new Product(good.getProCode(),"201010",num,"2020-1-1","2022-1-1","ZP"));
//            }else{
//                products.add(new Product(good.getProCode(),"",num,"2020-1-1","2022-1-1","ZP"));
//            }
//        }
//
//        //组装bizdata
//        StockinData stockinData = new StockinData(stockinOrderNo,"01","GL01",BillType.CAIGOU,BillType.CAIGOU,products);
//        System.out.println(XmlUtil.objToXml(stockinData));
//
//        //组装请求参数
//        ParamsWms param = new ParamsWms(XmlUtil.objToXml(stockinData), ServiceType.STOCKIN_BACK,"1.0");
//
//        new ApiClient(BaseParam.WMS_BACK).doPostForm(param);
//    }
//
//    //创建采购单关联的入库单
//    public void createStockinOrder(String purchaseId,List<StoOrderItem> stoOrderItems) throws IOException {
//        //创建入库单
//        StockinOrder stockinOrder = new StockinOrder(purchaseId,stoOrderItems);
//        ApiClient client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/stockin/upsert");
//        client.doPostJson(JSON.toJSON(stockinOrder));
//    }

}
