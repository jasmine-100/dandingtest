package outchannel.websc.domain;

import lombok.Data;

import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 16:00
 */
@Data
public class Order {
     String accessCode;
     String orderNo;

     String province;
     String city;
     String district;
     String street;
     String name;
     String idCard;
     String mobile;

     String senderShop;
     String remark;
     String payerName;
     String payerNumber;
     String payChannel;
     String tradeNo;
     double payAmount;
     String customsDeclarationCode;
     String sourcePlatform;
     String packingMaterials;

     String sender_province;
     String sender_city;
     String sender_district;
     String sender_street;
     String sender_name;
     String sender_mobile;

     List<Item> itemList;

    public Order(String accessCode, String orderNo,List<Item> itemList) {
        this.accessCode = accessCode;
        this.orderNo = orderNo;
        this.province = "浙江省";
        this.city = "杭州市";
        this.district = "江干区";
        this.street = "九堡科技园";
        this.name = "秦莉莉";
        this.idCard = "";
        this.mobile = "15622223333";
        this.senderShop = "但丁云旗舰店";
        this.remark = "你好备注";
        this.payerName = "jasmine";
        this.payerNumber = "330110201101235596";
        this.payChannel = "wechatpay";
        this.tradeNo = "TN"+new Random().nextInt(100000);
        this.payAmount = itemList.stream().reduce(0.0,(x,y)->x+(y.getPrice()*y.getNum()+y.getShipFee()+y.getTax()-y.getDiscount()),Double::sum);
        this.customsDeclarationCode = "";
        this.sourcePlatform = "";
        this.packingMaterials = "DT";
        this.sender_province = "上海";
        this.sender_city = "上海市";
        this.sender_district = "虹口区";
        this.sender_street = "陆家嘴";
        this.sender_name = "琴琴";
        this.sender_mobile = "18966663333";
        this.itemList = itemList;
    }
}
