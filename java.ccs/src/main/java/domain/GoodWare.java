package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/24 14:59
 */
@Data
public class GoodWare {
    String warehouseSn;  // 仓库编码
    String shipperSn;  // 货主编码
    String skuSn;  // 商品sku编码
    String skuName;  // 商品名称

    public GoodWare(String warehouseSn, String shipperSn, String skuSn, String skuName) {
        this.warehouseSn = warehouseSn;
        this.shipperSn = shipperSn;
        this.skuSn = skuSn;
        this.skuName = skuName;
    }
}
