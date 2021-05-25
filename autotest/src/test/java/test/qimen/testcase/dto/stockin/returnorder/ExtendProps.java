package test.qimen.testcase.dto.stockin.returnorder;

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
 * @Date : Created in 2021/2/24 16:54
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ExtendProps {
    DeliveryOrder deliveryOrder;

    @XmlElementWrapper(name = "extOrderLines")
    @XmlElement(name = "extOrderLine")
    List<ExtOrderLine> extOrderLines;

    public ExtendProps(List<OrderLine> orderLines) {
        this.deliveryOrder = new DeliveryOrder();
        extOrderLines = new ArrayList<>();
        for (OrderLine orderLine:orderLines){
            extOrderLines.add(new ExtOrderLine(orderLine.getItemCode(),orderLine.getBatchCode(),orderLine.getPlanQty()));
        }
    }
}

class DeliveryOrder{
    String shopName;
    double totalAmount;
    int orderFavourableAmount;
    String shopostAgepName;

    public DeliveryOrder() {
        this.shopName = "balabala小店";
        this.totalAmount = 100;
        this.orderFavourableAmount = 260;
        this.shopostAgepName = "123";
    }
}

class ExtOrderLine{
    int orderLineNo;
    String batchCode;
    String itemCode;
    double price;
    int totalAmount;

    public ExtOrderLine(String itemCode,String batchCode,int totalAmount) {
        this.orderLineNo = 1;
        this.batchCode = batchCode;
        this.itemCode = itemCode;
        this.price = 10;
        this.totalAmount = totalAmount;
    }
}