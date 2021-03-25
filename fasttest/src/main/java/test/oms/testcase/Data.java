package test.oms.testcase;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/12 14:08
 */
public class Data {

    public static String URL = "http://oms.explorer.daily.yang800.com.cn";//测试环境
//    public static String URL = "http://oms.explorer.daily.yang800.com";//预发环境
    // OMS内部下单接口
    public static String OrderUrl = URL + "/channelOrder/submit";

    // V2下单接口
    public static String V2Url = "http://supporttest.yang800.cn/api";

    // 店铺级别的密钥
    public static String accessCode1 = "8ce310a0407cc30b0163d11b7628942a";// 哈哈科技的黑店
    public static String accessCode2 = "4dc46908d6606c7f8571a8c9573c09c0";// 小花花的花店
    public static String partnerId = "V2"; // 应用级别的id
    public static String token = "V2"; // 应用级别的密钥

    //  网关地址域名
    // 添加充值账单
    public static String uri_account = "/account-web/accountCharge/userChargeSave";
}
