package test.qimen.testcase.dto.stockout.deliver;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/1 17:05
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtendProps {
    String declareOrderNo;
    String payCompanyCustomsCode;
    String payCompanyCustomsName;
    String buyerName;//购买人姓名
    String buyerIdNum;//购买人身份证
    String sellPlatRecordName;
    String orderFrom;
    String orderShop;
    Double actualAmount;//货款金额
    double tariffAmount;//关税
    double consumptionDutyAmount;//消费税
    double addedValueTaxAmount;//增值税
    double taxAmount;
    double discountAmount;//折扣
    int declaringValueAmount;
    String orderSeqNo;
    @XmlElementWrapper(name = "extOrderLines")
    @XmlElement(name = "extOrderLine")
    List<ExtOrderLine> extOrderLines;
    boolean selfSupport;
    String innerProps;

    public ExtendProps(String declareOrderNo,double tariffAmount, double consumptionDutyAmount, double addedValueTaxAmount, double discountAmount, int declaringValueAmount,DeliveryOrder deliveryOrder, List<OrderLine> orderLines) {
        this.declareOrderNo = declareOrderNo;
        this.payCompanyCustomsCode = "MC2009250949000038";
//        this.payCompanyCustomsName = "";
        this.buyerName = "李哈哈";
        this.buyerIdNum = "331110230211201120";
        this.sellPlatRecordName = "";
        this.orderFrom = "";
        this.orderShop = "";
        this.tariffAmount = tariffAmount;
        this.consumptionDutyAmount = consumptionDutyAmount;
        this.addedValueTaxAmount = addedValueTaxAmount;
        this.taxAmount = this.tariffAmount+this.consumptionDutyAmount+this.addedValueTaxAmount;
        this.actualAmount = orderLines.stream().reduce(0.0,(x,y)->x+(y.getPlanQty()*y.getActualPrice()),Double::sum);
        this.discountAmount = discountAmount;
        this.declaringValueAmount = declaringValueAmount;
        this.orderSeqNo = deliveryOrder.getPayNo();
        this.extOrderLines = new ArrayList<>();
        for(OrderLine i:orderLines){
            extOrderLines.add(new ExtOrderLine(i.getOrderLineNo(),i.getItemCode(),i.getBatchCode(),i.getItemName()));
        }
        this.selfSupport = false;
        this.innerProps = "";
    }
}

@Data
class ExtOrderLine {
    int orderLineNo;
    String itemCode;//外部渠道的商品编码
    String BatchCode;
    String platTradeNumber;//外部渠道的商品编码
    String platTradeSpec;
    String platTradeName;//外部渠道的商品名称

    public ExtOrderLine(int orderLineNo, String itemCode, String batchCode,String platTradeName) {
        this.orderLineNo = orderLineNo;
        this.itemCode = itemCode;
        BatchCode = batchCode;
        this.platTradeNumber = itemCode;
        this.platTradeSpec = "";
        this.platTradeName = platTradeName;
    }

}