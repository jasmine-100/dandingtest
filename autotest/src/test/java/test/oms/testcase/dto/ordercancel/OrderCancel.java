package test.oms.testcase.dto.ordercancel;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/5/13 16:29
 */
@Data
public class OrderCancel {


    private String systemGlobalSn;

    public OrderCancel(String systemGlobalSn) {
        this.systemGlobalSn = systemGlobalSn;
    }
}
