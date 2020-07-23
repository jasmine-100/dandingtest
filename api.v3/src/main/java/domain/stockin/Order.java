package domain.stockin;

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
    //发货单和入库单共同的属性
    private String accessCode;
    private String whCode;
    private String thirdNo;
    private String receiverName;
    private String receiverMobile;
    private String receiverProvince;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverDetailAddress;
    private String sourcePlatform;
    private List<Sku> skuList;

    //入库单属性
    private String type; //CGRKD采购单，DBRKD调拨入库单，PFTHRKD批发退货入库单，SOTHRKD销售退货入库单
    private String shippingCode;

    //发货单属性
    private String bondType;
    private String senderName;
    private String senderMobile;
    private String senderProvince;
    private String senderCity;
    private String senderDistrict;
    private String senderDetailAddress;

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

    public Order(String accessCode, String whCode, String thirdNo, List<Sku> skuList, String bondType ) {
        this.accessCode = accessCode;
        this.whCode = whCode;
        this.thirdNo = thirdNo;
        this.receiverName = "滴滴";
        this.receiverMobile = "15966663333";
        this.receiverProvince = "浙江省";
        this.receiverCity = "杭州市";
        this.receiverDistrict = "江干区";
        this.receiverDetailAddress = "九堡街道科技园";
        this.sourcePlatform = "";
        this.skuList = skuList;
        this.bondType = bondType;
        this.senderName = "哈哈";
        this.senderMobile = "15566669999";
        this.senderProvince = "北京";
        this.senderCity = "北京市";
        this.senderDistrict = "朝阳区";
        this.senderDetailAddress = "长安街101号";
    }
}
