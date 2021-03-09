package utils.client.gatewayDTO;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Dante-GXJ
 * @Date: 2020/10/15 11:44
 * @Description:
 */
public abstract class BaseTest {

    protected String accessToken;

    //开发环境
    protected GatewayHttpClient devClient = new GatewayHttpClient("http://192.168.20.200:9195","96A63530DA0C49BB9FABB66ED40FB3C7","F6A99B36E4D24817AB037237454893D9",true);
    //测试环境
    protected GatewayHttpClient testClient = new GatewayHttpClient("http://danding-gateway-pre.yang800.com","96A63530DA0C49BB9FABB66ED40FB3C7","F6A99B36E4D24817AB037237454893D9",true);
    //线上环境
    protected GatewayHttpClient onlineClient = new GatewayHttpClient("http://danding-gateway.yang800.com","9E514E70AD7D485986D687F64616C662","33F14542BB274284B63147E6C8F3DF9E",true);
    protected GatewayHttpClient client;

    public void login(String name,String pwd){
        client = testClient;
        if (client.getLoginFlag()){
            Map<String,String> param = new HashMap<>();
            param.put("userName",name);
            param.put("password",pwd);
            String result = GatewayHttpClient.send(client,"/ucenter-account/customer/login","",param);
            LoginToken loginToken = JSON.parseObject(result,LoginToken.class);
            accessToken = loginToken.getData().getAccessToken();
        }else {
            accessToken = "";
        }
    }
}
