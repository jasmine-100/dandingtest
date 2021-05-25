package test.qimen.testcase.dto.stockin.purchase;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:45
 */
@Data
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestData {

     EntryOrder entryOrder;

    @XmlElementWrapper(name = "orderLines")
    @XmlElement(name = "orderLine")
     List<OrderLine> orderLines;

    ExtendProps extendProps;

    public RequestData() {
    }

    public RequestData(EntryOrder entryOrder, List<OrderLine> orderLines) {
        this.entryOrder = entryOrder;
        this.orderLines = orderLines;
        this.extendProps = new ExtendProps("浙江省金华市金东区","CG"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
    }
}
