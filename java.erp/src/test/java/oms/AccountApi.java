package oms;

import client.GatewayHttpClient;
import client.gatewayDTO.BaseTest;
import oms.account.Account;
import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/26 10:52
 */
public class AccountApi extends BaseTest {

    @Test
    public void createAccount(){
        this.login();
        Account account = new Account();
        GatewayHttpClient.send(client,Data.uri_account,account,accessToken);
    }
}
