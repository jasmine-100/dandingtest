package test.erp.testcase.outapi.wmsdaita.dto.stockout;

import lombok.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/29 14:51
 */
@Data
public class StockoutOrder {

    String downstreamNo;
    String outOrderNo;
    String warehouseCode;
    String ownerCode;
    String operationTime;
    String actualDate;
    String logisticsCompanyCode;//快递公司编码
    String logisticsNo;//单号
    int orderType;// 1 B单出库；2调拨出库；3 C单出库；

    List<SkuParam> skuParamList;
    String backFlag;

    public StockoutOrder(String outOrderNo,String downstreamNo, String warehouseCode, String ownerCode,String logisticsCompanyCode, String logisticsNo, int orderType, List<SkuParam> skuParamList,String operationTime,String actualDate) {
        this.downstreamNo = downstreamNo;
        this.outOrderNo = outOrderNo;
        this.warehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.operationTime = operationTime;
        this.actualDate = actualDate;
        this.logisticsCompanyCode = logisticsCompanyCode;
        this.logisticsNo = logisticsNo;
        this.orderType = orderType;
        this.skuParamList = skuParamList;
        this.backFlag = new SimpleDateFormat("hhmmssSSS").format(new Date());
    }
}
