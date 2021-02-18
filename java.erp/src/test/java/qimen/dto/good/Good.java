package qimen.dto.good;

import lombok.Data;

@Data
public class Good {
    String sku;
    String goodsName;
    String barcode;
    int batchManagement;// 1开启效期；2关闭效期；奇门都是关闭效期的
    int grossWeight;
    int netWeight;
    int height;
    int length;
    int width;
    int shelfLife;
    String logicWarehouseCode;
    String ownerCode;
    String origSystem;

    public Good(String sku, String goodsName, String barcode, String warehouseCode, String ownerCode) {
        this.sku = sku;
        this.goodsName = goodsName;
        this.barcode = barcode;
        this.batchManagement = 2;
        this.grossWeight = 10;
        this.netWeight = 9;
        this.height = 17;
        this.length = 18;
        this.width = 19;
        this.shelfLife = 200;
        this.logicWarehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.origSystem = "QM";
    }
}
