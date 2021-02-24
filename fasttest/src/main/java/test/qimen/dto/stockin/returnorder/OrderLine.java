package test.qimen.dto.stockin.returnorder;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:53
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLine {
    int orderLineNo;
    String inventoryType;
    String itemCode;
    String itemId;
    String ownerCode;
    int planQty;
    String batchCode;

    public OrderLine(String itemCode,String inventoryType, int planQty,String ownerCode) {
        this.inventoryType = inventoryType;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.orderLineNo = 1;
        this.ownerCode = ownerCode;
        this.planQty = planQty;
    }

}
