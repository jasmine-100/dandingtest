package dto.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 17:21
 */
@Data
public class DetailParam {
    String skuCode;
    String skuName;
    double volume;
    int expSkuQty;
    double grossWeight;
    double netWeight;
    double price;

    public DetailParam(String skuCode, int expSkuQty) {
        this.skuCode = skuCode;
//        this.skuName = "";
//        this.volume = volume;
        this.expSkuQty = expSkuQty;
//        this.grossWeight = grossWeight;
//        this.netWeight = netWeight;
//        this.price = price;
    }
}
