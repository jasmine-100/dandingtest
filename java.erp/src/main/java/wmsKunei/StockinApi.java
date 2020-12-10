package wmsKunei;

import client.ApiClient;
import org.testng.annotations.Test;
import wmsKunei.dto.stockin.DetailParam;
import wmsKunei.dto.stockin.HdrParam;
import wmsKunei.dto.stockin.StockinOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 17:20
 */
public class StockinApi {

    @Test
    public void addStockinOrder(){
        String soNo = "JIN"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<DetailParam> detailParams = new ArrayList<>();
        detailParams.add(new DetailParam("JHY20201127093940700",100,1));
//        detailParams.add(new DetailParam("JHY20201127094007723",2000,2));
//        detailParams.add(new DetailParam("JHY20201127094008291",3000,3));
        HdrParam hdrParam = new HdrParam(soNo,Data.warehouseCode,Data.cargoCode);
        StockinOrder stockinOrder = new StockinOrder(detailParams,hdrParam);

        ApiClient.doPostJson(Data.addStockinUrl,null,null,stockinOrder);
    }

}
