package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:24
 */
@Data
public class Item {
     String recordNo; //商品备案料号：唯一标识商品
     String itemNo;// 商品的仓库sku编码
     String itemName;//商品品名
     int count;//数量
     String itemLink;// 商品链接
     String recordGnum;//商品备案序号
     double unitPrice;// 单价

    public Item(String recordNo,String itemNo,int count, double unitPrice) {
        this.recordNo = recordNo;
        this.itemNo = itemNo;
        this.itemName = "外部商品";
        this.count = count;
        this.itemLink = "http://www.taobao.com";
        this.unitPrice = unitPrice;
    }
}
