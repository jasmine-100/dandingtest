package test.erp.testcase.apiadmin;

import org.testng.annotations.Test;
import test.erp.testcase.apiadmin.dto.miandan.Miandan;
import utils.client.gatewayDTO.GatewayHttpClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/26 11:00
 */
public class MaindanApi extends LoginErpAdmin{

    @Test
    public void miandanAdd(){
        Miandan miandan = new Miandan("BJCQfefd9d","海南仓","CAINIAO","V2");
        GatewayHttpClient.send(client,"/ares-admin/wayBillPlatform/upset",accessToken,miandan);
    }

}
