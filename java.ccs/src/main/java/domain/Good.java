package domain;

import lombok.Data;

import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/12 14:24
 */
@Data
public class Good {
    String skuId;  //sku编码
    String productId;   // 料号
    String goodsRecordName;  //商品名称
    int barCode; // 条码
    String brand;  //品牌
    String brandEn; //品牌（英语）
    String composition;  //成分
    String customsBookId;  //账册的数据库id
    double declarePrice;  //备案价格
    String declareUnit;  //申报单位
    int enable;  //
    String firstUnit;  //第一计量单位
    int firstUnitAmount;  //第一计量数量
    double grossWeight;  //毛重
    double netWeight;  //净重
    String hgsbys;  //申报要素
    String hsCode;  //hs编码
    String model;  //规格
    double length;  //长
    double width;  //宽
    double height;   //高
    int opinion;   //审核状态：1审核通过；0：驳回
    String originCountry;   //原产国
    String reason;
    long recordFinishTime;
    String recordFunction;  //功能
    int recordStatus;
    String recordUsage;
    String secondUnit;  //第二计量单位
    String secondUnitAmount;   //第二计量数量
    int taxRate;
    int vatRate;

    public Good(String skuId, String productId, String customsBookId) {
        this.skuId = skuId;
        this.productId = productId;
        this.goodsRecordName = "压测商品";
        this.barCode = new Random().nextInt(99999999);
        this.brand = "巴拉巴拉";
        this.brandEn = "balabala";
        this.composition = "成分";
        this.customsBookId = customsBookId;
        this.declarePrice = 10;
        this.declareUnit = "001";
        this.enable = 1;
        this.firstUnit = "011";
        this.firstUnitAmount = 1;
        this.grossWeight = 10;
        this.netWeight = 9;
        this.hgsbys = "申报要素";
        this.hsCode = "3406000090";
        this.model = "规格";
        this.length = 7;
        this.width = 8;
        this.height = 9;
//        this.opinion = 1;  // 没有起作用
        this.originCountry = "142";
        this.reason = "原因";
        this.recordFinishTime = System.currentTimeMillis();
        this.recordFunction = "食用";
        this.recordStatus = 0;
        this.recordUsage = "暂无";
        this.secondUnit = "";
        this.secondUnitAmount = "";
        this.taxRate = 0;
        this.vatRate = 0;
    }
}
