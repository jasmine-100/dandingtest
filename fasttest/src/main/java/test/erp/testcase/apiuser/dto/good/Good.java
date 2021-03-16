package test.erp.testcase.apiuser.dto.good;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/20 11:41
 */
@Data
public class Good {
    private String goodsCode;//货品ID
    private String sku;//SKU
    private String goodsName;
    private String model;//规格型号
    private String brandCode;//品牌编码
    private String type;//完税，DUTY_PAID；保税，BONDED
    private int length;
    private int width;
    private int height;
    private int grossWeight;
    private int netWeight;
    private String barcode;//条形码
    private int retailPrice;//零售价
    private String remark;
    private String batchManagement;//是否开启效期：YES 开启，NO 不开启
    private int shelfLife;//保质期天数
    private int noSellDate;//禁售天数
    private int noCollectDate;//禁收天数
    private int warningDate;//预警天数

    public Good(String id, String goodsName, String brandCode, String type, int retailPrice, String batchManagement) {
        this.goodsCode = id;
        this.sku = id;
        this.goodsName = goodsName;
        this.model = "100ml";
        this.brandCode = brandCode;
        this.type = type;
        this.length = 10;
        this.width = 11;
        this.height = 12;
        this.grossWeight = 6;
        this.netWeight = 5;
        this.barcode = "601"+id;
        this.retailPrice = retailPrice;
        this.remark = "我是商品";
        this.batchManagement = batchManagement;
        if(batchManagement.equals("YES")){
            this.shelfLife = 365;
            this.noSellDate = 100;
            this.noCollectDate = 200;
            this.warningDate = 50;
        }
    }
}
