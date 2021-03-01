package test.qimen.dto.stockout.deliver;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:24
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestData {
     DeliveryOrder deliveryOrder;
    @XmlElementWrapper(name = "orderLines")
    @XmlElement(name = "orderLine")
     List<OrderLine> orderLines;
    ExtendProps extendProps;

    public RequestData() {
    }

    public RequestData(DeliveryOrder deliveryOrder, List<OrderLine> orderLines) {
        this.deliveryOrder = deliveryOrder;
        this.orderLines = orderLines;
    }

    public RequestData(DeliveryOrder deliveryOrder, List<OrderLine> orderLines,ExtendProps extendProps) {
        this.deliveryOrder = deliveryOrder;
        this.orderLines = orderLines;
        this.extendProps = extendProps;
    }
}
