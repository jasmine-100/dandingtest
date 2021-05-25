package test.erp.testcase.outPuluosi;

import org.testng.annotations.Test;
import test.erp.testcase.Data;
import test.erp.testcase.outPuluosi.dto.Stockin;
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
        goods.add(new Stockin.Good("SKU210407155457",1000));
//        goods.add(new Stockin.Good("SKU210414164733",300));
        Stockin stockin = new Stockin("PLS123200001",orderno,ownerCode,logicWarehouseCode,"2021-05-01 10:00:00",goods);

        ApiClient.doPostJson(urlPuluosi,null,null,stockin);
    }
}
