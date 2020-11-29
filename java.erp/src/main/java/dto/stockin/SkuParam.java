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
    String batchCode; // 批次号
    int  actualQuantity; // 入库数量
    int skuQuality;// 1 正品；2 次品
//    String inventoryType;// 1 正品；2 次品
    int lineNo;
    String productionDate;
    String expireDate;

    public SkuParam(String goodsCode, String batchCode, int actualQuantity, int skuQuality, int lineNo, String productionDate, String expireDate) {
        this.goodsCode = goodsCode;
        this.batchCode = batchCode;
        this.actualQuantity = actualQuantity;
        this.skuQuality = skuQuality;
//        this.inventoryType = inventoryType;
        this.lineNo = lineNo;
        this.productionDate = productionDate;
        this.expireDate = expireDate;
    }
}
