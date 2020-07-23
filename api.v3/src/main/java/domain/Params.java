package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 15:27
 */
@Data
public class Params {
    private String originJson;
    private String serviceName;
    private String appId;

    public Params(String originJson, String serviceName, String appId) {
        this.originJson = originJson;
        this.serviceName = serviceName;
        this.appId = appId;
    }
}
