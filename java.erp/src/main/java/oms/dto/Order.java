package oms.dto;

import lombok.Data;
import utils.UtilsTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/12 14:09
 */
@Data
public class Order {
    // 单据信息
    String outOrderNo;
    String outShopCode;
    String outPayNo;
    long orderTime;
    String key;
    String saleChannel;
    String appCode;
    String remark;
    // 申报单信息
    String declareOrderNo;
    String declarePayNo;
    String declareCode;
    // 商品信息
    List<Item> itemList;
    String packageMaterial;
    double goodsAmount;
    double shipAmount;
    double taxAmount;
    double discount;
    // 物流信息
    String expressCode;
    String expressNo;
    // 收件人信息
    String receiverProvince;
    String receiverCity;
    String receiverDistrict;
    String receiverAddress;
    String receiverName;
    String receiverMobile;
    String receiverCardId;
    // 发件人信息
    String senderProvince;
    String senderCity;
    String senderDistrict;
    String senderAddress;
    String senderName;
    String senderMobile;
    // 支付信息
    String payNo;
    String merchantCode;
    String payChannel;
    String payerName;
    String payerCardId;
    double payAmount;
    long payTime;
    long payDeclareTime;
    long promiseTime;

    public Order(String outOrderNo,List<Item> itemList,String expressCode, String expressNo,String appCode,String outShopCode) {
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.outOrderNo = outOrderNo;
        this.outPayNo = "OPN"+str;
        this.outShopCode = outShopCode;
        this.orderTime = UtilsTime.getTime("yyyyMMddHHmmss","20210101120000");
        this.key = "webB2CwebB2C336OON1606982954410";
        this.saleChannel = "V2";
        this.appCode = appCode;
        this.remark = "备注";
        this.declareOrderNo = outOrderNo;
        this.declarePayNo = "DPN"+str;
        this.payNo = "PN"+str;
        this.declareCode = "PDD";
        this.merchantCode = "wechatpay";
        this.itemList = itemList;
        this.packageMaterial = "DT";
        this.goodsAmount = itemList.stream().reduce(0.0,(x,y)->x+(y.getUnitPrice()*y.getCount()),Double::sum);
        this.shipAmount = 0;
        this.taxAmount = 20;
        this.discount = 1;
        this.expressCode = expressCode;
        this.expressNo = expressNo;
        this.receiverProvince = "浙江省";
        this.receiverCity = "杭州市";
        this.receiverDistrict = "江干区";
        this.receiverAddress = "九堡九和路科技城";
        this.receiverName = "李哈哈";
        this.receiverMobile = "15966663333";
        this.receiverCardId = "330110200012135502";
        this.senderProvince = "河北省";
        this.senderCity = "石家庄市";
        this.senderDistrict = "长安区";
        this.senderAddress = "彩虹路100号";
        this.senderName = "齐吉吉";
        this.senderMobile = "15866660000";
        this.payChannel = "wechatpay";
        this.payerName = "jasmine";
        this.payerCardId = "330159666623012236";
        this.payAmount = this.goodsAmount+this.shipAmount+this.taxAmount-this.discount;
        this.payTime = System.currentTimeMillis();
        this.payDeclareTime = System.currentTimeMillis();
        this.promiseTime = System.currentTimeMillis();
    }
}
