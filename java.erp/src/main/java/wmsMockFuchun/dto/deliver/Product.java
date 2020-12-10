package wmsMockFuchun.dto.deliver;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/27 18:08
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {

     String OrderLineNo;
     String Sku;
     String BatchCode;
     int Qty;
     String InventoryType;
     String Memo;
     String BatchValue1;
     String BatchValue2;
     String BatchValue3;
     String BatchValue4;
     String BatchValue5;

    public Product(String sku, String batchCode, int qty, String batchValue1,String batchValue2, String inventoryType) {
        OrderLineNo = "";
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

    public Product(String sku, String batchCode, int qty) {
        OrderLineNo = "";
        Sku = sku;
        BatchCode = batchCode;
        Qty = qty;
        Memo = "你好备注";
        BatchValue1 = "";
        BatchValue2 = "";
        BatchValue3 = "";
        BatchValue4 = "";
        BatchValue5 = "";
        InventoryType = "ZP";
    }
}
