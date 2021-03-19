package test.wmsDaita.testcase;

import org.testng.annotations.Test;
import test.wmsDaita.testcase.dto.GoodInfo;
import utils.client.gatewayDTO.GatewayHttpClient;

public class GoodInfoApi extends LoginWms {

    @Test
    public void goodinfoAdd(){
        GoodInfo goodInfo = new GoodInfo("塑料盒","suliao123","Jinyi","1","20","");
        GatewayHttpClient.send(client,"/dt-wms-portal/packageMaterial/add",accessToken,goodInfo);
    }

}
