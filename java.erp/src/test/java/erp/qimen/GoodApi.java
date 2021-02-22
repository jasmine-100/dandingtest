package erp.qimen;

import org.testng.annotations.Test;
import utils.client.ApiClient;
import erp.qimen.dto.Params;
import erp.qimen.dto.good.Good;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodApi extends Data {

    @Test
    public void goodAdd(){
        String str = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        String goodNo = "SK" + str;
//        String goodNo = "SK210222112519";
        Good good = new Good(goodNo,"小白兔",str,warehouseCode,ownerCode);
        Params params = new Params(goodNo,"3",good);

        ApiClient.doPostJson(URL,null,null,params);
    }

}
