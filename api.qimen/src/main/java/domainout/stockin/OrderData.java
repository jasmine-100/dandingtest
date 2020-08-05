package domainout.stockin;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:45
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderData {

     EntryOrder entryOrder;

    @XmlElementWrapper(name = "orderLines")
    @XmlElement(name = "orderLine")
     List<OrderLine> orderLines;

    public OrderData() {
    }

    public OrderData(EntryOrder entryOrder, List<OrderLine> orderLines) {
        this.entryOrder = entryOrder;
        this.orderLines = orderLines;
    }
}
