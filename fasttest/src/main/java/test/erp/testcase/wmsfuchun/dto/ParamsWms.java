package test.erp.testcase.wmsfuchun.dto;

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
     String partnerId;
     String sign;

    public ParamsWms(String bizData, String serviceType, String serviceVersion) {
        this.bizData = bizData;
        this.serviceVersion = serviceVersion;
        this.serviceType = serviceType;
        this.partnerId = "test001";
        this.sign = "63f6e2b3474143a0699f53cae6ccca72";
    }
}
