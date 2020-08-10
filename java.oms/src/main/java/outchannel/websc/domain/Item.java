package outchannel.websc.domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 15:57
 */
@Data
public class Item {

 String skuCode;
 String goodsName;
 String outCode;
 int num;
 double price;
 double tax;
 double discount;
 double shipFee;

public Item(String skuCode, String goodsName, String outCode, int num, double price) {
this.skuCode = skuCode;
this.goodsName = goodsName;
this.outCode = outCode;
this.num = num;
this.price = price;
this.tax = 0;
this.discount = 0;
      this.shipFee = 0;
    }
}
