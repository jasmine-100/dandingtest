package qimen;

import client.ApiClient;
import org.junit.Test;
import qimen.dto.Params;
import qimen.dto.good.Good;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodApi extends Data {

    @Test
    public void goodAdd(){
        String str = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        String goodNo = "SK" + str;
//        String goodNo = "SKM20210219183551";
        Good good = new Good(goodNo,"蓝牙耳机",goodNo,warehouseCode,ownerCode);
        Params params = new Params(goodNo,"3",good);

        ApiClient.doPostJson(URL,null,null,params);
    }

}
