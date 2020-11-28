package dto.stockin;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:58
 */
@Data
public class StockinOrder {
    String downstreamNo;
    String inOrderNo;
    String warehouseCode;
    String ownerCode;
    String operationTime;
    String  actualDate;
    int isConfirm; // 1 中间态；0 终结态
    String orderType; // 1 采购；2 调拨
    List<SkuParam> skuParamList;

    public StockinOrder(String inOrderNo, String warehouseCode, String ownerCode, int isConfirm, String orderType, List<SkuParam> skuParamList) {
        this.downstreamNo = "JIN"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        this.inOrderNo = inOrderNo;
        this.warehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.operationTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.actualDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.isConfirm = isConfirm;
        this.orderType = orderType;
        this.skuParamList = skuParamList;
    }
}
