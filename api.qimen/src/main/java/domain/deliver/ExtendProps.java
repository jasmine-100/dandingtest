package domain.deliver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:30
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtendProps {
    private String declareOrderNo;
    private double taxAmount;
    private String buyerName;
    private String buyerIdNum;
    private String sellPlatRecordName;
    private String orderFrom;
    private String orderShop;
    private double actualAmount;
    private double tariffAmount;
    private double consumptionDutyAmount;
    private double addedValueTaxAmount;
    private double discountAmount;
    private double declaringValueAmount;
    private String orderSeqNo;
    @XmlElementWrapper(name = "extOrderLines")
    @XmlElement(name = "extOrderLine")
    private List<ExtOrderLine> extOrderLines;

    public ExtendProps(String declareOrderNo, double taxAmount,String orderShop, double actualAmount, List<ExtOrderLine> extOrderLines) {
        this.declareOrderNo = declareOrderNo;
        this.taxAmount = taxAmount;
        this.buyerName = "陈赛巧";
        this.buyerIdNum = "44253019620710172X";
        this.sellPlatRecordName = "";
        this.orderFrom = "";
        this.orderShop = orderShop;
        this.actualAmount = actualAmount;
        this.tariffAmount = 0;
        this.consumptionDutyAmount = 0;
        this.addedValueTaxAmount = 0;
        this.discountAmount = 0;
        this.declaringValueAmount = 0;
        this.orderSeqNo = "4200000594202006309194038449";
        this.extOrderLines = extOrderLines;
    }
}
