package erp.apitest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/19 17:22
 */
public class TestRestAsured {

    @Test
    void restGet() {
        RestAssured.given().get("https://www.baidu.com/")
                .then()
                .statusCode(200)
                .log().all();
    }

}
