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
    int batchCode; // 批次号
    int  actualQuantity; // 入库数量
    int inventoryType;// 1 正品；2 次品
    int lineNo;
    String productDate;// 生产日期
    String expireDate;

    public SkuParam(String goodsCode, int batchCode, int actualQuantity, int inventoryType, int lineNo, String productDate, String expireDate) {
        this.goodsCode = goodsCode;
        this.batchCode = batchCode;
        this.actualQuantity = actualQuantity;
        this.inventoryType = inventoryType;
//        this.inventoryType = inventoryType;
        this.lineNo = lineNo;
        this.productDate = productDate;
        this.expireDate = expireDate;
    }
}
