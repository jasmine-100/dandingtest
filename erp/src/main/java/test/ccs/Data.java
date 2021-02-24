package test.ccs;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/11 16:01
 */
public class Data {
    // 数据文件路径
    public static String FILEPATH = "file/ccs.xls";

    // 电商平台编码
    public static String ebpCode = "1234650123";
    // 电商企业编码
    public static String ebcCode= "1234650123";
    // 清关企业编码，需要开发配置，不要改
    public static String agentCode = "330766K00W";

    /**
     * 京东订单的配置
     */
//    // 路由编码
//    public static String routeCode = "JDRK330798003U";
//    // 电商平台编码
//    public static String ebpCode = "31149679BZ";
//    // 电商企业编码
//    public static String ebcCode= "330766K00Q";
//    // 清关企业编码，需要开发配置，不要改
//    public static String agentCode = "330766K00Q";
//    // 申报单号
//    public static String declareOrderNo = "202009161657";
//    // 清单号
//    public static String invtNo = "QD"+declareOrderNo;
//    // 运单号
//    public static String logiticsNo = "SF"+declareOrderNo;



    // 压测域名（2020-08-12）
//    public static String TESTBASE1 = "http://ccs.backend.uat.yang800.com";
//    public static String TESTBASE2 = "http://ccs.fen.uat.yang800.com";

    // 日常测试环境域名
    public static String DOMAIN = "http://ccs.backend.daily.yang800.com";
    public static String DOMAINBACK = "http://ccs.fen.daily.yang800.com";

    // ccs下单系统域名
    public static String URL_ORDER = DOMAIN +"/xhr/order/submit";
    // ccs推送备案商品
    public static String URL_GOOD = DOMAIN +"/xhr/goodsRecord/upset";
    // ccs推送账册库存
    public static String URL_STOCK = DOMAIN +"/xhr/customsBookItem/upset";
    // OMS订单上报
    public static String URL_DECLARE = DOMAIN + "/xhr/order/syncDockerOrder";

    // 回执报文
    public static String URL_BACK = DOMAINBACK +"/zjport/callback";
    // 手动模拟回传
    public static String URL_BACKMOCK = DOMAINBACK +"/zjport/mock/manCallback";

}

