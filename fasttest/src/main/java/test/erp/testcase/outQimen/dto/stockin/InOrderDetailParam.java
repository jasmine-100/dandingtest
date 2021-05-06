package test.erp.testcase.outQimen.dto.stockin;

import lombok.Data;

@Data
public class InOrderDetailParam {
    String sku;
    String goodsName;
    String billCurrency;
    double unitPrice;
    int planQuantity;
    int inventoryType;//1 正品，2 次品

    public InOrderDetailParam(String sku, double unitPrice,int inventoryType, int planQuantity) {
        this.sku = sku;
        this.goodsName = "";
        this.billCurrency = "RMB";
        this.unitPrice = unitPrice;
        this.inventoryType = inventoryType;
        this.planQuantity = planQuantity;
    }
}
