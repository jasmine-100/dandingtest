package domain.outbound;

import domain.stockin.Sku;
import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 18:29
 */
@Data
public class OutboundOrder {
    private String accessCode;
    private String whCode;
    private String thirdNo;
    private String type;
    private String receiverName;
    private String receiverMobile;
    private String receiverProvince;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverDetailAddress;
    private String sourcePlatform;
    private List<Sku> skuList;
    private String senderName;
    private String senderMobile;
    private String senderProvince;
    private String senderCity;
    private String senderDistrict;
    private String senderDetailAddress;

    public OutboundOrder(String type,String accessCode, String whCode, String thirdNo, List<Sku> skuList) {
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
        this.type = type;
        this.senderName = "哈哈";
        this.senderMobile = "15566669999";
        this.senderProvince = "北京";
        this.senderCity = "北京市";
        this.senderDistrict = "朝阳区";
        this.senderDetailAddress = "长安街101号";
    }

}
