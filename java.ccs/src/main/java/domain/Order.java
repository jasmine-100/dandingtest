package domain;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:24
 */
@Data
public class Order {

    private String declareOrderNo;
    private String declarePayNo;
    private String outOrderNo;

    private String payChannel;
    private String tradePayNo;
    private long tradeTime;
    private String routeCode;

    private String senderName;
    private String buyerIdNumber;
    private String buyerName;
    private String buyerTelNumber;

    private String consigneeProvince;
    private String consigneeCity;
    private String consigneeDistrict;
    private String consigneeAddress;
    private String consigneeEmail;
    private String consigneeName;
    private String consigneeTel;

    private double discount;
    private double feeAmount;
    private double taxAmount;
    private double insureAmount;

    private int grossWeight;
    private int netWeight;

    private String expressCode;
    private List<Item> itemList;

    private String logisticsNo;
    private String notifyUrl;

    public Order(String declareOrderNo, String expressCode, String logisticsNo, String routeCode, List<Item> itemList) {
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.declareOrderNo = declareOrderNo;
        this.declarePayNo = "DPN"+str;
        this.outOrderNo = "OON"+str;
        this.payChannel = "Alipay";
        this.tradePayNo = "TPN"+str;
        this.tradeTime = System.currentTimeMillis();
        this.routeCode = routeCode;
        this.senderName = "奶粉厂家";
        this.buyerIdNumber = "330110199912102236";
        this.buyerName = "Lily";
        this.buyerTelNumber = "15566669999";
        this.consigneeProvince = "浙江省";
        this.consigneeCity = "杭州市";
        this.consigneeDistrict = "西湖区";
        this.consigneeAddress = "科技路小小区100号1单元501室";
        this.consigneeEmail = "123456@126.com";
        this.consigneeName = "Eimmly";
        this.consigneeTel = "11122223333";
        this.discount = 5;
        this.feeAmount = 50;
        this.taxAmount = 10.23;
        this.insureAmount = 50;
        this.grossWeight = 10;
        this.netWeight = 9;
        this.expressCode = expressCode;
        this.logisticsNo = logisticsNo;
        this.itemList = itemList;
        this.notifyUrl = "http://www.baidu.com";
    }
}
