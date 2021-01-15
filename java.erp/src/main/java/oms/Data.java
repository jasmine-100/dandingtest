package oms;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/12 14:08
 */
public class Data {

    public static String URL = "http://oms.explorer.daily.yang800.com";
    // OMS内部下单接口
    public static String OrderUrl = URL + "/channelOrder/submit";

    // V2下单接口
    public static String V2Url = "http://supporttest.yang800.cn/api";

    public static String accessCode = "8ce310a0407cc30b0163d11b7628942a"; // 店铺级别的密钥
    public static String partnerId = "V2"; // 应用级别的id
    public static String token = "V2"; // 应用级别的密钥

}
