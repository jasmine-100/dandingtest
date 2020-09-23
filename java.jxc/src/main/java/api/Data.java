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
        map.put("Cookie","web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6Imphc21pbmUxMCIsImF1ZCI6IioueWFuZzgwMC5jb20iLCJleHAiOjE2MDA4ODQ0NDEsIm5iZiI6MTYwMDg1MDI0MSwiaWF0IjoxNjAwODUyMDQxLCJqdGkiOiIyOGY4MDllOS05OGE2LTQ5MTctYTNjZS05ODliN2YwMTEwZjEiLCJ1c2VyIjp7InVzZXJJZCI6MTQ0LCJ1c2VyTmFtZSI6Imphc21pbmUxMCIsInN1cGVyVXNlciI6dHJ1ZSwicm9sZXMiOltdLCJzeXN0ZW0iOiJPTVNfU1VQUExZIiwibG9naW5UaW1lIjoxNjAwODUyMDQxNDA0LCJ2YWxpZFRpbWUiOjE2MDA4ODQ0NDE0MDQsInJlZnJlc2hUaW1lIjoxNjAwODYyODQxNDA0LCJleHRlbmQiOnsidXNlcklkIjoxNDQsInVzZXJOYW1lIjoiamFzbWluZTEwIiwibWFzdGVyIjp0cnVlfX19.4RYKO8G8n_d9IY1OAFPRyrARV9HKCDSq3lPRT7qCJiI");
        return map;
    }

    public static String FILEPATH = "file/purchase.xls";
}
