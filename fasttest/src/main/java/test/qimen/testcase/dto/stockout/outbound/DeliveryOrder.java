package test.qimen.testcase.dto.stockout.outbound;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:25
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliveryOrder {
    String deliveryOrderCode;
    String orderType; // DBCK=调拨出库;其他都是 销售出库，常用PTCK
    String warehouseCode;
    String buyerMessage;
    String sellerMessage;
    String createTime;
    String placeOrderTime;
    String payTime;
    String payNo;
    String sellerNick;
    String buyerNick;
    String logisticsCode;
    String expressCode;
    String operateTime;
    String isUrgency;
    String invoiceFlag;
    SenderInfo senderInfo;
    ReceiverInfo receiverInfo;
    String remark;

    public DeliveryOrder(String deliveryOrderCode, String orderType, String warehouseCode, String logisticsCode, SenderInfo senderInfo, ReceiverInfo receiverInfo) {
        this.deliveryOrderCode = deliveryOrderCode;
        this.orderType = orderType;
        this.warehouseCode = warehouseCode;
        this.buyerMessage = "快点儿发货咯";
        this.sellerMessage = "发货咯";
        this.createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.placeOrderTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.payTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.payNo = "4200000594202006309194038449";
        this.sellerNick = "小仓库";
        this.buyerNick = "大买家";
        this.logisticsCode = logisticsCode;
        this.expressCode = "";
        this.operateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.isUrgency = "N";
        this.invoiceFlag = "N";
        this.senderInfo = senderInfo;
        this.receiverInfo = receiverInfo;
        this.remark = "你好备注";
    }
}
