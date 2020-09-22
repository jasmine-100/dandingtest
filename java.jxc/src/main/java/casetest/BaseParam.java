package casetest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/25 10:13
 */
public class BaseParam {

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
        map.put("Cookie","_ga=GA1.2.1004578877.1598319387; web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6Imphc21pbmUxMCIsImF1ZCI6IioueWFuZzgwMC5jb20iLCJleHAiOjE2MDA3Njk2MzcsIm5iZiI6MTYwMDczNTQzNywiaWF0IjoxNjAwNzM3MjM3LCJqdGkiOiI5N2M3ZmFiMy1kMzI5LTQ3ZDktYTRjNS1kYTVmNDk4NDE4YzAiLCJ1c2VyIjp7InVzZXJJZCI6MTQ0LCJ1c2VyTmFtZSI6Imphc21pbmUxMCIsInN1cGVyVXNlciI6dHJ1ZSwicm9sZXMiOltdLCJzeXN0ZW0iOiJPTVNfU1VQUExZIiwibG9naW5UaW1lIjoxNjAwNzM3MjM3Mzk3LCJ2YWxpZFRpbWUiOjE2MDA3Njk2MzczOTcsInJlZnJlc2hUaW1lIjoxNjAwNzQ4MDM3Mzk3LCJleHRlbmQiOnsidXNlcklkIjoxNDQsInVzZXJOYW1lIjoiamFzbWluZTEwIiwibWFzdGVyIjp0cnVlfX19.16mLSvFS9n7EttMK_Qfp3igu1EYTnuXOw-N3nHqRuPU");
        return map;
    }

    public static String FILEPATH = "file/purchase.xls";

}
