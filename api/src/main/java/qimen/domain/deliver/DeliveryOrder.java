package qimen.domain.deliver;

import qimen.domain.stockin.OrderLine;
import qimen.domain.stockin.SenderInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:25
 */
@XmlAccessorType(XmlAccessType.FIELD)
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

    public DeliveryOrder(String deliveryOrderCode, String orderType, String warehouseCode, String shopNick, List<OrderLine> orderLines, String logisticsCode, SenderInfo senderInfo, ReceiverInfo receiverInfo) {
        this.deliveryOrderCode = deliveryOrderCode;
        this.preDeliveryOrderCode = "20200701";
        this.preDeliveryOrderId = "";
        this.orderType = orderType;
        this.warehouseCode = warehouseCode;
        this.orderFlag = "";
        this.sourcePlatformCode = "PDD";
        this.sourcePlatformName = "拼多多";
        this.buyerMessage = "快点儿发货咯";
        this.sellerMessage = "发货咯";
        this.createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.placeOrderTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.payTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.payNo = "4200000594202006309194038449";
        this.shopNick = shopNick;
        this.sellerNick = "小仓库";
        this.buyerNick = "大买家";
        this.operatorName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.arAmount = 0;
        this.itemAmount = orderLines.stream().reduce(0.0,(x,y)->x+(y.getPlanQty()*y.getActualPrice()),Double::sum);
        this.discountAmount = 0;
        this.freight = 0;
        this.totalAmount = this.itemAmount+this.freight+this.arAmount-this.discountAmount;
        this.logisticsCode = logisticsCode;
        this.logisticsName = "";
        this.expressCode = "";
        this.operateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.isUrgency = "N";
        this.invoiceFlag = "N";
        this.senderInfo = senderInfo;
        this.receiverInfo = receiverInfo;
        this.remark = "你好备注";
    }
}
