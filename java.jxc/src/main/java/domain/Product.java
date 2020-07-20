package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:32
 */
@Data
public class Product {
    private String OrderLineNo;
    private String Sku;
    private String BatchCode;
    private String Qty;
    private String Memo;
    private String InventoryType;

    public Product(String sku, String batchCode, String qty, String inventoryType) {
        Sku = sku;
        BatchCode = batchCode;
        Qty = qty;
        Memo = "hi";
        InventoryType = inventoryType;
    }
}
