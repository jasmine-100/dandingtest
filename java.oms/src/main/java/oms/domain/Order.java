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
    String outOrderSn;
    String declareOrderSn;
    String customsDeclarationCode;
    long orderTime;
    String payChannel;
    String payNo;
    long payTime;

    String payerIdNumber;
    String payerName;

    String shopId;
    String sourceChannel;
    String customsPayNo;
    long customsPayTime;

    String consigneeProvince;
    String consigneeCity;
    String consigneeDistrict;
    String consigneeDetailAddress;
    String consigneeName;
    String consigneeIdNumber;
    String consigneeTel;

    List<Item> itemList;
    double itemPrice;
    double shipmentPrice;
    double taxPrice;
    double discountPrice;
    double totalPrice;


    String senderProvince;
    String senderCity;
    String senderDistrict;
    String senderStreet;
    String senderName;
    String senderMobile;

    String merchantCode;
    String packingMaterials;
    String version;
    String remark;

    public Order(String outOrderSn, String shopId, List<Item> itemList, double shipmentPrice, double taxPrice, double discountPrice) {
        this.outOrderSn = outOrderSn;
        this.declareOrderSn = outOrderSn;
        this.customsDeclarationCode = "";
        this.orderTime = System.currentTimeMillis();     //1577870729;
        this.payChannel = "wechatpay";
        this.payNo = "pn123456";
        this.payTime = System.currentTimeMillis();//1580549129;
        this.payerIdNumber = "331112199928123360";
        this.payerName = "jasmine";
        this.shopId = shopId;
        this.sourceChannel = "";
        this.customsPayNo = "PN" + outOrderSn;
        this.customsPayTime = System.currentTimeMillis();//1583054729;
        this.consigneeProvince = "上海";
        this.consigneeCity = "上海";
        this.consigneeDistrict = "闵行区";
        this.consigneeDetailAddress = "东方电子商务园";
        this.consigneeName = "秦莉莉";
        this.consigneeIdNumber = "330110199915061123";
        this.consigneeTel = "15566663333";
        this.itemList = itemList;
        this.itemPrice = itemList.stream().reduce(0.0, (x, y) -> x + (y.getUnitPrice() * y.getCount()), Double::sum);
        this.shipmentPrice = shipmentPrice;
        this.taxPrice = taxPrice;
        this.discountPrice = discountPrice;
        this.totalPrice = this.itemPrice + this.shipmentPrice + this.taxPrice - this.discountPrice;
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
