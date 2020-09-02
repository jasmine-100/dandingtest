package qimen.jxc.casetest;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import qimen.domain.Param;
import qimen.domain.stockin.EntryOrder;
import qimen.domain.stockin.OrderData;
import qimen.domain.stockin.OrderLine;
import qimen.jxc.api.Data;
import qimen.jxc.api.OrderStockin;
import qimen.jxc.api.StockinModel;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.Product;
import wms.domain.stockin.StockinData;
import wms.jxc.BaseParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 9:54
 */
public class StockinDiaobo {
    //外部订单号，相同货主内唯一
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 下单
    @Test
    public void stockinOrder() throws Exception {
        //组装商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine("SKU09021031", 2000, ""));
        orderLines.add(new OrderLine("SKU09021032", 3000, ""));
        //组装订单项
        EntryOrder entryOrder = new EntryOrder(orderno, "LSBNV8LQYC", "DBRK", "S200831171556010296");
        //组装请求body
        OrderData orderData = new OrderData(entryOrder, orderLines);

        ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
    }
    // 回执
    @Test
    public void stockinBack() throws Exception {
        List<Product> products = new LinkedList<>();
        products.add(new Product("SKU09021031","",1000,"","","ZP"));
        products.add(new Product("SKU09021032","200902",3000,"2020-01-02 10:20:30","2025-01-02 10:20:30","ZP"));
//        products.add(new Product("SKU09011645","20200901",100,"2020-08-11 10:00:50","2021-08-11 10:00:50","ZP"));
//        products.add(new Product("SKU09011645","20200902",500,"2020-08-11 10:00:50","2021-08-11 10:00:50","ZP"));
//        products.add(new Product("SKU09011645","20200901",100,"2020-08-11 10:00:50","2021-08-11 10:00:50","CP"));
//        products.add(new Product("SKU09011645","20200903",1000,"2020-08-11 10:00:50","2021-08-11 10:00:50","ZP"));
//        products.add(new Product("SKU09011645","20200904",300,"2020-08-11 10:00:50","2021-08-11 10:00:50","ZP"));
//        products.add(new Product("SKU09011645","20200905",1000,"2020-08-11 10:00:50","2021-08-11 10:00:50","ZP"));
        StockinData stockinData = new StockinData("ET20200902103325576292","LSBNV8LQYC","GL01","DBRK",0,1,products);
        ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");

        ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
    }


}
