package qimen.domain.deliver;

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

     String orderLineNo;
     String ownerCode;
     String itemCode;
     String itemId;
     String itemName;
     int planQty;
     int actualPrice;
     String batchCode;
    String sourceOrderCode;
    String subSourceOrderCode;

    // 推送发货单实体类
    public OrderLine(String ownerCode, String itemCode, int planQty, String batchCode) {
        this.orderLineNo = "";
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.itemName = "";
        this.planQty = planQty;
        this.actualPrice = 10;
        this.sourceOrderCode = "";
        this.subSourceOrderCode = "";
        this.batchCode = batchCode;
    }

}
