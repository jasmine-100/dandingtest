package domain.deliverback;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 17:38
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private String OrderLineNo;
    private String Sku;
    private String BatchCode;
    private int Qty;
    private String Memo;
    private String BatchValue1;
    private String BatchValue2;
    private String BatchValue3;
    private String BatchValue4;
    private String BatchValue5;
    private String InventoryType;

    public Product(String sku, String batchCode, int qty, String inventoryType) {
        OrderLineNo = "";
        Sku = sku;
        BatchCode = batchCode;
        Qty = qty;
        Memo = "你好备注";
        BatchValue1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        InventoryType = inventoryType;
    }
}
