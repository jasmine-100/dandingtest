package domainout.stockin;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author： jasmine
 * @Description : 采购单实体类
 * @Date : Created in 2020/7/20 12:38
 */
@Data
public class PurchaseOrder {
    String billCurrency;//币值
    long deliveryTime;
    int payMethod; //付款方式 0
    String supplierCode; //供应商编码
    int type;
    int totalNum;
    double totalMoney;
    List<PurOrderItem> orderItemList;//采购商品列表

    public PurchaseOrder(List<PurOrderItem> orderItemList) {
        this.billCurrency = "RMB";
        this.deliveryTime = System.currentTimeMillis();
        this.orderItemList = orderItemList;
        this.payMethod = 0;//默认 货到付款
        this.supplierCode = "S200822151053659425";//测试环境已存在的供应商
        this.totalNum = orderItemList.stream().collect(Collectors.summingInt(PurOrderItem::getPurchaseNum));
        this.totalMoney = orderItemList.stream().collect(Collectors.summingDouble(PurOrderItem::getTotalMoney));
        this.type = 0;//默认 新品规划
    }
}
