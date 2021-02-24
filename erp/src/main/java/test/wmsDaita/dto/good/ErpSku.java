package test.wmsDaita.dto.good;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 15:54
 */
@Data
public class ErpSku {
    String warehouseCode;
    String cargoCode;
    String code;//料号
    String name;
    String type;//类型：1保税，2完税
    String brandCode;
    String brandName;
    String isLifeMgt;
    String lifeCycle;
    String withdrawCycle;
    String warnCycle;
    int height;

    public ErpSku(String warehouseCode, String cargoCode, String code, String name, String type, String brandCode, String brandName, String isLifeMgt, String lifeCycle, String withdrawCycle, String warnCycle) {
        this.warehouseCode = warehouseCode;
        this.cargoCode = cargoCode;
        this.code = code;
        this.name = name;
        this.type = type;
        this.brandCode = brandCode;
        this.brandName = brandName;
        this.isLifeMgt = isLifeMgt;
        this.lifeCycle = lifeCycle;
        this.withdrawCycle = withdrawCycle;
        this.warnCycle = warnCycle;
        this.height = 1;
    }
}
