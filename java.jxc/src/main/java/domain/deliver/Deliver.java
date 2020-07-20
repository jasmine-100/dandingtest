package domain.deliver;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 14:37
 */
@Data
public class Deliver {
    private String originOrderNo;
    private String shopCode;
    private long payTime;
    private long submitTime;
    private long fetchTime;
    private String logicStoreCode;
    private String logisticsCode;
    private String buyerName;
    private String buyerMobile;
    private String buyerAddress;
    private List<OrderSku> orderSkuDetails;

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
