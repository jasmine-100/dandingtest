package test.qimen.dto.stockout.deliver;

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
    String name;
    String tel;
    String mobile;
    String province;
    String city;
    String area;
    String detailAddress;

    public SenderInfo() {
        this.name = "jasmine";
        this.tel = "15522223333";
        this.mobile = "15522223333";
        this.province = "浙江省";
        this.city = "杭州市";
        this.area = "江干区";
        this.detailAddress = "理想大道101号A座5楼";
    }

    public SenderInfo(String province, String city, String area) {
        this.name = "jasmine";
        this.tel = "15522223333";
        this.mobile = "15522223333";
        this.province = province;
        this.city = city;
        this.area = area;
        this.detailAddress = "理想大道101号A座5楼";
    }

}
