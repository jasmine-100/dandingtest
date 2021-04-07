package test.erp.testcase.outapi.wmsCainiao.dto;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/7 18:01
 */
@Data
public class RequestData {

    String test;//单据信息

    String types;//GLOBAL_STOCK_IN_ORDER_CONFIRM

    public RequestData(String test, String types) {
        this.test = test;
        this.types = types;
    }
}
