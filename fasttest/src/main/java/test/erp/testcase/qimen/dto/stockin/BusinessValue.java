package test.erp.testcase.qimen.dto.stockin;

import lombok.Data;

@Data
public class BusinessValue {
    String orderType;
    String outShopId;
    String warehouseCode;

    public BusinessValue(String orderType, String outShopId, String warehouseCode) {
        this.orderType = orderType;
        this.outShopId = outShopId;
        this.warehouseCode = warehouseCode;
    }
}
