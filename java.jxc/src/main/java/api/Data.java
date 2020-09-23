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
        map.put("Cookie","_ga=GA1.2.1004578877.1598319387; test_app_token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6ImFkbWluIiwiYXVkIjoiKi55YW5nODAwLmNvbSIsImV4cCI6MTYwMDg3MTkyNSwibmJmIjoxNjAwODM3NzI1LCJpYXQiOjE2MDA4Mzk1MjUsImp0aSI6ImNjNWZjYTc1LTBlNzctNGIxMS05ZThhLTdjMTExZDRkZDI1NiIsInVzZXIiOnsidXNlcklkIjoxLCJ1c2VyTmFtZSI6ImFkbWluIiwic3VwZXJVc2VyIjp0cnVlLCJyb2xlcyI6WzQwLDQyXSwic3lzdGVtIjoiT01TX1NFUlZFUiIsImxvZ2luVGltZSI6MTYwMDgzOTUyNTA4MiwidmFsaWRUaW1lIjoxNjAwODcxOTI1MDgyLCJyZWZyZXNoVGltZSI6MTYwMDg1MDMyNTA4MiwiZXh0ZW5kIjoiIn19._a…CI6IioueWFuZzgwMC5jb20iLCJleHAiOjE2MDA4Nzg1NjksIm5iZiI6MTYwMDg0NDM2OSwiaWF0IjoxNjAwODQ2MTY5LCJqdGkiOiJjNmIzZWU4ZS00ZDdiLTQzMTItOWJhMS04NWRhN2M5Y2Y5NTkiLCJ1c2VyIjp7InVzZXJJZCI6MTQ0LCJ1c2VyTmFtZSI6Imphc21pbmUxMCIsInN1cGVyVXNlciI6dHJ1ZSwicm9sZXMiOltdLCJzeXN0ZW0iOiJPTVNfU1VQUExZIiwibG9naW5UaW1lIjoxNjAwODQ2MTY5OTczLCJ2YWxpZFRpbWUiOjE2MDA4Nzg1Njk5NzMsInJlZnJlc2hUaW1lIjoxNjAwODU2OTY5OTczLCJleHRlbmQiOnsidXNlcklkIjoxNDQsInVzZXJOYW1lIjoiamFzbWluZTEwIiwibWFzdGVyIjp0cnVlfX19.QHDK8gJHN-36GJve50qHoT5znP3e6K2cvd6BuN82lLo");
        return map;
    }

    public static String FILEPATH = "file/purchase.xls";
}
