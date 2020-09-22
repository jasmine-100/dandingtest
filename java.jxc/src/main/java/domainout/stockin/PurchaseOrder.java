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
    String payMethod; //付款方式 0
    String supplierCode; //供应商编码
    String type;
    int totalNum;
    double totalMoney;
    List<PurOrderItem> orderItemList;//采购商品列表
    String rate;

    public PurchaseOrder(List<PurOrderItem> orderItemList,String supplierCode,String billCurrency) {
        this.billCurrency = billCurrency;
        this.deliveryTime = System.currentTimeMillis();
        this.orderItemList = orderItemList;
        this.payMethod = "0";//默认 货到付款
        this.supplierCode = supplierCode;//测试环境已存在的供应商
        this.totalNum = orderItemList.stream().collect(Collectors.summingInt(PurOrderItem::getPurchaseNum));
        this.totalMoney = orderItemList.stream().collect(Collectors.summingDouble(PurOrderItem::getTotalMoney));
        this.type = "0";//默认 新品规划
    }

    public PurchaseOrder(List<PurOrderItem> orderItemList,String supplierCode,String billCurrency,long deliveryTime,String payMehtod,String type,String rate) {
        this.billCurrency = billCurrency;
        this.deliveryTime = deliveryTime;
        this.orderItemList = orderItemList;
        this.payMethod = payMehtod;//默认 货到付款
        this.supplierCode = supplierCode;//测试环境已存在的供应商
        this.totalNum = orderItemList.stream().collect(Collectors.summingInt(PurOrderItem::getPurchaseNum));
        this.totalMoney = orderItemList.stream().collect(Collectors.summingDouble(PurOrderItem::getTotalMoney));
        this.type = type;//默认 新品规划
        this.rate = rate;
    }

}
