package test.wmsDaita.dto.stockin;

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
    int extNo;
    double volume;
    int expSkuQty;
    double grossWeight;
    double netWeight;
    double price;

    public DetailParam(String skuCode, int expSkuQty,int extNo) {
        this.extNo = extNo;
        this.skuCode = skuCode;
//        this.skuName = "";
//        this.volume = volume;
        this.expSkuQty = expSkuQty;
//        this.grossWeight = grossWeight;
//        this.netWeight = netWeight;
//        this.price = price;
    }
}
