package domain.stockin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 16:44
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private String OrderLineNo;
    private String Sku;
    private String BatchCode;
    private int Qty;
    private String Memo;
    private String InventoryType;

    public Product(String sku, String batchCode, int qty,String inventoryType) {
        OrderLineNo = "";
        Sku = sku;
        BatchCode = batchCode;
        Qty = qty;
        Memo = "note";
        InventoryType = inventoryType;
    }
}
