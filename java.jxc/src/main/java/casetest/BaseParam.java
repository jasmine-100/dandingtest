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
        map.put("Cookie","_ga=GA1.2.1004578877.1598319387; web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6Imphc21pbmUxMCIsImF1ZCI6IioueWFuZzgwMC5jb20iLCJleHAiOjE2MDA4MDIwNTksIm5iZiI6MTYwMDc2Nzg1OSwiaWF0IjoxNjAwNzY5NjU5LCJqdGkiOiJcImVlYzhhNTAyLWUzZWQtNDNjZi1iMTlhLTUyMDlkMDNlODQxZVwiIiwidXNlciI6eyJ1c2VySWQiOjE0NCwidXNlck5hbWUiOiJqYXNtaW5lMTAiLCJzdXBlclVzZXIiOnRydWUsInJvbGVzIjpbXSwic3lzdGVtIjoiT01TX1NVUFBMWSIsImxvZ2luVGltZSI6MTYwMDc2OTY1OTU5MiwidmFsaWRUaW1lIjoxNjAwODAyMDU5NTkyLCJyZWZyZXNoVGltZSI6MTYwMDc4MDQ1OTU5MiwiZXh0ZW5kIjp7InVzZXJJZCI6MTQ0LCJ1c2VyTmFtZSI6Imphc21pbmUxMCIsIm1hc3RlciI6dHJ1ZX19fQ.Wm5kPuBtuDroLEuwaNlk-_Ku076R8yAU_ZZkoCRPYRA");
        return map;
    }

    public static String FILEPATH = "file/purchase.xls";
    public static String FILEPATH2 = "file/purchase2.xls";

}
