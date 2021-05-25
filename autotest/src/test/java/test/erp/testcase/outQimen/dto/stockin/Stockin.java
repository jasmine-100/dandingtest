package test.erp.testcase.outQimen.dto.stockin;

import lombok.Data;
import utils.util.UtilsTime;

import java.util.List;

@Data
public class Stockin {
    String upstreamNo;//奇门的上游单号
    String logicWarehouseCode;
    String ownerCode;
    List<InOrderDetailParam> inOrderDetailParamList;
    BusinessValue businessValue;//入库单号
    ReceiveSendInfoParam receiveSendInfoParam;
    String remark;
    int isPush;
    int isBack;
    int tradeType;
    int type;// 1 采购入库；2调拨入库；3 退货入库
    long expectTime;
    String businessNo;
    String origSystem;
    int approvalStatus;

    public Stockin(String orderNo,int orderType,String outShopId,String warehouseCode, String ownerCode, List<InOrderDetailParam> inOrderDetailParamList) {
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
        this.expectTime = UtilsTime.getTime("20210230000000");
        this.origSystem = "OMS";
        this.approvalStatus = 1;
    }

    public Stockin(String orderNo,int orderType,String outShopId,String warehouseCode, String ownerCode, List<InOrderDetailParam> inOrderDetailParamList,ReceiveSendInfoParam receiveInfo) {
        this.upstreamNo = "S"+orderNo;
        this.businessNo = orderNo;
        this.logicWarehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.inOrderDetailParamList = inOrderDetailParamList;
        this.businessValue = new BusinessValue("THRK",outShopId,warehouseCode);
        this.receiveSendInfoParam = receiveInfo;
        this.remark = "奇门备注哈哈哈";
        this.isPush = 1;
        this.isBack = 1;
        this.tradeType = 2;
        this.type = orderType;
        this.expectTime = UtilsTime.getTime("20210230000000");
        this.origSystem = "OMS";
        this.approvalStatus = 1;
    }

}
