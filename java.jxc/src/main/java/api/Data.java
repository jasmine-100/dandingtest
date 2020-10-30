package api;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/25 10:13
 */
public class Data {

    // 测试环境域名
    public static String BASE_URL = "http://logistics-api-fat.yang800.com";
    // 压测环境域名
//    public static String BASE_URL = "";
    // 开发环境域名
//    public static String BASE_URL = "http://dev.front-api.yang800.cn:9001";

    // 添加商品
    public static String GOOD_ADD = BASE_URL+"/xhr/pro/upsert";
    // 采购单-创建
    public static String PURCHASE_ADD = BASE_URL+"/xhr/purchase/upsert";
    // 采购单-审核
    public static String PURCHASE_EXAMINE = BASE_URL+"/xhr/purchase/examineOrder";
    // 采购入库单-创建
    public static String STOCKIN_ADD = BASE_URL+"/xhr/stockin/upsert";

    // B发货单-创建
    public static String OUTBOUND_ADD = BASE_URL +"/xhr/toBOrder/createToBOrder";

    public static Map<String,Object> getCookie(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("Cookie","_ga=GA1.2.1004578877.1598319387; web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6Imphc21pbmUiLCJhdWQiOiIqLnlhbmc4MDAuY29tIiwiZXhwIjoxNjAzMTkzMjE1LCJuYmYiOjE2MDMxNTkwMTUsImlhdCI6MTYwMzE2MDgxNSwianRpIjoiYTk2NDUwNGEtYmM4OC00Yzk5LWIzNGItNDYxOGY1NTBiYWZkIiwidXNlciI6eyJ1c2VySWQiOjMsInVzZXJOYW1lIjoiamFzbWluZSIsInN1cGVyVXNlciI6dHJ1ZSwicm9sZXMiOltdLCJzeXN0ZW0iOiJPTVNfU1VQUExZIiwibG9naW5UaW1lIjoxNjAzMTYwODE1NzEyLCJ2YWxpZFRpbWUiOjE2MDMxOTMyMTU3MTIsInJlZnJlc2hUaW1lIjoxNjAzMTcxNjE1NzEyLCJleHRlbmQiOnsidXNlcklkIjozLCJ1c2VyTmFtZSI6Imphc21pbmUiLCJtYXN0ZXIiOnRydWV9fX0.WjEJAaeT2ClJbLWtx3eEs8AHrDOlXQ0L4lI7G-qvepU");
        return map;
    }

    public static String FILEPATH = "file/purchase.xls";
}
