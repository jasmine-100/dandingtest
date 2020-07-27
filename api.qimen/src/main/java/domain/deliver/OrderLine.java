package domain.deliver;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:28
 */
public class OrderLine {
    String orderLineNo;
    String ownerCode;
    String itemCode;
    String itemId;
    String itemName;
    int planQty;
    String sourceOrderCode;
    String subSourceOrderCode;
    double actualPrice;
    String batchCode;

    public OrderLine(String sourceOrderCode,String ownerCode, String itemCode,  String itemName, int planQty, double actualPrice) {
        this.orderLineNo = "";
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.itemName = itemName;
        this.planQty = planQty;
        this.sourceOrderCode = sourceOrderCode;
        this.subSourceOrderCode = "8470002180581";
        this.actualPrice = actualPrice;
        this.batchCode = "";
    }
}
