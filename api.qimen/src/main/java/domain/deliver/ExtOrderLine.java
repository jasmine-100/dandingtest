package domain.deliver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:35
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtOrderLine {
    private String orderLineNo;
    private String itemCode;
    private String BatchCode;
    private String platTradeNumber;
    private String platTradeSpec;
    private String platTradeName;

    public ExtOrderLine(String orderLineNo, String itemCode, String batchCode, String platTradeNumber,String platTradeName) {
        this.orderLineNo = "";
        this.itemCode = itemCode;
        BatchCode = batchCode;
        this.platTradeNumber = platTradeNumber;
        this.platTradeSpec = "200g/mL";
        this.platTradeName = platTradeName;
    }
}
