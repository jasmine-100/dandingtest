package outchannel.websc.domain;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 16:17
 */
@Data
public class Params {
    private String originJson;
    private String serviceName;
    private String partnerId;

    public Params(Object object, String serviceName, String partnerId) {
        this.originJson = JSON.toJSON(object).toString();
        this.serviceName = serviceName;
        this.partnerId = partnerId;
    }

}
