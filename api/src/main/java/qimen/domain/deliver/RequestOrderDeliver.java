package qimen.domain.deliver;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:24
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestOrderDeliver {
     DeliveryOrder deliveryOrder;

    @XmlElementWrapper(name = "orderLines")
    @XmlElement(name = "orderLine")
     List<OrderLine> orderLines;

    public RequestOrderDeliver() {
    }

    public RequestOrderDeliver(DeliveryOrder deliveryOrder, List<OrderLine> orderLines) {
        this.deliveryOrder = deliveryOrder;
        this.orderLines = orderLines;
    }
}
