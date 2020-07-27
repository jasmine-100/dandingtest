package domain;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:49
 */
public class OrderType {

    //发货单
    public static final String DELIVER = "deliveryorder.create";

    //出库单
    public static final String OUTBOUND = "stockout.create";

    //采购入库单
    public static final String STOCKIN = "entryorder.create";


}
