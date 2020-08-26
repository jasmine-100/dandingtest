package domainout.outbound;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/26 16:42
 */
@Data
public class Outbound {
    String customerCode;// 客户编码
    String billCurrency; // 币种：RMB-人民币

    // 收货人编码
    String contactId;
//    String contactName;
//    String contactPhone;
//    String mailingAddress;
//    String post;

    long payTime;
    int payTypeCode; // 支付方式：2-全款
    long submitTime;


    List<OrderSkuDetail> orderSkuDetails;

    // "payType":1,"payTypeName":"账期"


    public Outbound(String customerCode, String billCurrency, String contactId, List<OrderSkuDetail> orderSkuDetails) {
        this.customerCode = customerCode;
        this.billCurrency = billCurrency;
        this.contactId = contactId;
//        this.contactName = contactName;
//        this.contactPhone = contactPhone;
//        this.mailingAddress = mailingAddress;
//        this.post = post;
        this.payTime = System.currentTimeMillis();
        this.payTypeCode = 1;
        this.submitTime = System.currentTimeMillis();
        this.orderSkuDetails = orderSkuDetails;
    }
}
