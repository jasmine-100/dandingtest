package test.ccs.util.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import test.ccs.Data;
import utils.client.ApiClient;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 根据申报单号查询数据库id
 * @Date : Created in 2020/8/10 14:14
 */
public class Order {

    // 获取申报单的数据库ID
    public static String getOrderNo(String declareOrderNo) throws IOException {
        String url = Data.DOMAIN + "/xhr/order/paging?currentPage=1&pageSize=20&queryType=declareOrderNo&queryInfo=" + declareOrderNo;
        String str = ApiClient.doGetUrl(url);

        // 获取result字符
        JSONObject result = (JSONObject) JSON.parseObject(str).get("result");
        // 获取datalist集合的第一个值
        JSONArray jsonArray = result.getJSONArray("dataList");
        JSONObject data = jsonArray.getJSONObject(0);
        // 获取清关字符
        JSONObject customsInventory = data.getJSONObject("customsInventory");
        // 获取id的值
        String id = customsInventory.get("id").toString();

        return id;
    }

    @Test
    public void test() throws IOException {
        System.out.println(Order.getOrderNo("JIS0810140826"));
    }
}
