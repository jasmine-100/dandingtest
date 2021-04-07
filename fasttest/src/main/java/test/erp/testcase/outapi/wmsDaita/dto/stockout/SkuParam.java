package test.erp.testcase.outapi.wmsDaita.dto.stockout;

import lombok.Data;
import utils.util.UtilsTime;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 18:00
 */
@Data
public class SkuParam {
    String sku;
    String batchCode; // 批次号
    int  actualQuantity; // 入库数量
    int inventoryType;// 1 正品；2 次品
    int lineNo;
    String productionDate;// 生产日期
    String expireDate; // 失效日期

    public SkuParam(String sku, String batchCode, int actualQuantity, int inventoryType, int lineNo, String productionDate, String expireDate) {
        this.sku = sku;
        this.batchCode = batchCode;
        this.actualQuantity = actualQuantity;
        this.inventoryType = inventoryType;
        this.lineNo = lineNo;
        this.productionDate = productionDate;
        this.expireDate = expireDate;
    }

    public SkuParam(String goodsCode, String batchCode, int actualQuantity, int inventoryType, int lineNo, String productionDate, int days) {
        this.sku = goodsCode;
        this.batchCode = batchCode;
        this.actualQuantity = actualQuantity;
        this.inventoryType = inventoryType;
        this.lineNo = lineNo;
        this.productionDate = productionDate;
        this.expireDate = UtilsTime.addDate(productionDate,days);
    }

}
