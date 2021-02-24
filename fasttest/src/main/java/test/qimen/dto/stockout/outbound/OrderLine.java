package test.qimen.dto.stockout.outbound;

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
    int actualQty;
    int purchasePrice;
    int retailPrice;
    String inventoryType; //ZP正品；CP次品
    String batchCode;
    String unit;

    // 推送出库单实体类
    public OrderLine(int orderLineNo, String ownerCode, String itemCode, String itemName, int planQty, String inventoryType, String batchCode, String unit) {
        this.orderLineNo = orderLineNo;
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.itemName = itemName;
        this.planQty = planQty;
        this.actualQty = 0;
        this.purchasePrice = 0;
        this.retailPrice = 0;
        this.inventoryType = inventoryType;
        this.batchCode = batchCode;
        this.unit = unit;
    }

}
