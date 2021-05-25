package test.qimen.testcase.dto.stockin.purchase;

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
    String inventoryType;// zp正品 cp次品
    String itemCode;
    String itemId;
     int orderLineNo;
     String ownerCode;
     int planQty;
     String remark;

    public OrderLine(String ownerCode, String itemCode, String inventoryType, int planQty) {
        this.inventoryType = inventoryType;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.orderLineNo = 1;
        this.ownerCode = ownerCode;
        this.planQty = planQty;
        this.remark = "一个备注";
    }

}
