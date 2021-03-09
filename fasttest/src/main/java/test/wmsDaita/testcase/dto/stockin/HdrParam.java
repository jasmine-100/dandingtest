package test.wmsDaita.testcase.dto.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 17:23
 */
@Data
public class HdrParam {
    String soNo;
    String warehouseCode;
    String cargoCode;
    String type;
    double volume;
    double netWeight;
    double grossWeight;
    int expSkuQty;

    public HdrParam(String soNo, String warehouseCode, String cargoCode) {
        this.soNo = soNo;
        this.warehouseCode = warehouseCode;
        this.cargoCode = cargoCode;
        this.type = "PURCHASE";
//        this.volume = volume;
//        this.netWeight = netWeight;
//        this.grossWeight = grossWeight;
//        this.expSkuQty = expSkuQty;
    }
}
