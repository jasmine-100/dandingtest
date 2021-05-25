package test.erp.testcase.outQimen.dto.good;

import lombok.Data;

@Data
public class Good {
    String sku;
    String materialCode;//物料编码
    String goodsName;
    String barcode;
    int batchManagement;// 1开启效期；2关闭效期；奇门都是关闭效期的
    int grossWeight;
    int netWeight;
    int height;
    int length;
    int width;
    int shelfLife;//保质期天数
    int noSellDate;//禁售天数
    int noCollectDate;//禁收天数
    int warningDate;//预警天数
    String logicWarehouseCode;
    String ownerCode;
    String origSystem;

    public Good(String sku,String goodsName,String materialCode,String barcode,int batchManagement,String warehouseCode, String ownerCode) {
        this.sku = sku;
        this.materialCode = materialCode;
        this.goodsName = goodsName;
        this.barcode = barcode;
        this.batchManagement = batchManagement;
        if(batchManagement == 1){
            this.noSellDate = 100;
            this.noCollectDate = 200;
            this.warningDate = 150;
        }
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
