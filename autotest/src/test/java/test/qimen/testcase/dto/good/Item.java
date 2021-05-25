package test.qimen.testcase.dto.good;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 17:56
 */
@Data
public class Item {
    String itemCode;//商品编码
    String itemName;
    String goodsCode;//货号，即 物料编码
    String barCode;
    String stockUnit;
    int length;
    int width;
    int height;
    int volume;
    int grossWeight;
    int netWeight;
    String isAreaSale;
    String categoryId;
    String categoryName;
    String itemType;
    int tagPrice;
    int retailPrice;
    String isShelfLifeMgmt;
    int shelfLife;
    String isBatchMgmt;
    String createTime;
    String isValid;

    public Item(String itemCode, String itemName,String goodsCode, String barCode) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.goodsCode = goodsCode;
        this.barCode = barCode;
        this.stockUnit = "双";
        this.length = 1;
        this.width = 2;
        this.height = 3;
        this.volume = 4;
        this.grossWeight = 5;
        this.netWeight = 4;
        this.isAreaSale = "N";
        this.categoryId = "1";
        this.categoryName = "测试";
        this.itemType = "ZC";
        this.tagPrice = 0;
        this.retailPrice = 0;
        this.isShelfLifeMgmt = "N";
        this.shelfLife = 0;
        this.isBatchMgmt = "N";
        this.createTime = "2021-02-03 10:12:13";
        this.isValid = "Y";
    }
}
