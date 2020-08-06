package domainout;

import client.ApiClient;
import orderutils.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/5 18:09
 */
public class BackChedan {
    static String url = "http://ccs.fen.daily.yang800.com/zjport/callback";
    static String data = null;

    static String returnStatus;
    static String returnInfo;

    // 撤单回执：申报
    public static void backShenbao(String orderno,String ebpCode,String ebcCode,String agentCode) throws IOException {
        returnStatus = "2";
        returnInfo = "申报";
        backFunction(orderno,ebpCode,ebcCode,agentCode,returnStatus,returnInfo);
    }

    // 撤单回执：逻辑校验通过
    public static void backLogicpass(String orderno,String ebpCode,String ebcCode,String agentCode) throws IOException {
        returnStatus = "120";
        returnInfo = "[Code:1800;Desc:逻辑校验通过]";
        backFunction(orderno,ebpCode,ebcCode,agentCode,returnStatus,returnInfo);
    }

    // 撤单回执：撤单成功
    public static void backChedanSuccess(String orderno,String ebpCode,String ebcCode,String agentCode) throws IOException {
        returnStatus = "399";
        returnInfo = "[Code:2300;Desc:审核通过],撤单申请审核通过,清单[29242020I426334468]已成功撤单";
        backFunction(orderno,ebpCode,ebcCode,agentCode,returnStatus,returnInfo);
    }

    // 清单撤单--回执模板
    static void backFunction(String orderno, String ebpCode, String ebcCode, String agentCode, String returnStatus, String returnInfo) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB624Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"2B91DA66-77A7-409D-AC5C-982B441E5585\">" +
                    "<InvtCancelReturn>" +
                        "<guid>e3e55fe2-1218-40ae-8bc7-043ee3ed5cea</guid>" +
                        "<customsCode>2924</customsCode>" +
                        "<agentCode>"+agentCode+"</agentCode>" +
                        "<ebpCode>"+ebpCode+"</ebpCode>" +
                        "<ebcCode>"+ebcCode+"</ebcCode>" +
                        "<copNo>"+orderno+"</copNo>" +
                        "<preNo>C20200629524696153</preNo>" +
                        "<invtNo>29242020I451907002</invtNo>" +
                        "<returnStatus>"+returnStatus+"</returnStatus>" +
                        "<returnTime>20200629134542938</returnTime>" +
                        "<returnInfo>"+returnInfo+"</returnInfo>" +
                    "</InvtCancelReturn>" +
                "</CEB624Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }


}
