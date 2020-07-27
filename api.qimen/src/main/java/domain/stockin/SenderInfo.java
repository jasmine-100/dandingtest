package domain.stockin;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:57
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SenderInfo {
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

    public SenderInfo(String province, String city, String area) {
        this.name = "jasmine";
        this.tel = "15522223333";
        this.mobile = "15522223333";
        this.countryCode = "中国";
        this.province = province;
        this.city = city;
        this.area = area;
        this.town = "彩虹小镇";
        this.detailAddress = "理想大道101号A座5楼";
    }

    public SenderInfo(String company,String province, String city, String area) {
        this.company = company;
        this.name = "jasmine";
        this.tel = "15522223333";
        this.mobile = "15522223333";
        this.countryCode = "中国";
        this.province = province;
        this.city = city;
        this.area = area;
        this.town = "彩虹小镇";
        this.detailAddress = "理想大道101号A座5楼";
    }

}
