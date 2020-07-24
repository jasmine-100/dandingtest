package domain.stockin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:53
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLine {

    private String orderLineNo;
    private String ownerCode;
    private String itemCode;
    private String itemId;
    private String itemName;
    private int planQty;
    private int actualQty;
    private double purchasePrice;
    private double retailPrice;
    private String inventoryType;
    private String batchCode;
    private String unit;

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
}
