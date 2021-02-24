package test.oms.v2.orderV2;

import lombok.Data;

import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/15 10:06
 */
@Data
public class OrderDTO {
    String orderNo;
    String accessCode;
    boolean bonded;
    String province;
    String city;
    String district;
    String street;
    String name;
    String mobile;
    String payerName;
    String payerNumber;
    String payChannel;
    double payAmount;
    String tradeNo;
    List<Item> itemList;

    public OrderDTO(String orderNo, String accessCode, List<Item> itemList) {
        this.orderNo = orderNo;
        this.accessCode = accessCode;
        this.bonded = false;
        this.province = "浙江省";
        this.city = "杭州市";
        this.district = "西湖区";
        this.street = "蒋村街道花蒋路102号西溪创新园25幢前台";
        this.name = "可乐";
        this.mobile = "15966660000";
        this.payerName = "秦莉莉";
        this.payerNumber = "330110200010201123";
        this.payChannel = "wechatpay";
        this.itemList = itemList;
        this.payAmount = itemList.stream().reduce(0.0,(x,y)->x+(y.getPrice()*y.getNum()+y.getShipFee()+y.getTax()-y.getDiscount()),Double::sum);;
        this.tradeNo = "TN"+orderNo;
    }

}
