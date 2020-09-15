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
    String tenantOuterId; //租户ID
    String tenantName; //租户名称

    String declareOrderNo;
    String declarePayNo; //支付申报流水号
    String outOrderNo;

    String payChannel;
    String tradePayNo;//支付交易流水号
    long tradeTime;//交易时间|付款时间

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

    String payInfoDataCheckFlag;//是否开启海关179备查，1
    String payRequestMessage;//支付请求原始数据
    String payResponseMessage;//支付返回原始数据
    double payTransactionAmount;//支付单总金额
    String payTransactionId;//验核机构交易流水号
    String payWay;//海关订单支付方式
    String recpAccount;//收款渠道下的账号
    String recpCode;//验核机构名称
    String verDept;//收款企业社会信用代码
    String recpName;//收款企业工商备案名称

    // 实体类
    public Order(String tenantOuterId,String tenantName,String outOrderNo,String declareOrderNo, String expressCode, String logisticsNo,
                 String routeCode,List<Item> itemList) {
        this.tenantOuterId = tenantOuterId;
        this.tenantName = tenantName;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.declareOrderNo = declareOrderNo;
        this.declarePayNo = "PN" + str;
        this.outOrderNo = outOrderNo;
        this.payChannel = "wechatpay";
        this.tradePayNo = "TPN" + str;
        this.tradeTime = System.currentTimeMillis();
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

    String goodsName;
    String systemGlobalSn;//全局单号，和进销存一致
    String outTradeNo;
    double goodsSumAmount;
    String merchantCode;

    // OMS订单上报实体类
    public Order(String systemGlobalSn,String outOrderNo,String declareOrderNo,String routeCode) {
        this.goodsName = "testGood";
        this.systemGlobalSn = systemGlobalSn;
        this.declareOrderNo = declareOrderNo;
        this.outOrderNo = outOrderNo;
        this.routeCode = routeCode;
        this.firstIdentify = "";
        this.secondIdentify = "";
        this.thirdIdentify = "";
        this.discount = 6;
        this.feeAmount = 11;
        this.taxAmount = 12.23;
        this.insureAmount = 15;
        this.goodsSumAmount = 100;
        this.payTransactionAmount= goodsSumAmount+feeAmount+taxAmount+insureAmount-discount;
        this.senderName = "奶粉厂家";
        this.buyerIdNumber = "330110199912102236";
        this.buyerName = "Lily";
        this.buyerTelNumber = "15566669999";
        this.payChannel = "wechatpay";
        this.declarePayNo = "PN" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.tradePayNo = "TPN" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.tradeTime = System.currentTimeMillis();
        this.merchantCode = "";
        this.payTransactionId = "";
        this.verDept= "";
        this.payWay = "";
        this.recpCode = "";
        this.recpName = "";
        this.recpAccount = "";
        this.payRequestMessage = "";
        this.payResponseMessage = "";
    }
}
