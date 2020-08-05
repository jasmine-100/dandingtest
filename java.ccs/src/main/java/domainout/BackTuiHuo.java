package domainout;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import orderutils.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 退货单--海关回执
 * @Date : Created in 2020/8/4 14:49
 */
public class BackTuiHuo {
    static String url = "http://ccs.fen.daily.yang800.com/zjport/callback";
    static String data = null;

    static String returnStatus;
    static String returnInfo;

    /**
     * 推送待人工审核报文
     */
    public static void backWaitExamine(String orderno,String ebpCode,String ebcCode,String agentCode) throws Exception {
        returnStatus = "300";
        returnInfo = "[Code:1200;Desc:待人工审核]";
        function(orderno,ebpCode,ebcCode,agentCode,returnStatus,returnInfo);
    }

    /**
     * 推送地址不详报文
     * @return
     */
    public static void backAddressError(String orderno,String ebpCode,String ebcCode,String agentCode) throws Exception {
        returnStatus = "100";
        returnInfo = "收件地址不详";
        function(orderno,ebpCode,ebcCode,agentCode,returnStatus,returnInfo);
    }

    /**
     * 推送放行报文
     * @return
     */
    public static void backPass(String orderno,String ebpCode,String ebcCode,String agentCode) throws Exception {
        returnStatus = "800";
        returnInfo = "[Code:2600;Desc:放行]";
        function(orderno,ebpCode,ebcCode,agentCode,returnStatus,returnInfo);
    }

    static void function(String orderno,String ebpCode,String ebcCode,String agentCode,String returnStatus,String returnInfo) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB626Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"d0cdf79f-0ab5-4322-b6ab-1045a9ccf6fa\">" +
                "<InvtRefundReturn>" +
                "<guid>43e6e694-84e5-4e82-af23-2104f9c1d8b4</guid>" +
                "<customsCode>2924</customsCode>" +
                "<agentCode>"+agentCode+"</agentCode>" +
                "<ebpCode>"+ebpCode+"</ebpCode>" +
                "<ebcCode>"+ebcCode+"</ebcCode>" +
                "<copNo>"+orderno+"</copNo>" +
                "<preNo>T20200622002329381</preNo>" +
                "<invtNo>29242020I416941614</invtNo>" +
                "<returnStatus>"+returnStatus+"</returnStatus>" +
                "<returnTime>20200622162402291</returnTime>" +
                "<returnInfo>"+returnInfo+"</returnInfo>" +
                "</InvtRefundReturn>" +
                "</CEB626Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

}
