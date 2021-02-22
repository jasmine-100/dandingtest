package erp.qimen.dto.cancel;

import lombok.Data;

@Data
public class OrderCancel {
    String orderNo;
    String orderType; // -1 入库；-2 出库
    String origSystem;
    String logicWarehouseCode;
    String ownerCode;
    String cancelReason;

    public OrderCancel(String orderNo, String orderType, String logicWarehouseCode, String ownerCode) {
        this.orderNo = orderNo;
        this.orderType = orderType;
        this.origSystem = "QM";
        this.logicWarehouseCode = logicWarehouseCode;
        this.ownerCode = ownerCode;
        this.cancelReason = "订单取消";
    }
}

