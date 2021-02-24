package ccs.dto;

import lombok.Data;
import utils.util.UtilsTime;

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
    String tenantOuterId; //租户ID
    String tenantName; //租户名称

    String declareOrderNo;
    String declarePayNo; //支付申报流水号
    String outOrderNo;
    String routeCode;//申报路由编码
    String firstIdentify;//申报路由标识1
    String secondIdentify;//申报路由标识2
    String thirdIdentify;//申报路由标识3
    String senderName;
    String buyerIdNumber;
    String buyerName;
    String buyerTelNumber;
    String consigneeProvince;
    String consigneeCity;
    String consigneeDistrict;
    String consigneeAddress;
    String consigneeEmail;
    String consigneeName;
    String consigneeTel;
    double discount;  // 优惠
    double feeAmount;  // 运费
    double taxAmount;  // 税费
    double insureAmount;  // 保费
    int grossWeight;//毛重
    int netWeight;//净重
    String expressCode;
    List<Item> itemList;
    String logisticsNo;
    String notifyUrl;

    String payChannel;//支付渠道
    String customsCode;//
    String tradePayNo;//支付交易流水号
    long tradeTime;//交易时间|付款时间
    String outTradeNo; // 上游交易流水号
    String payInfoDataCheckFlag;//是否开启海关179备查，1
    String payRequestMessage;//支付请求原始数据
    String payResponseMessage;//支付返回原始数据
    double payTransactionAmount;//支付单总金额
    String payTransactionId;//验核机构交易流水号
    String payWay;//海关订单支付方式
    String merchantCode;// 商户号
    String recpAccount;//收款渠道下的账号
    String recpCode;//验核机构名称
    String verDept;//收款企业社会信用代码
    String recpName;//收款企业工商备案名称

    String systemGlobalSn;//全局单号

    // 实体类
    public Order(String tenantOuterId,String tenantName,String outOrderNo,String declareOrderNo, String expressCode, String logisticsNo,
                 String routeCode,List<Item> itemList) {
        this.outTradeNo = "PN"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        this.merchantCode = "MC2009250949000038";
        this.customsCode = "JINYI";
        this.tenantOuterId = tenantOuterId;
        this.tenantName = tenantName;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.declareOrderNo = declareOrderNo;
        this.declarePayNo = "PN" + str;
        this.outOrderNo = outOrderNo;
        this.payChannel = "wechatpay";
        this.tradePayNo = "TPN" + str;
        this.tradeTime = UtilsTime.getTime("yyyyMMddHHmmss","20201010120000");
        this.routeCode = routeCode;
        this.senderName = "奶粉厂家";
        this.buyerIdNumber = "330110199912102236";
        this.buyerName = "Lily";
        this.buyerTelNumber = "15566669999";
        this.consigneeProvince = "浙江省";
        this.consigneeCity = "杭州市";
        this.consigneeDistrict = "江干区";
        this.consigneeAddress = "科技路小小区100号1单元501室";
        this.consigneeEmail = "123456@126.com";
        this.consigneeName = "Eimmly";
        this.consigneeTel = "11122223333";
        this.discount = 6;
        this.feeAmount = 11;
        this.taxAmount = 12.23;
        this.insureAmount = 15;
        this.grossWeight = 10;
        this.netWeight = 9;
        this.expressCode = expressCode;
        this.logisticsNo = logisticsNo;
        this.itemList = itemList;
        this.notifyUrl = "http://www.baidu.com";
        this.firstIdentify = "";
        this.secondIdentify = "";
        this.thirdIdentify = "";
    }
}
