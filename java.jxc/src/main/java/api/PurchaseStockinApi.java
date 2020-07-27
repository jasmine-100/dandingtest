package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.ParamsWms;
import domain.ServiceType;
import domain.deliver.DeliverData;
import domain.deliver.Product;
import domain.deliverback.WmsRequestRoot;
import domain.good.Good;
import domain.stockin.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.JsonUtils;
import utils.XmlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 采购入库单
 * @Date : Created in 2020/7/20 12:32
 */
public class PurchaseStockinApi {
    static List<Good> goods = new ArrayList<Good>();

    @BeforeAll
    public static void setUp() {
        String str = "202007271724";
        goods.add(new Good(str + 1, "小西瓜", "0", "100", "12.6", "AAA"));
        goods.add(new Good(str + 2, "小西瓜", "0", "100", "12.6", "AAA"));
        goods.add(new Good(str + 3, "小西瓜", "0", "100", "12.6", "AAA"));
    }

    @Test
    public void createPurchaseStockinOrder() throws Exception{
        List<PurOrderItem> purOrderItems = new ArrayList<PurOrderItem>();
        List<StoOrderItem> stoOrderItems = new ArrayList<StoOrderItem>();

        for (Good good:goods){
            int num = 10000;
            //组装采购商品项
            PurOrderItem purOrderItem = new PurOrderItem(good.getProCode(),10.1,num);
            purOrderItems.add(purOrderItem);

            //入库单商品列表
            stoOrderItems.add(new StoOrderItem(good.getProCode(),String.valueOf(num)));
        }
        PurchaseOrder purchaseOrder = new PurchaseOrder(purOrderItems);

        //创建采购单
        ApiClient client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/purchase/upsert");
        String response = client.doPostJson(JSON.toJSON(purchaseOrder));
        String purchaseId = JsonUtils.getJsonStr(response,"purOrderId").toString();
        Thread.sleep(2000);

        //创建入库单
        this.createStockinOrder(purchaseId,stoOrderItems);

    }

    @Test
    public void deliverBack() throws Exception {
        String stockinOrderNo = "ET20200727175206898938";
        String url = "http://hwms-notify-fat.yang800.com/dt/notify";

        List<Product> products = new ArrayList<>();
        for (Good good:goods){
            int num = 10000;
            //入库单回执商品列表
            String i = good.getIsbatch();
            if(i.equals("1")){
                products.add(new Product(good.getProCode(),"201010",num,"2020-1-1","2022-1-1","ZP"));
            }else{
                products.add(new Product(good.getProCode(),"",num,"2020-1-1","2022-1-1","ZP"));
            }
        }

        //组装bizdata
        StockinData stockinData = new StockinData(stockinOrderNo,"01","GL01",BillType.CAIGOU,products);

        //组装请求参数
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(stockinData), ServiceType.PURCHASE,"1.0");

        ApiClient.doPostXml(url,null,null,param);
    }

    //创建采购单关联的入库单
    public void createStockinOrder(String purchaseId,List<StoOrderItem> stoOrderItems) throws IOException {
        //创建入库单
        StockinOrder stockinOrder = new StockinOrder(purchaseId,stoOrderItems);
        ApiClient client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/stockin/upsert");
        client.doPostJson(JSON.toJSON(stockinOrder));
    }

}
