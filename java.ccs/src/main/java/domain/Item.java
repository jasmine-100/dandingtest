package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:24
 */
@Data
public class Item {
    // 商品备案料号：唯一标识商品
    private String recordNo;
    // 商品货号
    private String itemNo;
    //商品品名
    private String itemName;
    //数量
    private int count;
    // 商品链接
    private String itemLink;
    //商品备案序号
    private String recordGnum;
    // 单价
    private double unitPrice;

    public Item(String recordNo,int count, double unitPrice) {
        this.recordNo = recordNo;
        this.itemNo = "OID123000";
        this.itemName = "外部商品";
        this.count = count;
        this.itemLink = "http://www.taobao.com";
        this.unitPrice = unitPrice;
    }
}
