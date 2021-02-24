package qimen.domain.deliver;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/30 13:20
 */
@Data
public class OrderLine {
    int orderLineNo;
    String ownerCode;
    String itemCode;
    String itemId;
    String itemName;
    int planQty;
    String sourceOrderCode;
    int actualPrice;
    String subSourceOrderCode;
    String batchCode;

    // 推送发货单实体类
    public OrderLine(int i,String ownerCode, String itemCode, int planQty, String batchCode) {
        this.orderLineNo = i;
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.itemName = "";
        this.planQty = planQty;
        this.sourceOrderCode = "";
        this.subSourceOrderCode = "";
        this.actualPrice = 10;
        this.batchCode = batchCode;
    }
}
