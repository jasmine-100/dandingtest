package test.oms.testcase;

import org.testng.annotations.Test;
import test.erp.testcase.apiuser.LoginErpUser;
import test.oms.testcase.dto.order.Item;
import test.oms.testcase.dto.order.OrderDTO;
import test.oms.testcase.dto.ordercancel.OrderCancel;
import utils.client.apiclientDTO.ApiClient;
import utils.client.gatewayDTO.BaseTest;
import utils.client.gatewayDTO.GatewayHttpClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 新版OMS 内部下单接口
 * @Date : Created in 2021/01/06 14:08
 */
public class OrderSet extends LoginErpUser {

    @Test
    public void orders(){
        for (int i=0;i<5;i++){
            order1();
        }
    }

    @Test
    public void order1(){ // 哈哈科技有限公司，黑店
        String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//        String orderNo = "JOS3213232";
        String orderNo = "JOS"+str;
        String expressNo = "SF"+str;
        List<Item> items = new ArrayList<>();

//        items.add(new Item("SKU04301754","外部保税商品","",100,10));
        items.add(new Item("SKU04301752","外部完税商品","",50,10));
//        items.add(new Item("JD04301453","京东小商品","",50,1));
        OrderDTO order = new OrderDTO(orderNo,items,"SF",expressNo,"V2",Data.accessCode1,"浙江省","杭州市","滨江");
//        OrderDTO order = new OrderDTO(orderNo,items,"SF",saleChannel,null,"V2",accessCode1);

        ApiClient.doPostJson(Data.OrderUrl,null,null,order);
    }

    @Test
    public void cancel(){
        OrderCancel orderCancel = new OrderCancel("GS2105131648358540144277");

        GatewayHttpClient.send(client,"/ares-web/aftermarket/cancel",accessToken,orderCancel);
    }
}
