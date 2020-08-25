package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domainout.ParamsWms;
import domainout.ServiceType;
import domainout.deliver.Product;
import domainout.good.Good;
import domainout.stockin.*;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;
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

    @BeforeClass
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
    public void orderBack() throws Exception {
        String stockinOrderNo = "ET20200728140915928315";
        String url = "http://hwms-notify-fat.yang800.com/dt/notify";

        List<Product> products = new ArrayList<Product>();
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
        StockinData stockinData = new StockinData(stockinOrderNo,"01","GL01",BillType.CAIGOU,BillType.CAIGOU,products);
        System.out.println(XmlUtil.objToXml(stockinData));

        //组装请求参数
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(stockinData), ServiceType.STOCKIN_BACK,"1.0");

        ApiClient client = new ApiClient(url);
        client.doPostForm(param);
    }


    //创建采购单关联的入库单
    public void createStockinOrder(String purchaseId,List<StoOrderItem> stoOrderItems) throws IOException {
        //创建入库单
        StockinOrder stockinOrder = new StockinOrder(purchaseId,stoOrderItems);
        ApiClient client = new ApiClient("http://logistics-api-fat.yang800.com/xhr/stockin/upsert");
        client.doPostJson(JSON.toJSON(stockinOrder));
    }

}
