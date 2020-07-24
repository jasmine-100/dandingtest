package domain.deliver;

import domain.stockin.SenderInfo;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:25
 */
public class DeliveryOrder {
    String deliveryOrderCode;
    String preDeliveryOrderCode;
    String preDeliveryOrderId;
    String orderType;
    String warehouseCode;
    String orderFlag;
    String sourcePlatformCode;
    String sourcePlatformName;
    String buyerMessage;
    String sellerMessage;
    String createTime;
    String placeOrderTime;
    String payTime;
    String payNo;
    String shopNick;
    String sellerNick;
    String buyerNick;
    String operatorName;
    double totalAmount;
    double arAmount;
    double itemAmount;
    double discountAmount;
    int freight;
    String logisticsCode;
    String logisticsName;
    String expressCode;
    String operateTime;
    String isUrgency;
    String invoiceFlag;

    SenderInfo senderInfo;
    ReceiverInfo receiverInfo;

    String remark;


}
