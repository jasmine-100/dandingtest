package gx.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 13:31
 */
@Data
public class Order {

    private String linkOrderSn;
    private String outOrderSn;
    private double itemPrice;
    private double taxPrice;
    private double totalPrice;
    private long  orderTime;
    private String userId;
    private String consigneeProvince;
    private String consigneeCity;
    private String consigneeDistrict;
    private String consigneeDetailAddress;
    private String consigneeName;
    private String consigneeTel;
    private List<Item> itemList;
    private String remark;

    public Order(String linkOrderSn, String outOrderSn,String userId, List<Item> itemList) {
        this.linkOrderSn = linkOrderSn;
        this.outOrderSn = outOrderSn;
        this.itemPrice = itemList.stream().reduce(0.0,(x,y)->x+(y.getUnitPrice()*y.getCount()),Double::sum);
        this.taxPrice = taxPrice;
        this.totalPrice = this.itemPrice+this.taxPrice;
        this.orderTime = System.currentTimeMillis();
        this.userId = userId;
        this.consigneeProvince = "上海";
        this.consigneeCity = "上海市";
        this.consigneeDistrict = "虹口区";
        this.consigneeDetailAddress = "陆家嘴200号501室";
        this.consigneeName = "李女士";
        this.consigneeTel = "15566663333";
        this.itemList = itemList;
        this.remark = "你好备注";
    }
}
