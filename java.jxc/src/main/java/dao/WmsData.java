package dao;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/25 10:26
 */
public class WmsData {
    String serviceType;
    String serviceVersion;
    String sign;
    String bizData;
    String partnerId;

    public WmsData(String serviceType,String bizData) {
        this.serviceType = serviceType;
        this.serviceVersion = "1.0";
        this.sign = "13f78d170e936e7d85ce162c7f29f805";
        this.bizData = bizData;
        this.partnerId = "hwa01803";
    }

}
