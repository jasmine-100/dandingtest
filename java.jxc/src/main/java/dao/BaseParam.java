package dao;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/25 10:13
 */
public class BaseParam {

    // 测试环境域名
    public static String BASE_URL = "http://logistics-api-fat.yang800.com";
    public static String BACK_URL = "http://logistics-api-fat.yang800.com";

    // 开发环境域名
//    public static String BASE_URL = "http://dev.front-api.yang800.cn:9001";
//    public static String BACK_URL = "http://dev.front-api.yang800.cn:8000";

    // 添加商品
    public static String GOOD_ADD = BASE_URL+"/xhr/pro/upsert";
    // 采购单-添加
    public static String PURCHASE_ADD = BASE_URL+"/xhr/purchase/upsert";
    // 采购单-审核
    public static String PURCHASE_EXAMINE = BASE_URL+"/xhr/purchase/examineOrder";
    // 采购入库单-添加
    public static String STOCKIN_ADD = BASE_URL+"/xhr/stockin/upsert";

    // 回执出入库单
    public static String WMS_BACK = BACK_URL+"/dt/notify";




}
