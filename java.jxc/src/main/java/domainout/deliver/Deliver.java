package domainout.deliver;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 14:37
 */
@Data
public class Deliver {
     String originOrderNo;
     String shopCode;
     long payTime;
     long submitTime;
     long fetchTime;
     String logicStoreCode;
     String logisticsCode;
     String buyerName;
     String buyerMobile;
     String buyerAddress;
     List<OrderSku> orderSkuDetails;

    public Deliver( String shopCode,List<OrderSku> orderSkuDetails) {
        this.originOrderNo = "JS"+System.currentTimeMillis();
        this.shopCode = shopCode;
        this.payTime = System.currentTimeMillis();
        this.submitTime = System.currentTimeMillis();
        this.fetchTime = System.currentTimeMillis();
        this.logicStoreCode = "LSVUACUHBM";
        this.logisticsCode = "BSHT";
        this.buyerName = "秦莉莉";
        this.buyerMobile = "15966663333";
        this.buyerAddress = "浙江省杭州市江干区九和路110号商务园101室";
        this.orderSkuDetails = orderSkuDetails;
    }
}
