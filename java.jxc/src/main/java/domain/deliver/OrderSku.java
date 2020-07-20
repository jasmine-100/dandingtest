package domain.deliver;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 14:40
 */
@Data
public class OrderSku {
    private String skuCode;
    private int skuCount;

    public OrderSku(String skuCode, int skuCount) {
        this.skuCode = skuCode;
        this.skuCount = skuCount;
    }
}
