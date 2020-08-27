package domainout.returnorder;

import domainout.stockin.SenderInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/27 14:28
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ReturnOrder {
    String returnOrderCode;
    String warehouseCode;
    String orderType;
    String preDeliveryOrderCode;
    String preDeliveryOrderId;
    String logisticsCode;
    String expressCode;
    String returnReason;
    SenderInfo senderInfo;

    public ReturnOrder(String returnOrderCode, String warehouseCode, String orderType,String expressCode,SenderInfo senderInfo) {
        this.returnOrderCode = returnOrderCode;
        this.warehouseCode = warehouseCode;
        this.orderType = orderType;
        this.preDeliveryOrderCode = "123456";
        this.preDeliveryOrderId = "123456";
        this.logisticsCode = "";
        this.expressCode = expressCode;
        this.returnReason = "买错了";
        this.senderInfo = senderInfo;
    }
}
