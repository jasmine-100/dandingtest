package test.erp.testcase.qimen.dto.stockout;

import lombok.Data;

@Data
public class OutOrderDetailFrom {
    String sku;
    String goodsName;
    String batchCode;
    int inventoryType;//1正品
    int planQuantity;
    double retailPrice;
    double actualRetailPrice;

    public OutOrderDetailFrom(String sku,  String batchCode, int inventoryType, int planQuantity, double price) {
        this.sku = sku;
        this.goodsName = "";
        this.batchCode = batchCode;
        this.inventoryType = inventoryType;
        this.planQuantity = planQuantity;
        this.retailPrice = price;
        this.actualRetailPrice = price;
    }
}
