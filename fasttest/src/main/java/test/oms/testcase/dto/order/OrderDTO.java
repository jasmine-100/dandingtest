package test.oms.testcase.dto.order;

import lombok.Data;
import utils.util.UtilsTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/12 14:09
 */
@Data
public class OrderDTO {
    // 单据信息
    String outOrderNo;
    String outShopCode;//外部店铺授权的accessCode
    long orderTime;
    String key;
    String saleChannel;//B2CSC但丁商城，
    String appCode;//渠道编码
    String remark;
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
    // 申报单信息
    String declareOrderNo;
    String declarePayNo;// 支付申报流水号
    String declareCode; //申报路径编码
    // 支付信息
    String outPayNo;
    String payNo;//第三方支付流水号
    String merchantCode;
    String payChannel;
    String payerName;
    String payerCardId;
    double payAmount;
    long payTime;
    long payDeclareTime;
    long promiseTime;
    String customsCode;//口岸

    public OrderDTO(String outOrderNo, List<Item> itemList, String expressCode,String expressNo, String appCode, String outShopCode,String province,String city,String district) {
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.outOrderNo = outOrderNo;
        this.declareOrderNo = outOrderNo;
        this.outPayNo = "OPN"+str;
        this.outShopCode = outShopCode;
        this.orderTime = UtilsTime.getTime("20210101120000");
        this.key = "webB2CwebB2C336OON1606982954410";
        this.saleChannel = "KUAISHOU";
        this.appCode = appCode;
        this.remark = "早点儿发货哦";
        this.declarePayNo = "DPN"+str;
        this.payNo = "PN"+str;
        this.itemList = itemList;
        this.packageMaterial = "DT";
        this.customsCode = "JINYI";//金义口岸
        this.goodsAmount = itemList.stream().reduce(0.0,(x,y)->x+(y.getUnitPrice()*y.getCount()),Double::sum);
        this.shipAmount = 10.5;
        this.taxAmount = 20;
        this.discount = 1;
        this.expressCode = expressCode;
        this.expressNo = expressNo;
        // 收货信息
        this.receiverName = "~AgAAAACZM5UF/UWWnwA3pWsXY7a7U4aaFnBhudCLBZo=~Eelw//ms~10~~";
        this.receiverMobile = "$X5JTusXbWCpy$AgAAAACZM5UG/UWWnwCVVhxFsnQoOdJwEhovk6QymiI=$10$$";
        this.receiverCardId = "330110200012135502";
        this.receiverProvince = province;
        this.receiverCity = city;
        this.receiverDistrict = district;
        this.receiverAddress = "九堡九和路科技城";
        //发货信息
//        this.senderName = "齐吉吉";
//        this.senderMobile = "15866660000";
//        this.senderProvince = "河北省";
//        this.senderCity = "石家庄市";
//        this.senderDistrict = "长安区";
//        this.senderAddress = "彩虹路100号";
        //支付人信息
        this.payerName = "jasmine";
        this.payerCardId = "330159666623012236";
        this.payChannel = "wechatpay";

        this.declareCode = "PathErpV2";//申报路径编码
        this.merchantCode = "MC2009250949000038"; // 付款商户号
        this.payAmount = this.goodsAmount+this.shipAmount+this.taxAmount-this.discount;
        this.payTime = UtilsTime.getTime("20210102150000");
        this.payDeclareTime = UtilsTime.getTime("20210105160000");
        this.promiseTime = UtilsTime.getTime("20210103130000");
    }
}
