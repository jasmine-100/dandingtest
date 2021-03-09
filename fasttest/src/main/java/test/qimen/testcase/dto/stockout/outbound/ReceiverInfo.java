package test.qimen.testcase.dto.stockout.outbound;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:48
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiverInfo {
    String countryCode;
    String province;
    String city;
    String area;
    String town;
    String detailAddress;
    String name;
    String tel;
    String mobile;
    int idType;
    String zipCode;

    public ReceiverInfo() {
        this.countryCode = "CN";
        this.province = "浙江省";
        this.city = "杭州市";
        this.area = "江干区";
        this.town = "哈哈小镇";
        this.detailAddress = "彩虹大道101号";
        this.name = "陈小姐";
        this.tel = "15966660000";
        this.mobile = "15818521909";
        this.idType =1 ;
        this.zipCode = "";
    }
}
