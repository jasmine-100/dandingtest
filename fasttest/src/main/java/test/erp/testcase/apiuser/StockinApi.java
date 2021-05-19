package test.erp.testcase.apiuser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import test.erp.testcase.apiuser.dto.stockin.Examine;
import test.erp.testcase.apiuser.dto.stockin.SelectPage;
import utils.client.gatewayDTO.GatewayHttpClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/5/19 14:19
 */
public class StockinApi extends LoginErpUser {

    @Test
    public void orderExamine() {
        SelectPage page = new SelectPage(100, "1");
        String response = GatewayHttpClient.send(client, "/ares-web/inOrder/queryList", accessToken, page);//查询已创建状态的入库单
        JSONArray datalist = JSONObject.parseObject(response).getJSONObject("data").getJSONArray("dataList");
        if (datalist.size() > 0){
            for (int i = 0; i < datalist.size(); i++) {
                JSONObject object = datalist.getJSONObject(i);
                String inOrderNo = object.getString("inOrderNo");
                System.out.println(inOrderNo);
                GatewayHttpClient.send(client, "/ares-web/inOrder/submitAudit", accessToken, new Examine(inOrderNo));
            }
            orderExamine();
        }
    }

}
