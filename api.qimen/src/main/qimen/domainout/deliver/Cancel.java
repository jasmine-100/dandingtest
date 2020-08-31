package domainout.deliver;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author： jasmine
 * @Description : 实体类-奇门接口取消订单
 * @Date : Created in 2020/7/31 16:06
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "request")
public class Cancel {
String orderCode;
String orderType;
  String warehouseCode;
    String ownerCode;
    String cancelReason;

    public Cancel() {
    }

    public Cancel(String orderCode, String orderType, String warehouseCode, String ownerCode) {
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.warehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.cancelReason = "取消订单";
    }
}
