package v3.domain.stockin;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:45
 */
@Data
public class Order {
     String accessCode;
     String whCode;
     String thirdNo;
     String receiverName;
     String receiverMobile;
     String receiverProvince;
     String receiverCity;
     String receiverDistrict;
     String receiverDetailAddress;
     String sourcePlatform;
     List<Sku> skuList;
     String type; //CGRKD采购单，DBRKD调拨入库单，PFTHRKD批发退货入库单，SOTHRKD销售退货入库单
     String shippingCode;

    public Order(String thirdNo, String whCode, String accessCode, String type, List<Sku> skuList) {
        this.accessCode = accessCode;
        this.whCode = whCode;
        this.thirdNo = thirdNo;
        this.type = type;
        this.shippingCode = "Y" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.receiverName = "滴滴";
        this.receiverMobile = "15966663333";
        this.receiverProvince = "浙江省";
        this.receiverCity = "杭州市";
        this.receiverDistrict = "江干区";
        this.receiverDetailAddress = "九堡街道科技园";
        this.sourcePlatform = "";
        this.skuList = skuList;
    }
}
