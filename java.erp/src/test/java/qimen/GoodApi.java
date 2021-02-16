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
        String no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Good good = new Good("SKM02161757","薯片","0216175733",warehouseCode,ownerCode);
        Params params = new Params(no,"3",good);

        ApiClient.doPostJson(URL,null,null,params);
    }

}
