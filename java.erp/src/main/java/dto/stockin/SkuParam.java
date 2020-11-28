package dto.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 18:00
 */
@Data
public class SkuParam {
    String goodsCode;
    String batchCode;
    int  actualQuantity;
    int skuQuality;
    String inventoryType;// 1 正品
    int lineNo;
    String productionDate;
    String expireDate;

    public SkuParam(String goodsCode, String batchCode, int actualQuantity, int skuQuality, String inventoryType, int lineNo, String productionDate, String expireDate) {
        this.goodsCode = goodsCode;
        this.batchCode = batchCode;
        this.actualQuantity = actualQuantity;
        this.skuQuality = skuQuality;
        this.inventoryType = inventoryType;
        this.lineNo = lineNo;
        this.productionDate = productionDate;
        this.expireDate = expireDate;
    }
}
