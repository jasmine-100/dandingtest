package test.wmsDaita.testcase;

import org.testng.annotations.BeforeTest;
import utils.client.gatewayDTO.BaseTest;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/9 17:03
 */
public class LoginWms extends BaseTest {

    @BeforeTest
    public void login(){
        this.login("小姐姐","Abc123","/ucenter-account/customer/login");
    }

}
