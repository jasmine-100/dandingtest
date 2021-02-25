package test.qimen.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:46
 */
@Data
public class Param {
     String app_key;
     String method; // deliveryorder.create 发货单；stockout.create 出库单；
     String sign_method;
     String customerId;
     String format;
     String timestamp;
     String sign;
     String v;

    public Param(String method) {
        this.app_key = "23782426";
        this.method = method;
        this.sign_method = "md5";
        this.customerId = "ERPOMSTEST";
        this.format = "xml";
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.sign = "1CA34165AEB3F513A79940727F3D3F21";
        this.v = "2.0";
    }

}
