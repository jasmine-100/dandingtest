package erp.wmsMockDaita;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:40
 */
public class Data {

    public static String url = "https://ares-admin.yang800.com";

    public static String urlStockin = url + "/ares-admin/open/dtInStockCallback";

    public static String urlStockout = url + "/ares-admin/open/dtOutStockCallback";

    // 哈哈科技有限公司
    String warehouseCode = "DT_JYWMS1230";//  金义完税仓的wms编码
//    String ownerCode = "hahaWmsWanshui";// wms完税货主
//    String ownerCode = "jinyiHuozhu0218";// 金义货主(关闭效期)
    String ownerCode = "jinyiQimen";// 金义奇门货主

//    String warehouseCode = "DT_HNWMS";//  海南保税仓的wms编码
//    String ownerCode = "hainanHuozhu0222";// 海南奇门货主
}
