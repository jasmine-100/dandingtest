package test.erp.testcase.outapi.puluosi;

import org.testng.annotations.Test;
import test.erp.testcase.outapi.Data;
import test.erp.testcase.outapi.puluosi.dto.Diaobo;
import test.erp.testcase.outapi.puluosi.dto.Stockin;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/14 11:01
 */
public class StockinApi extends Data {

    @Test
    public void stockinSet(){
        String str = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        String orderno = "JIN"+str;
        List<Stockin.Good> goods = new ArrayList<>();
        goods.add(new Stockin.Good("G1618377054127","小火花","个",100));
        Stockin stockin = new Stockin("PLS123200001",orderno,ownerCode,logicWarehouseCode,"2021-05-01 10:00:00",goods);

        ApiClient.doPostJson(urlPuluosi,null,null,stockin);
    }
}
