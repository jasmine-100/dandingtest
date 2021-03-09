package test.wmsDaita.testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.wmsDaita.testcase.dto.rq.RongQi;
import utils.client.gatewayDTO.GatewayHttpClient;
import utils.client.gatewayDTO.BaseTest;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/23 14:25
 */
public class RongqiApi extends LoginWms {
    int startno = 11;
    int endno =20;
    int temp = startno;

    @Test
    public void addRongqis(){
        for (int i=startno;i<=endno;i++){
            temp = i;
            addRongqi();
        }
    }

    @Test
    public void addRongqi(){
        RongQi rongQi = new RongQi("rq"+temp,"容器"+temp);
        GatewayHttpClient.send(client,"/dt-wms-portal/container/add",accessToken,rongQi);
    }

}
