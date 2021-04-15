package test.erp.testcase.outPuluosi;

import org.testng.annotations.Test;
import test.erp.testcase.outPuluosi.dto.Diaobo;
import test.erp.testcase.Data;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/14 10:33
 */
public class DiaoboApi extends Data {

    @Test
    public void orderSet(){
        String str = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        String orderno = "DO"+str;
        List<Diaobo.Good> goods = new ArrayList<>();
        goods.add(new Diaobo.Good("G1618377054127",null,1,0,"",""));
        Diaobo diaobo = new Diaobo("OP123466002",orderno,logicWarehouseCode,ownerCode,"2021-04-10 10:00:00",goods);

        ApiClient.doPostJson(urlPuluosi,null,null,diaobo);
    }

}
