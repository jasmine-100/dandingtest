package v3.domain.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:49
 */
@Data
public class Sku {
     String skuNo;
     int num;

    public Sku(String skuNo, int num) {
        this.skuNo = skuNo;
        this.num = num;
    }
}
