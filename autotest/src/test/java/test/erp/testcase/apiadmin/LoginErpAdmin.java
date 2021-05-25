package test.erp.testcase.apiadmin;

import org.testng.annotations.BeforeTest;
import utils.client.gatewayDTO.BaseTest;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/9 17:02
 */
public class LoginErpAdmin extends BaseTest {

    @BeforeTest
    public void login(){
        this.login("admin","Abc123","/ucenter-account/admin/login");
    }

}
