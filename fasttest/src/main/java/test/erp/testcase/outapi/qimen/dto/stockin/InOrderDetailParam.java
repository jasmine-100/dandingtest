package test.erp.testcase.outapi.qimen.dto.stockin;

import lombok.Data;

@Data
public class InOrderDetailParam {
    String sku;
    String goodsName;
    String billCurrency;
    double unitPrice;
    int planQuantity;

    public InOrderDetailParam(String sku, double unitPrice, int planQuantity) {
        this.sku = sku;
        this.goodsName = "";
        this.billCurrency = "RMB";
        this.unitPrice = unitPrice;
        this.planQuantity = planQuantity;
    }
}
