package outchannel.websc.domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 16:27
 */
@Data
public class Cancel {
     String orderNo;
     String accessCode;

    public Cancel(String orderNo, String accessCode) {
        this.orderNo = orderNo;
        this.accessCode = accessCode;
    }
}
