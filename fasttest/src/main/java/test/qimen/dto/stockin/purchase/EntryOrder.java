package test.qimen.dto.stockin.purchase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:54
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryOrder {
    String entryOrderCode;
    String orderCreateTime;
    String orderType; // DBRK 调拨入库；其他都是采购入库，常规CGRK
    String warehouseCode;
    String ownerCode;
    String purchaseOrderCode;// 采购单号
    String supplierCode;
    String supplierName;
    SenderInfo senderInfo;
    int totalOrderLines;
    String remark;

    public EntryOrder(String entryOrderCode, String warehouseCode, String ownerCode, String orderType, String supplierCode, List<OrderLine> orderLines) {
        this.entryOrderCode = entryOrderCode;
        this.orderCreateTime = "2021-01-02 10:00:00";
        this.purchaseOrderCode = "P" + entryOrderCode;
        this.warehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.orderType = orderType;
        this.supplierCode = supplierCode;
        this.supplierName = "";
        this.senderInfo = new SenderInfo();
        this.totalOrderLines = orderLines.size();
        this.remark = "早点儿发货哦";
    }
}
