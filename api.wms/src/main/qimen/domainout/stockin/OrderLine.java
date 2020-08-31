package domainout.stockin;

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
     int actualQty;
     double purchasePrice;
     double retailPrice;
     String inventoryType;
     String batchCode;
     String unit;

    String sourceOrderCode;
    String subSourceOrderCode;

    // 推送采购入库单实体类
    public OrderLine(String itemCode,int qty, String batchCode) {
        this.orderLineNo = "";
        this.ownerCode = "";
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.itemName = "";
        this.planQty = qty;
        this.actualQty = qty;
        this.purchasePrice = 10;
        this.retailPrice = 10;
        this.inventoryType = "ZP";
        this.batchCode = batchCode;
        this.unit = "个";
    }

    // 退货入库订单实体类
    public OrderLine(String ownerCode,String itemCode,int qty, String inventoryType,String batchCode) {
        this.orderLineNo = "";
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.planQty = qty;
        this.inventoryType = inventoryType;
        this.batchCode = batchCode;
    }

    // 推送发货单实体类
    public OrderLine(String ownerCode, String itemCode, int planQty, String batchCode) {
        this.orderLineNo = "";
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
