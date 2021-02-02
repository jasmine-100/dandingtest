package oms.v2.orderV2;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/15 10:10
 */
@Data
public class Item {
    String skuCode;
    String outCode;
    String goodsName;
    double price;
    int num;
    double discount;
    double shipFee;
    double tax;

    public Item(String skuCode, String goodsName, double price, int num, double discount, double shipFee, double tax) {
        this.skuCode = skuCode;
        this.outCode = "";
        this.goodsName = goodsName;
        this.price = price;
        this.num = num;
        this.discount = discount;
        this.shipFee = shipFee;
        this.tax = tax;
    }
}
