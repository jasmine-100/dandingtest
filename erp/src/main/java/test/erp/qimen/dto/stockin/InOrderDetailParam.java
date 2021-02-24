package test.erp.qimen.dto.stockin;

import lombok.Data;

@Data
public class InOrderDetailParam {
    String sku;
    String goodsName;
    String billCurrency;
    double unitPrice;
    int planQuantity;

    public InOrderDetailParam(String sku, String billCurrency, double unitPrice, int planQuantity) {
        this.sku = sku;
        this.goodsName = "";
        this.billCurrency = billCurrency;
        this.unitPrice = unitPrice;
        this.planQuantity = planQuantity;
    }
}
