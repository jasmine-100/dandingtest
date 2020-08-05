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
     int type;//类型：采购入库
     String purOrderId; //关联采购单号
     String supplierName; // 供应商名称
     String logicWareCode; //收货仓库
     long predictTime; //预计入库时间

     String linkman; //联系人姓名
     String telephone; //手机号
     String company; //快递公司
     String waybill;//快递单号

     List<StoOrderItem> orderItemList; //入库商品list

    public StockinOrder(String purOrderId,List<StoOrderItem> orderItemList) {
        this.purOrderId = purOrderId;
        this.type = 1;
        this.supplierName = "最大供应商";
        this.logicWareCode = "LSVUACUHBM";
        this.predictTime = System.currentTimeMillis();
        this.linkman = "jasmine";
        this.telephone = "15966662222";
        this.company = "BSHT";
        this.waybill = "123000456";
        this.orderItemList = orderItemList;
    }
}
