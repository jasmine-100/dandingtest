package test.wmsDaita;

import org.testng.annotations.Test;
import test.wmsDaita.dto.stockin.DetailParam;
import test.wmsDaita.dto.stockin.HdrParam;
import test.wmsDaita.dto.stockin.StockinOrder;
import utils.client.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 17:20
 */
public class StockinApi extends Data {

    @Test
    public void addStockinOrder(){
        String soNo = "JIN"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<DetailParam> detailParams = new ArrayList<>();
        detailParams.add(new DetailParam("JHY20201127093940700",100,1));
        HdrParam hdrParam = new HdrParam(soNo,warehouseCode,cargoCode);
        StockinOrder stockinOrder = new StockinOrder(detailParams,hdrParam);

        ApiClient.doPostJson(addStockinUrl,null,null,stockinOrder);
    }

}
