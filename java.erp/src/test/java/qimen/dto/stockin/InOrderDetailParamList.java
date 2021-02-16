package qimen.dto.stockin;

import lombok.Data;

@Data
public class InOrderDetailParamList {
    String sku;
    String goodsName;
    String billCurrency;
    double unitPrice;
    int planQuantity;

    public InOrderDetailParamList(String sku, String billCurrency, double unitPrice, int planQuantity) {
        this.sku = sku;
        this.goodsName = "";
        this.billCurrency = billCurrency;
        this.unitPrice = unitPrice;
        this.planQuantity = planQuantity;
    }
}
