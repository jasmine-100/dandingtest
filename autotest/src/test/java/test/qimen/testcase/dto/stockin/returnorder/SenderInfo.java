package test.qimen.testcase.dto.stockin.returnorder;

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
    String countryCode;
    String province;
    String city;
    String area;
    String town;
    String detailAddress;

    public SenderInfo() {
        this.name = "jasmine";
        this.mobile = "15522223333";
        this.tel = "15522223333";
        this.countryCode = "CN";
        this.province = "浙江省";
        this.city = "杭州市";
        this.area = "江干区";
        this.town = "童话镇";
        this.detailAddress = "理想大道101号A座5楼";
    }


}
