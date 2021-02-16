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
    int type;
    int expectTime;
    String businessNo;
    String origSystem;
    int approvalStatus;
}
