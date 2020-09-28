package v3.domain.good;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:22
 */
@Data
public class Sku {
     String skuNo;
     String skuName;
     String barCode;
     String unit;
     String actionType;

    public Sku(String skuNo, String skuName, String barCode) {
        this.skuNo = skuNo;
        this.skuName = skuName;
        this.barCode = barCode;
        this.unit = "箱";
        this.actionType = "ADD";
    }
}
