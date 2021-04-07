package test.erp.testcase.outapi.wmsCainiao;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;
import test.erp.testcase.outapi.wmsCainiao.dto.RequestData;
import test.erp.testcase.outapi.wmsCainiao.dto.Sku;
import test.erp.testcase.outapi.wmsCainiao.dto.StockinDto;
import utils.client.apiclientDTO.ApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/7 17:39
 */
public class WmsStockinApi {

    @Test
    public void backStockin(){

        List<Sku> skuList = new ArrayList<>();
        skuList.add(new Sku("sku123",1));
        StockinDto stockinDto = new StockinDto("",true,skuList);

        RequestData requestData = new RequestData(JSON.toJSONString(stockinDto),"GLOBAL_STOCK_IN_ORDER_CONFIRM");

        ApiClient.doPostForm("https://ares-admin.yang800.com.cn/test/notify",requestData,null,null);

    }

}
