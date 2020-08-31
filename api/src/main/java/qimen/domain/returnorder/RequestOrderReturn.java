package qimen.domain.returnorder;
import qimen.domain.stockin.OrderLine;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/27 14:37
 */
@Data
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestOrderReturn {
    ReturnOrder returnOrder;

    @XmlElementWrapper(name = "orderLines")
    @XmlElement(name = "orderLine")
    List<OrderLine> orderLines;

    public RequestOrderReturn(ReturnOrder returnOrder, List<OrderLine> orderLines) {
        this.returnOrder = returnOrder;
        this.orderLines = orderLines;
    }

    public RequestOrderReturn() {
    }
}
