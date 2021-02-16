package qimen.dto.stockin;

import lombok.Data;
import java.util.List;

@Data
public class Stockin {
    String upstreamNo;
    String logicWarehouseCode;
    String ownerCode;
    List<InOrderDetailParamList> inOrderDetailParamList;
    BusinessValue businessValue;
    ReceiveSendInfoParam receiveSendInfoParam;
    String remark;
    int isPush;
    int isBack;
    int tradeType;
    int type;// 1 采购入库；2调拨入库；3 退货入库
    int expectTime;
    String businessNo;
    String origSystem;
    int approvalStatus;

    public Stockin(String orderNo,int orderType,String outShopId,String warehouseCode, String ownerCode, List<InOrderDetailParamList> inOrderDetailParamList) {
        this.upstreamNo = orderNo;
        this.businessNo = orderNo;
        this.logicWarehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.inOrderDetailParamList = inOrderDetailParamList;
        this.businessValue = new BusinessValue("THRK",outShopId,warehouseCode);
        this.receiveSendInfoParam = new ReceiveSendInfoParam();
        this.remark = "奇门备注哈哈哈";
        this.isPush = 1;
        this.isBack = 1;
        this.tradeType = 2;
        this.type = orderType;
        this.expectTime = 0;
        this.origSystem = "OMS";
        this.approvalStatus = 1;
    }
}
