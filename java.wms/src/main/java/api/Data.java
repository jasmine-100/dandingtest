package api;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 17:05
 */
public class Data {
    // 测试域名
    public static String url = "http://exchange.yang800.com";

    // 添加货主
    public static String addCargoUrl = url +"/dt-wms-portal/do-icargo-owner-test";
    // 添加商品
    public static String addGoodUrl = url+"/dt-wms-portal/do-isku-receipt-biz";
    // 添加入库单
    public static String addStockinUrl = url+"/dt-wms-portal/do-iasn-receipt-biz";
    // 添加出库单
    public static String addStockoutUrl =url+"/dt-wms-portal/do-shipment-order";
    // 取消出库单
    public static String cancelOrderUrl = url+"/dt-wms-portal/do-order-intercept-test";

    public static String warehouseCode = "DT-W1";
    public static String cargoCode = "JASMINE";

}
