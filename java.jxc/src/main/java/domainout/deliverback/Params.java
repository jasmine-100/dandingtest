package domainout.deliverback;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 17:12
 */
@Data
public class Params {
     String serviceVersion;
     String serviceType;
     String bizData;

    public Params(String serviceVersion, String serviceType, String bizData) {
        this.serviceVersion = serviceVersion;
        this.serviceType = serviceType;
        this.bizData = bizData;
    }
}
