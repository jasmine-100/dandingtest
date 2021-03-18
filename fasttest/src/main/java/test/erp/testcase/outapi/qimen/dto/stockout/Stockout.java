package test.erp.testcase.outapi.qimen.dto.stockout;

import lombok.Data;
import test.erp.testcase.outapi.qimen.dto.stockin.BusinessValue;
import utils.util.UtilsTime;

import java.util.List;

@Data
public class Stockout {
    String businessNo;
    String upstreamNo;
    long addTime;
    long payTime;
    long expectTime;
    String logicWarehouseCode;
    String ownerCode;
    String shopCode;
    String shopName;
    ReceiveSendInfoFrom receiveSendInfoFrom;
    List<OutOrderDetailFrom> outOrderDetailFromList;
    String origSystem;
    int buyerIDType;
    int type;// 1 B单出库；2 调拨出库；3 C单出库
    int tradeType;
    int isPush;
    int isBack;
    BusinessValue businessValue;
    String packingMaterials;//包材

    public Stockout(String orderno, String warehouseCode, String ownerCode, int orderType,List<OutOrderDetailFrom> outOrderDetailFromList) {
        this.businessNo = orderno;
        this.upstreamNo = orderno;
        this.addTime = System.currentTimeMillis();
        this.payTime =  System.currentTimeMillis();
        this.expectTime = UtilsTime.getTime("20210310000000");
        this.logicWarehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.shopCode = "123";
        this.shopName = "哈哈小店";
        this.packingMaterials = "abc123";
        this.receiveSendInfoFrom = new ReceiveSendInfoFrom();
        this.outOrderDetailFromList = outOrderDetailFromList;
        this.origSystem = "QIMEN";
        this.buyerIDType = 1;
        this.type = orderType;
        this.tradeType = 2;
        this.isPush = 1;
        this.isBack = 1;
        this.businessValue = new BusinessValue("DBCK","123",warehouseCode);
    }

}
