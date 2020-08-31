package domainout.deliver;

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
    String company;
    String name;
    String zipCode;
    String tel;
    String mobile;
    String countryCode;
    String province;
    String city;
    String area;
    String town;
    String detailAddress;
    String idType;
    String idNumber;

    public ReceiverInfo(String province, String city, String area) {
        this.name = "陈小姐";
        this.zipCode = "";
        this.tel = "";
        this.mobile = "15818521909";
        this.countryCode = "CN";
        this.province = province;
        this.city = city;
        this.area = area;
        this.town = "理想小镇";
        this.detailAddress = "彩虹大道101号";
        this.idType = "1";
        this.idNumber = "44253019620710172X";
    }

    public ReceiverInfo() {
        this.company = "";
        this.name = "陈小姐";
        this.zipCode = "";
        this.tel = "";
        this.mobile = "15818521909";
        this.countryCode = "中国";
        this.province = "浙江省";
        this.city = "杭州市";
        this.area = "江干区";
        this.town = "理想小镇";
        this.detailAddress = "彩虹大道101号";
        this.idType = "1";
        this.idNumber = "44253019620710172X";
    }
}
