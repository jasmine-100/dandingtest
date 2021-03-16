package test.erp.testcase.apiadmin;

import org.testng.annotations.Test;
import test.erp.testcase.apiadmin.dto.stockin.StockinCancel;
import test.erp.testcase.apiadmin.dto.stockin.StockinPush;
import utils.client.gatewayDTO.GatewayHttpClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/16 17:36
 */
public class StokinOrder extends LoginErpAdmin {

    // 推送入库单到wms
    @Test
    public void orderPush(){
        for(int i=0;i<2;i++) {
            StockinPush stockinPush = new StockinPush("ET202103152207480366983729");
            GatewayHttpClient.send(client,"/ares-admin/inOrder/pushInOrder",accessToken,stockinPush);
        }
    }

    //小二取消入库单
    @Test
    public void orderCancel(){
        for (int i=0;i<2;i++) {
            StockinCancel stockinCancel = new StockinCancel("ET202103161619100671976501");
            GatewayHttpClient.send(client, "/ares-admin/inOrder/revocation", accessToken, stockinCancel);
        }
    }

}
