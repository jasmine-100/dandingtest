package test.erp.testcase.apiuser;

import org.testng.annotations.BeforeTest;
import utils.client.gatewayDTO.BaseTest;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/9 17:02
 */
public class LoginErpUser extends BaseTest {

    @BeforeTest
    public void login(){
        this.login("但丁云","Abc123","/ucenter-account/customer/login");
    }

}
