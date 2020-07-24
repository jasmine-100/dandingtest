package domain.deliver;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 18:24
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliverData {
    private DeliveryOrder deliveryOrder;

    @XmlElementWrapper(name = "orderLines")
    @XmlElement(name = "orderLine")
    private List<OrderLine> orderLines;

    private ExtendProps extendProps;


}
