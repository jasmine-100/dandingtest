package api;

import client.ApiClient;
import dto.stockin.DetailParam;
import dto.stockin.HdrParam;
import dto.stockin.StockinOrder;
import org.testng.annotations.Test;

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
        detailParams.add(new DetailParam("JHY20201125145455",1000));
        detailParams.add(new DetailParam("JHY20201125145528",2000));
        HdrParam hdrParam = new HdrParam(soNo,Data.warehouseCode,Data.cargoCode);
        StockinOrder stockinOrder = new StockinOrder(detailParams,hdrParam);

        ApiClient.doPostJson(Data.addStockinUrl,null,null,stockinOrder);
    }
}
