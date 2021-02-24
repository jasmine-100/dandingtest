package test.wmsDaita;

import org.testng.annotations.Test;
import test.wmsDaita.dto.Kuwei.Kuwei;
import utils.client.GatewayHttpClient;
import utils.client.gatewayDTO.BaseTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 19:49
 */
public class KuweiApi extends BaseTest {

    @Test
    public void kuweiAdd(){
        this.login();
        Kuwei kuwei = new Kuwei("KwJx"+new SimpleDateFormat("yyMMddHHmmss").format(new Date()));
        GatewayHttpClient.send(client,Data.kuweiUri,accessToken,kuwei);
    }

}
