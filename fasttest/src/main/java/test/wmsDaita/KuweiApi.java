package test.wmsDaita;

import org.testng.annotations.Test;
import test.wmsDaita.dto.Kuwei.Hangdao;
import test.wmsDaita.dto.Kuwei.Kuqu;
import test.wmsDaita.dto.Kuwei.Kuwei;
import utils.client.GatewayHttpClient;
import utils.client.gatewayDTO.BaseTest;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 19:49
 */
public class KuweiApi extends BaseTest {

    @Test
    public void kuquAdd(){ //添加库区
        this.login();
        Kuqu kuqu = new Kuqu("KqJx00002","拣选区","11","AVL");
        GatewayHttpClient.send(client,"/dt-wms-portal/zone/create",accessToken,kuqu);
    }

    @Test
    public void hangdaoAdd(){// 添加巷道
        this.login();
        Hangdao hangdao = new Hangdao("HdJx00002","KqJx00002");
        GatewayHttpClient.send(client,"/dt-wms-portal/tunnel/create",accessToken,hangdao);
    }

    @Test
    public void kuweiAdd(){ // 添加库位
        this.login();
        Kuwei kuwei = new Kuwei("KwJx000024","KqJx00002","HdJx00002");//正品库位
//        Kuwei kuwei = new Kuwei("KwJx000011","KqJx00001","HdJx00001");//次品库位
        GatewayHttpClient.send(client,"/dt-wms-portal/location/create",accessToken,kuwei);
    }

}
