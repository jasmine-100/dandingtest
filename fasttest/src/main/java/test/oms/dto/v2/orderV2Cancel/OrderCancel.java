package test.oms.dto.v2.orderV2Cancel;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/2 11:33
 */
@Data
public class OrderCancel {

    private String accessCode;

    private String outOrderNo;

    public OrderCancel(String accessCode, String outOrderNo) {
        this.accessCode = accessCode;
        this.outOrderNo = outOrderNo;
    }
}
