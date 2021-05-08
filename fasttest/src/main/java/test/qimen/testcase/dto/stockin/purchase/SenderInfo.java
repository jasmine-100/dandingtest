package test.qimen.testcase.dto.stockin.purchase;

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
    String mobile;
    String province;
    String city;
    String area;
    String detailAddress;

    public SenderInfo() {
        this.company = "旗舰店";
        this.name = "jasmine";
        this.mobile = "15522223333";
        this.province = "浙江省4";
        this.city = "杭州市4";
        this.area = "江干区4";
        this.detailAddress = "理想大道101号A座5楼";
    }

    public SenderInfo(String province, String city, String area) {
        this.name = "jasmine";
        this.mobile = "15522223333";
        this.province = province;
        this.city = city;
        this.area = area;
        this.detailAddress = "理想大道101号A座5楼";
    }

}
