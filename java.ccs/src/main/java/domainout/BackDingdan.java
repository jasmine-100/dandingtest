package domainout;

import client.ApiClient;
import dao.Data;
import orderutils.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 海关订单申报--回执报文
 * @Date : Created in 2020/8/4 15:36
 */
public class BackDingdan {
    static String data = null;

    static String returnStatus;
    static String returnInfo;

    // 总署回执：新增申报成功
    public static void declareAddOk(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        returnStatus = "2";
        returnInfo = "新增申报成功";
        function(orderno, ebpCode, ebcCode, returnStatus, returnInfo, returnTime);
    }

    // 总署回执：逻辑校验通过
    public static void logicOk(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        returnStatus = "120";
        returnInfo = "[Code:1800;Desc:逻辑校验通过]";
        function(orderno, ebpCode, ebcCode, returnStatus, returnInfo, returnTime);
    }

    // 总署回执：订单中的订购人姓名和身份证不匹配
    public static void backIDError(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        returnStatus = "99";
        returnInfo = "订单中的订购人姓名和身份证不匹配！";
        function(orderno, ebpCode, ebcCode, returnStatus, returnInfo, returnTime);
    }

    // 总署回执：清单上的订购人姓名与订单上的订购人姓名不一致
    public static void backNameError(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        returnStatus = "100";
        returnInfo = "[Code:13127;Desc:清单上的订购人姓名与订单上的订购人姓名不一致]";
        function(orderno, ebpCode, ebcCode, returnStatus, returnInfo, returnTime);
    }

    // 总署回执：支付单支付金额与订单支付金额不一致
    public static void backMoneyError(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        returnStatus = "100";
        returnInfo = "[Code:1332;Desc:支付单支付金额与订单支付金额不一致],[OrderHead.acturalPaid:561.89,PaymentHead.amountPaid3197.95]";
        function(orderno, ebpCode, ebcCode, returnStatus, returnInfo, returnTime);
    }

    // 总署回执：清单表体商品项与订单表体商品项的项数不一致
    public static void backItemError(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        returnStatus = "100";
        returnInfo = "[Code:1320;Desc:清单表体商品项与订单表体商品项的项数不一致],[InventoryHead.orderNo:DOCP201910312059110001008544,OrderHead.orderNo:DOCP201910312059110001008544]";
        function(orderno, ebpCode, ebcCode, returnStatus, returnInfo, returnTime);
    }

    /**
     * 订单申报--回执模板
     *
     * @param orderno      传入申报单编号
     * @param ebpCode      电商平台编码
     * @param ebcCode      电商企业编码
     * @param returnStatus 报文状态
     * @param returnInfo   报文信息
     * @param returnTime   海关回执时间
     * @throws IOException
     */
    static void function(String orderno, String ebpCode, String ebcCode, String returnStatus, String returnInfo, String returnTime) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB312Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"479237c3-ec79-4d05-bced-3f3299e64c57\">" +
                "    <OrderReturn>" +
                "        <guid>5f872141-8cbb-4537-9867-787071afaa72</guid>" +
                "        <ebpCode>" + ebpCode + "</ebpCode>" +
                "        <ebcCode>" + ebcCode + "</ebcCode>" +
                "        <orderNo>" + orderno + "</orderNo>" +
                "        <returnStatus>" + returnStatus + "</returnStatus>" +
                "        <returnTime>" + returnTime + "</returnTime>" +
                "        <returnInfo>" + returnInfo + "</returnInfo>" +
                "    </OrderReturn>" +
                "</CEB312Message>";
        new ApiClient(Data.URL_BACK).doPostForm(new Param(data));
    }

    /**
     * 回执加签失败
     *
     * @param orderno
     * @throws IOException
     */
    public static void vertifyFail(String orderno) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<mo version=\"1.0.0\">" +
                "    <head>" +
                "        <businessType>RESULT</businessType>" +
                "    </head>" +
                "    <body>" +
                "        <list>" +
                "            <jkfResult>" +
                "                <companyCode>3301964J31</companyCode>" +
                "                <businessNo>" + orderno + "</businessNo>" +
                "                <businessType>IMPORTORDER</businessType>" +
                "                <declareType>1</declareType>" +
                "                <chkMark>2</chkMark>" +
                "                <noticeDate>2020-07-08</noticeDate>" +
                "                <noticeTime>00:03</noticeTime>" +
                "                <resultList>" +
                "                    <jkfResultDetail>" +
                "                        <resultInfo>22001调用加签接口失败</resultInfo>" +
                "                    </jkfResultDetail>" +
                "                </resultList>" +
                "            </jkfResult>" +
                "        </list>" +
                "    </body>" +
                "</mo>";
        new ApiClient(Data.URL_BACK).doPostForm(new Param(data));
    }

}
