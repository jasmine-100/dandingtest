package test.qimen.testcase.dto.stockin.returnorder;

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
public class RequestData {
    ReturnOrder returnOrder;

    @XmlElementWrapper(name = "orderLines")
    @XmlElement(name = "orderLine")
    List<OrderLine> orderLines;

    ExtendProps extendProps;

    public RequestData(ReturnOrder returnOrder, List<OrderLine> orderLines) {
        this.returnOrder = returnOrder;
        this.orderLines = orderLines;
        this.extendProps = new ExtendProps(orderLines);
    }

    public RequestData() {
    }
}
