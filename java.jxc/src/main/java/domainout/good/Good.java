package domainout.good;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:30
 */
@Data
public class Good {
    private String proCode;
    private String barcode;
    private String proName;
    private Integer type; //1 保税商品 ， 2 普通商品
    private String brand;
    private String retailPrice;
    private String isbatch; //1 有批次，0 无批次
    private String expirationDate; //有效期

    private int status;
    private double length; //长
    private double width; //宽
    private double height;//高
    private double grossWeight;//毛重
    private double netWeight;//净重
    private String size;//尺寸
    private String color;//颜色
    private String specification;//规格
    private String logisticsVolume;//物流体积
    private String basis;//成分

    private String factoryName; //工厂名称
    private String factoryAdd; //工厂地址
    private String registrationNum; //注册号
    private String originCountry; //原产国
    private String currency; //币种

    public Good(String proCode, String proName, String isbatch, String expirationDate, String retailPrice, String brand) {
        this.proCode = proCode;
        this.barcode = proCode;
        this.proName = proName;
        this.type = 2;
        this.isbatch = isbatch;
        this.expirationDate = expirationDate;
        this.retailPrice = retailPrice;
        this.brand = brand;
        this.status = 2;
        this.length = 100;
        this.width = 101;
        this.height = 102;
        this.grossWeight = 10;
        this.netWeight = 9;
        this.size = "88";
        this.color = "红色";
        this.specification = "100ml/瓶";
        this.logisticsVolume = "20";
        this.basis = "以杀菌的甜性奶油制成，分为加盐和不加盐的，具有特有的乳香味，含乳脂肪80%~85%";
        this.factoryName = "jasmine的工厂";
        this.factoryAdd = "浙江省杭州市江干区东方电子商务园";
        this.registrationNum = "pu22018665512";
        this.originCountry = "中国";
        this.currency = "人民币";
    }
}
