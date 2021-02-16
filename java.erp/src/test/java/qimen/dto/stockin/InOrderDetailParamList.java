package qimen.dto.stockin;

import lombok.Data;

@Data
public class InOrderDetailParamList {
    String sku;
    String goodsName;
    String billCurrency;
    double unitPrice;
    int planQuantity;
}
