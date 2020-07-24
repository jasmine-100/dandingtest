package domain.outbound;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 9:07
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private String ItemId;
    private String Sku;
    private String BatchCode;
    private int Qty;
    private String Memo;
    private String InventoryType;
    private String BatchValue1;
    private String BatchValue2;
    private String BatchValue3;
    private String BatchValue4;
    private String BatchValue5;


    public Product(String sku, String batchCode, int qty, String batchValue1, String batchValue2, String inventoryType) {
        ItemId = "";
        Sku = sku;
        BatchCode = batchCode;
        Qty = qty;
        Memo = "你好备注";
        BatchValue1 = batchValue1;
        BatchValue2 = batchValue2;
        BatchValue3 = "";
        BatchValue4 = "";
        BatchValue5 = "";
        InventoryType = inventoryType;
    }

}
