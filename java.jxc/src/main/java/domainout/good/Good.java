package domainout.good;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:30
 */
@Data
public class Good {
     String proCode;
     String barcode;
     String proName;
     String type; //1 保税商品 ， 2 普通商品
     String retailPrice;
     String isbatch; //1 有批次，0 无批次
     double length; //长
     double width; //宽
     double height;//高
     double grossWeight;//毛重
     double netWeight;//净重
    String brandName;
    String brandCode;
    int expirationDate;

    public Good(String proCode, String proName,String brandCode,String brandName,String isbatch, int expirationDate, String retailPrice) {
        this.proCode = proCode;
        this.barcode = proCode;
        this.proName = proName;
        this.type = "2";//完税商品
        this.isbatch = isbatch;//0无批次；1有批次
        this.length = 100;
        this.width = 101;
        this.height = 102;
        this.grossWeight = 10;
        this.netWeight = 9;
        this.retailPrice = retailPrice;
        this.brandCode = brandCode;
        this.brandName = brandName;
        this.expirationDate = expirationDate;
    }

    public Good(String proCode, String barcode,String proName,String brandCode,String brandName,String isbatch,String type,String retailPrice) {
        this.proCode = proCode;
        this.barcode = barcode;
        this.brandName = brandName;
        this.proName = proName;
        this.type = type;//完税商品
        this.isbatch = isbatch;//0无批次；1有批次
        this.retailPrice = retailPrice;
        this.brandCode = brandCode;
        this.expirationDate = 200;
    }


}
