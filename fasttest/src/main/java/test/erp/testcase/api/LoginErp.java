package test.erp.testcase.api;

import org.testng.annotations.BeforeTest;
import utils.client.gatewayDTO.BaseTest;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/9 17:02
 */
public class LoginErp extends BaseTest {

    @BeforeTest
    public void login(){
        this.login("哈哈科技有限公司","Abc123");
    }

}
