package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/12 15:05
 */
@Data
public class Stock {
    double avgPrice; //平均美元单价
    int currCode;  //币值
    String customsBookId;  //账册的数据库id
    int declarePrice;  //申报单价
    int enable;
    String firstUnit;
    String goodsModel;
    String goodsName;
    String goodsSeqNo;
    String goodsUnit;
    String hsCode;
    long inDate;
    int inLegalQty;
    int inQty;
    String invtGoodsNo;
    String  invtNo;
    String  originCountry;
    String  productId;
    String  remark;
    String  secondUnit;
    int totalAmt;

    public Stock(String goodsSeqNo, String productId, String customsBookId) {
        this.avgPrice = 10;
        this.currCode = 142;
        this.customsBookId = customsBookId;
        this.declarePrice = 10;
        this.enable = 1;
        this.firstUnit = "011";
        this.goodsModel = "规格";
        this.goodsName = "测试商品";
        this.goodsSeqNo = goodsSeqNo;
        this.goodsUnit = "001";
        this.hsCode = "3304200092";
        this.inDate = System.currentTimeMillis();
        this.inLegalQty = 1000;
        this.inQty = 1000;
        this.invtGoodsNo = "";
        this.invtNo = "";
        this.originCountry = "142";
        this.productId = productId;
        this.remark = "";
        this.secondUnit = "";
        this.totalAmt = 1000;
    }
}
