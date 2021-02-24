package test.wmsDaita;

import org.testng.annotations.Test;
import utils.client.GatewayHttpClient;
import utils.client.gatewayDTO.BaseTest;
import test.wmsDaita.dto.rq.RongQi;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/23 14:25
 */
public class RongqiApi extends BaseTest {

    @Test
    public void addRongqis(){
        for (int i=3;i<10;i++){
            addRongqi(i);
        }
    }

    @Test
    public void addRongqi(int i){
        this.login();
//        int i = 2;
        RongQi rongQi = new RongQi("rq"+i,"容器"+i);
        GatewayHttpClient.send(client,Data.rongqiUri,accessToken,rongQi);
    }

}
