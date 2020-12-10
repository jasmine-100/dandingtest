package wmsFuchun.dto;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 17:01
 */
@Data
public class ParamsWms {
     String bizData;
     String serviceVersion;
     String serviceType;

    public ParamsWms(String bizData, String serviceType, String serviceVersion) {
        this.bizData = bizData;
        this.serviceVersion = serviceVersion;
        this.serviceType = serviceType;
    }
}
