package domainout;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import orderutils.Param;

/**
 * @Author： jasmine
 * @Description : 退货单--海关回执
 * @Date : Created in 2020/8/4 14:49
 */
public class BackTuiHuo {
    static String url = "http://ccs.fen.daily.yang800.com/zjport/callback";
    static String data = null;

    /**
     * 推送待人工审核报文
     */
    public static void backWaitExamine(String orderno,String ebpCode,String ebcCode) throws Exception {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB626Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"9d8b9ae4-b07b-42b3-bdac-afa918c432f6\">" +
                "<InvtRefundReturn>" +
                "<guid>268f3fbd-0fba-424a-9ed0-2cf5e351b7ba</guid>" +
                "<customsCode>2924</customsCode>" +
                "<agentCode>330766K00Q</agentCode>" +
                "<ebpCode>"+ebpCode+"</ebpCode>" +
                "<ebcCode>"+ebcCode+"</ebcCode>" +
                "<copNo>"+orderno+"</copNo>" +
                "<preNo>T20200615002294592</preNo>" +
                "<invtNo>29242020I390203862</invtNo>" +
                "<returnStatus>300</returnStatus>" +
                "<returnTime>20200804140052906</returnTime>" +
                "<returnInfo>[Code:1200;Desc:待人工审核]</returnInfo>" +
                "</InvtRefundReturn></CEB626Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    /**
     * 推送地址不详报文
     * @return
     */
    public static void backAddressError(String orderno,String ebpCode,String ebcCode) throws Exception {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB626Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"d55547cc-8d99-4841-af9f-6b9651cfe1ae\">" +
                "<InvtRefundReturn" +
                "<guid>268f3fbd-0fba-424a-9ed0-2cf5e351b7ba</guid>" +
                "<customsCode>2924</customsCode>" +
                "<agentCode>330766K00Q</agentCode>" +
                "<ebpCode>"+ebcCode+"</ebpCode>" +
                "<ebcCode>"+ebcCode+"</ebcCode>" +
                "<copNo>"+orderno+"</copNo>" +
                "<preNo>T20200615002294592</preNo>" +
                "<invtNo>29242020I390203862</invtNo>" +
                "<returnStatus>100</returnStatus>" +
                "<returnTime>20200804140052906</returnTime>" +
                "<returnInfo>收件地址不详</returnInfo>" +
                "</InvtRefundReturn></CEB626Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    /**
     * 推送放行报文
     * @return
     */
    public static void backPass(String orderno,String ebpCode,String ebcCode,String agentCode) throws Exception {
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
                "<returnStatus>800</returnStatus>" +
                "<returnTime>20200622162402291</returnTime>" +
                "<returnInfo>[Code:2600;Desc:放行]</returnInfo>" +
                "</InvtRefundReturn>" +
                "</CEB626Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

}
