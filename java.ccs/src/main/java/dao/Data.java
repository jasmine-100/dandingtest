package dao;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/11 16:01
 */
public class Data {
    // 压测域名（2020-08-12）
//    public static String BASEURL = "http://ccs.backend.uat.yang800.com";
//    public static String BASEURL2 = "http://ccs.fen.uat.yang800.com";

    // 日常测试环境域名
    public static String BASEURL = "http://ccs.backend.daily.yang800.com";
    public static String BASEURL2 = "http://ccs.fen.daily.yang800.com";

    // ccs下单系统域名
    public static String URL = BASEURL+"/xhr/order/submit";
    // ccs推送备案商品
    public static String URL4 = BASEURL+"/xhr/goodsRecord/upset";
    // ccs推送账册库存
    public static String URL5 = BASEURL+"/xhr/customsBookItem/upset";


    // 回执报文
    public static String URL2 = BASEURL2+"/zjport/callback";
    // 回传核放核注信息
    public static String URL3 = BASEURL2+"/zjport/mock/manCallback";

}
