package oms.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 17:19
 */
@Data
public class PayInfo {
    private String declareOrderSn;
    private String payChannel;
    private String payNo;
    private long payTime;
    private String payWay;
    private String verDept;
    private String payTransactionId;
    private double payTransactionAmount;
    private String payRequestMessage;
    private String payResponseMessage;
    private String recpAccount;
    private String recpCode;
    private String recpName;
    private List<GoodInfo> goodsInfoList;

    public PayInfo(String declareOrderSn) {
        this.declareOrderSn = declareOrderSn;
        this.payChannel = "wechatpay";
        this.payNo = "pn123456";
        this.payTime = System.currentTimeMillis();
        this.payWay = "pc";
        this.verDept = "核验机构名称";
        this.payTransactionId = "验核机构交易流水号";
        this.payTransactionAmount = 1000.65;
        this.payRequestMessage = "请求原始报文";
        this.payResponseMessage = "响应原始报文";
        this.recpAccount = "收款账号";
        this.recpCode = "收款企业社会信用代码";
        this.recpName = "收款企业工商备案名称";
        this.goodsInfoList = new ArrayList<GoodInfo>();
        goodsInfoList.add(new GoodInfo("商品名称","商品链接"));
    }
}
