package domain.good;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:22
 */
@Data
public class Sku {
    private String skuNo;
    private String skuName;
    private String barCode;
    private String unit;
    private String actionType;

    public Sku(String skuNo, String skuName, String barCode) {
        this.skuNo = skuNo;
        this.skuName = skuName;
        this.barCode = barCode;
        this.unit = "箱";
        this.actionType = "ADD";
    }
}
