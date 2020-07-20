package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.*;
import org.junit.jupiter.api.Test;
import utils.ExcelUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:32
 */
public class PurchaseStockinApi {

    @Test
    public void createPurchaseStockinOrder() throws Exception{
        List<Good> goods = new ArrayList<Good>();
        List<Product> products = new ArrayList<Product>();
        List<PurOrderItem> purOrderItems = new ArrayList<PurOrderItem>();
        List<StoOrderItem> stoOrderItems = new ArrayList<StoOrderItem>();

        try {
            goods = ExcelUtils.readGoods();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Good good:goods){
            int num = 100;
            //组装采购商品项
            PurOrderItem purOrderItem = new PurOrderItem(good.getProCode(),10.1,num);
            purOrderItems.add(purOrderItem);

            //入库单商品列表
            stoOrderItems.add(new StoOrderItem(good.getProCode(),String.valueOf(num)));

            //入库单回执商品列表
            products.add(new Product(good.getProCode(),good.getIsbatch(),String.valueOf(num),"ZP"));
        }
        PurchaseOrder purchaseOrder = new PurchaseOrder(purOrderItems);

        //创建采购单
        ApiClient client = new ApiClient("http://logistics-api-dev.yang800.com/xhr/purchase/upsert");
        String response = client.doPostJson(JSON.toJSON(purchaseOrder));
        String purchaseId = JsonUtils.getJsonStr(response,"purOrderId").toString();
        Thread.sleep(5000);

        //创建入库单
        this.createStockinOrder(purchaseId,stoOrderItems);

        // WMS回执
//        this.back(products);

    }


    //创建采购单关联的入库单
    public void createStockinOrder(String purchaseId,List<StoOrderItem> stoOrderItems) throws IOException {
        //创建入库单
        StockinOrder stockinOrder = new StockinOrder(purchaseId,stoOrderItems);
        ApiClient client = new ApiClient("http://logistics-api-dev.yang800.com/xhr/stockin/upsert");
        client.doPostJson(JSON.toJSON(stockinOrder));
    }

//    public void back(List<Product> products) throws IOException {
//        //入库单回执
//        String stockinOrderNo = "ET20200713175057516371";
//        String url1 = "http://192.168.20.201:8000/dt/notify";
//        String url2 = "http://hwms-notify-fat.yang800.com/dt/notify";
//        ApiHttpClient client = new ApiHttpClient(url2);
//        List<Product> productList = products;
//        WmsRequestRoot wmsRequestRoot = new WmsRequestRoot(stockinOrderNo,"1",productList);
//        WmsData wmsData = new WmsData(XmlUtils.objectToXml(wmsRequestRoot));
//        client.doPostJson(JSON.toJSON(wmsData));
//    }
}
