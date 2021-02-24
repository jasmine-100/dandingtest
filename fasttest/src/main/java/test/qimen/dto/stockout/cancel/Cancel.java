package test.qimen.dto.stockout.cancel;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author： jasmine
 * @Description : 取消出库单
 * @Date : Created in 2021/2/24 17:46
 */
@Data
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cancel {
    String orderCode;
    String orderType; // DBCK
    String warehouseCode;
    String ownerCode;
    String cancelReason;

    public Cancel(String orderCode, String orderType, String warehouseCode, String ownerCode) {
        this.orderCode = orderCode;
        this.orderType = orderType;
        this.warehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.cancelReason = "奇门取消订单";
    }

}
