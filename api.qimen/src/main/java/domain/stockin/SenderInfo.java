package domain.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:57
 */
@Data
public class SenderInfo {
    private String name;
    private String tel;
    private String mobile;
    private String countryCode;
    private String province;
    private String city;
    private String area;
    private String town;
    private String detailAddress;

    public SenderInfo(String province, String city, String area) {
        this.name = "jasmine";
        this.tel = "15522223333";
        this.mobile = "15522223333";
        this.countryCode = "CN";
        this.province = province;
        this.city = city;
        this.area = area;
        this.town = "彩虹小镇";
        this.detailAddress = "理想大道101号A座5楼";
    }
}
