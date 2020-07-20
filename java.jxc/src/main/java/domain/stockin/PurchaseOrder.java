package domain.stockin;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:38
 */
@Data
public class PurchaseOrder {
    private String purId; //采购单号
    private List<PurOrderItem> orderItemList;//采购商品列表
    private long arrivalTime;//预计到货时间
    private long deliveryTime;//预计发货时间
    private int payMethod; //付款方式
    private String supplierCode;//供应商编码
    private int totalNum;//总数量
    private double totalMoney;//总额
    private int transport;//运输方式
    private int type;//采购类型：
    private String remark;//注释

    public PurchaseOrder(List<PurOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
        this.arrivalTime = System.currentTimeMillis();
        this.deliveryTime = System.currentTimeMillis();
        this.orderItemList = orderItemList;
        this.payMethod = 0;//默认 货到付款
        this.supplierCode = "S2006231326234310";//测试环境已存在的供应商
        this.totalNum = orderItemList.stream().collect(Collectors.summingInt(PurOrderItem::getPurchaseNum));
        this.totalMoney = orderItemList.stream().collect(Collectors.summingDouble(PurOrderItem::getTotalMoney));
        this.transport = 1;//默认 海运
        this.type = 0;//默认 新品规划
        this.remark = "快点发货咯";
    }
}
