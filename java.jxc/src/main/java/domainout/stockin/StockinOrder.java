package domainout.stockin;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:37
 */
@Data
public class StockinOrder {
    String logicWareCode; //收货仓库
    List<StoOrderItem> orderItemList; //入库商品list
    String purOrderId; //关联采购单号
    Transport transport;
    int type;//类型：采购入库

    public StockinOrder(String logicWareCode,String purOrderId,List<StoOrderItem> orderItemList) {
        this.logicWareCode = logicWareCode;
        this.orderItemList = orderItemList;
        this.purOrderId = purOrderId;
        this.type = 1;
        transport = new Transport();
    }
}
