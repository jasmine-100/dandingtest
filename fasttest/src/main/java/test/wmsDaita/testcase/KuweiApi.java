package test.wmsDaita.testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.wmsDaita.testcase.dto.Kuwei.Hangdao;
import test.wmsDaita.testcase.dto.Kuwei.Kuqu;
import test.wmsDaita.testcase.dto.Kuwei.Kuwei;
import utils.client.gatewayDTO.GatewayHttpClient;
import utils.client.gatewayDTO.BaseTest;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 19:49
 */
public class KuweiApi extends LoginWms {
//    String kuquCode = "KqJx000CP1";//次品库区
//    String hangdaoCode = "HdJx000CP1";//次品巷道
//    String kuweiCode = "KwJx000CP2";//次品库位

    String kuquCode = "KqJx000ZP2";//正品库区
    String hangdaoCode = "HdJx000ZP2";//正品巷道
    String kuweiCode = "KwJx000ZP2";//正品库位

    @Test
    public void kuquAdd(){ //添加库区
        Kuqu kuqu = new Kuqu(kuquCode,"拣选库区","11","AVL");
        GatewayHttpClient.send(client,"/dt-wms-portal/zone/create",accessToken,kuqu);
    }

    @Test
    public void hangdaoAdd(){// 添加巷道
        Hangdao hangdao = new Hangdao(hangdaoCode,kuquCode);
        GatewayHttpClient.send(client,"/dt-wms-portal/tunnel/create",accessToken,hangdao);
    }

    @Test
    public void kuweiAdd(){ // 添加库位
        Kuwei kuwei = new Kuwei(kuweiCode,kuquCode,hangdaoCode);//正品库位
        GatewayHttpClient.send(client,"/dt-wms-portal/location/create",accessToken,kuwei);
    }

}
