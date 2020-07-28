package oms.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description : OMS订单类
 * @Date : Created in 2020/7/20 11:19
 */
@Data
public class Order {
    private String outOrderSn;
    private String declareOrderSn;
    private String customsDeclarationCode;
    private long orderTime;
    private String payChannel;
    private String payNo;
    private long payTime;

    private String payerIdNumber;
    private String payerName;

    private String shopId;
    private String sourceChannel;
    private String customsPayNo;
    private long customsPayTime;

    private String consigneeProvince;
    private String consigneeCity;
    private String consigneeDistrict;
    private String consigneeDetailAddress;
    private String consigneeName;
    private String consigneeIdNumber;
    private String consigneeTel;

    private List<Item> itemList;
    private double itemPrice;
    private double shipmentPrice;
    private double taxPrice;
    private double discountPrice;
    private double totalPrice;


    private String senderProvince;
    private String senderCity;
    private String senderDistrict;
    private String senderStreet;
    private String senderName;
    private String senderMobile;

    private String merchantCode;
    private String packingMaterials;
    private String version;
    private String remark;

    public Order(String outOrderSn, String shopId, List<Item> itemList, double shipmentPrice, double taxPrice, double discountPrice) {
        this.outOrderSn = outOrderSn;
        this.declareOrderSn = outOrderSn;
        this.customsDeclarationCode = "";
        this.orderTime = 1577870729;
        this.payChannel = "wechatpay";
        this.payNo = "pn123456";
        this.payTime = 1580549129;
        this.payerIdNumber = "331112199928123360";
        this.payerName = "jasmine";
        this.shopId = shopId;
        this.sourceChannel = "";
        this.customsPayNo = "";
        this.customsPayTime = 1583054729;
        this.consigneeProvince = "浙江省";
        this.consigneeCity = "杭州市";
        this.consigneeDistrict = "江干区";
        this.consigneeDetailAddress = "东方电子商务园";
        this.consigneeName = "秦莉莉";
        this.consigneeIdNumber = "330110199915061123";
        this.consigneeTel = "15566663333";
        this.itemList = itemList;
        this.itemPrice = itemList.stream().reduce(0.0,(x,y)->x+(y.getUnitPrice()*y.getCount()),Double::sum);
        this.shipmentPrice = shipmentPrice;
        this.taxPrice = taxPrice;
        this.discountPrice = discountPrice;
        this.totalPrice = this.itemPrice+this.shipmentPrice+this.taxPrice-this.discountPrice;
        this.senderProvince = "上海";
        this.senderCity = "上海市";
        this.senderDistrict = "虹口区";
        this.senderStreet = "智慧小镇";
        this.senderName = "金义仓";
        this.senderMobile = "15566663333";
        this.merchantCode = "M2020011616192516787";
        this.packingMaterials = "DT";
        this.version = "v1.0";
        this.remark = "你好备注";
    }
}
