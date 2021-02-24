package test.oms;

import org.testng.annotations.Test;
import test.oms.account.Account;
import utils.client.GatewayHttpClient;
import utils.client.gatewayDTO.BaseTest;

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
        GatewayHttpClient.send(client,Data.uri_account,accessToken,account);
    }
}
