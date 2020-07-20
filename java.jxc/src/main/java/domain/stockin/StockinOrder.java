package domain.stockin;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:37
 */
@Data
public class StockinOrder {
    private int type;//类型：采购入库
    private String purOrderId; //关联采购单号
    private String supplierName; // 供应商名称
    private String logicWareCode; //收货仓库
    private long predictTime; //预计入库时间

    private String linkman; //联系人姓名
    private String telephone; //手机号
    private String company; //快递公司
    private String waybill;//快递单号

    private List<StoOrderItem> orderItemList; //入库商品list

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
