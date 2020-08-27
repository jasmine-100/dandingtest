package domainout.deliver;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:28
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLine {
    String orderLineNo;
    String ownerCode;
    String itemCode;
    String itemId;
    String itemName;
    int planQty;
    String sourceOrderCode;
    String subSourceOrderCode;
    int actualPrice;
    String batchCode;
    String inventoryType;

    public OrderLine(String sourceOrderCode, String ownerCode, String itemCode, String itemName, int planQty, int actualPrice) {
        this.orderLineNo = "";
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.itemName = itemName;
        this.planQty = planQty;
        this.sourceOrderCode = sourceOrderCode;
        this.subSourceOrderCode = "";
        this.actualPrice = actualPrice;
        this.batchCode = "";
    }

    // 退货订单实体类
    public OrderLine(String ownerCode, String itemCode, String inventoryType, int planQty) {
        this.orderLineNo = "";
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.inventoryType = inventoryType;
        this.planQty = planQty;
        this.batchCode = "";
    }


}
