package domainout.stockin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:53
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLine {

     String orderLineNo;
     String ownerCode;
     String itemCode;
     String itemId;
     String itemName;
     int planQty;
     int actualQty;
     double purchasePrice;
     double retailPrice;
     String inventoryType;
     String batchCode;
     String unit;

    public OrderLine(String ownerCode, String itemCode,int qty, String inventoryType) {
        this.orderLineNo = "";
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.itemName = "";
        this.planQty = qty;
        this.actualQty = qty;
        this.purchasePrice = 10;
        this.retailPrice = 10;
        this.inventoryType = inventoryType;
        this.batchCode = "";
        this.unit = "个";
    }

    public OrderLine(String ownerCode, String itemCode,int qty, String inventoryType,String batchCode) {
        this.orderLineNo = "";
        this.ownerCode = ownerCode;
        this.itemCode = itemCode;
        this.itemId = itemCode;
        this.inventoryType = inventoryType;
        this.planQty = qty;
        this.batchCode = batchCode;
    }
}
