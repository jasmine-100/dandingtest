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
        this.app_key = "24869601";
        this.method = method;
        this.sign_method = "md5";
        this.customerId = "DS15879577775092";
        this.format = "xml";
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.sign = "6C362B9F3C756BDED8BBF58E2FB29CF0";
        this.v = "2.0";
    }

}
