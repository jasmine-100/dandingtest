package oms.dto;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/12 14:24
 */
@Data
public class Item {
    String batchCode;
    String itemCode;
    String itemName;
    double unitPrice;
    int count;

    public Item(String itemCode,String batchCode,double unitPrice, int count) {
        this.batchCode = batchCode;
        this.itemCode = itemCode;
//        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.count = count;
    }
}
