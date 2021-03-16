package test.erp.testcase.apiadmin;

import org.testng.annotations.Test;
import test.erp.testcase.apiadmin.dto.stockout.StockoutCancel;
import test.erp.testcase.apiadmin.dto.stockout.StockoutPush;
import utils.client.gatewayDTO.GatewayHttpClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/16 18:23
 */
public class StockoutOrder extends LoginErpAdmin {

    @Test
    public void orderPush(){
        for (int i=0;i<2;i++){
            StockoutPush stockoutPush = new StockoutPush("OB202103161829310506832598");
            GatewayHttpClient.send(client,"/ares-admin/outOrder/audit",accessToken,stockoutPush);//审核
            GatewayHttpClient.send(client,"/ares-admin/outOrder/pushOutOrder",accessToken,stockoutPush);//推送
        }
    }

    @Test
    public void orderCancel(){
        for (int i=0;i<2;i++){
            StockoutCancel stockoutCancel = new StockoutCancel("OB202103161829310506832598");
            GatewayHttpClient.send(client,"/ares-admin/outOrder/revocation",accessToken,stockoutCancel);
        }
    }
}
