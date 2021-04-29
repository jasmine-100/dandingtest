package test.oms.testcase;

import org.testng.annotations.Test;
import test.erp.testcase.apiuser.LoginErpUser;
import test.oms.testcase.dto.intercept.Intercept;
import utils.client.gatewayDTO.GatewayHttpClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/29 13:10
 */
public class OrderInterceptApi extends LoginErpUser {

    @Test
    public void interceptOrder(){
        for (int i=0;i<10;i++){
            Intercept intercept = new Intercept("1203","JOS0429000"+i);

            GatewayHttpClient.send(client,"/ares-web/interceptOrder/addIntercept",accessToken,intercept);
        }
    }

}
