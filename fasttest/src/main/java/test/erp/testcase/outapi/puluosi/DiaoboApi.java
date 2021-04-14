package test.erp.testcase.outapi.puluosi;

import org.testng.annotations.Test;
import test.erp.testcase.outapi.Data;
import test.erp.testcase.outapi.puluosi.dto.Diaobo;
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
        goods.add(new Diaobo.Good("","","",10,0,"",""));
        Diaobo diaobo = new Diaobo(orderno,warehouseCode,ownerCode,"2021-04-10 10:00:00","浙江省杭州市上城区九堡科技园25幢2楼",goods);

        ApiClient.doPostJson(urlPuluosi,null,null,diaobo);
    }

}
