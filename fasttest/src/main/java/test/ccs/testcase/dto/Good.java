package test.ccs.testcase.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    String barCode; // 条码
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

    public Good(String skuId,String goodsName, String productId, String customsBookId) {
        this.skuId = skuId;
        this.productId = productId;
        this.goodsRecordName =goodsName;
        this.barCode = new SimpleDateFormat("yyyyMMddHHmmSSS").format(new Date());
        this.brand = "巴拉巴拉";
        this.brandEn = "balabala";
        this.composition = "纯棉";
        this.customsBookId = customsBookId;
        this.declarePrice = 10;
        this.declareUnit = "001";
        this.enable = 1;
        this.firstUnit = "011";
        this.firstUnitAmount = 1;
        this.grossWeight = 6;
        this.netWeight = 5.5;
        this.hgsbys = " 0:品牌类型;1:出口享惠情况;2:用途;3:材质;4:品牌;5:规格和型号;6:GTIN;7:CAS;";
        this.hsCode = "3406000090";
        this.model = "100g/件";
        this.length = 7;
        this.width = 8;
        this.height = 9;
//        this.opinion = 1;  // 没有起作用
        this.originCountry = "142";
        this.recordFinishTime = System.currentTimeMillis();
        this.recordFunction = "食用";
        this.recordStatus = 0;
        this.recordUsage = "暂无";
        this.secondUnit = "012";
        this.secondUnitAmount = "1";
    }
}
