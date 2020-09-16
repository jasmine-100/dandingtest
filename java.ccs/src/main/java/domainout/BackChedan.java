package domainout;

import client.ApiClient;
import jxc.BaseParam;
import domain.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/5 18:09
 */
public class BackChedan {
    static String data = null;

    static String returnStatus;
    static String returnInfo;

    // 撤单回执：申报
    public static void backShenbao(String orderno, String ebpCode, String ebcCode, String agentCode, String returnTime) throws IOException {
        returnStatus = "2";
        returnInfo = "新增申报成功";
        backFunction(orderno, ebpCode, ebcCode, agentCode, returnStatus, returnInfo, returnTime);
    }

    // 撤单回执：逻辑校验通过
    public static void backLogicpass(String orderno, String ebpCode, String ebcCode, String agentCode, String returnTime) throws IOException {
        returnStatus = "120";
        returnInfo = "[Code:1800;Desc:逻辑校验通过]";
        backFunction(orderno, ebpCode, ebcCode, agentCode, returnStatus, returnInfo, returnTime);
    }

    // 撤单回执：撤单成功
    public static void backChedanSuccess(String orderno, String ebpCode, String ebcCode, String agentCode, String returnTime) throws IOException {
        returnStatus = "399";
        returnInfo = "[Code:2300;Desc:审核通过],撤单申请审核通过,清单已成功撤单";
        backFunction(orderno, ebpCode, ebcCode, agentCode, returnStatus, returnInfo, returnTime);
    }

    // 撤单回执：申报失败
    public static void backChedanFail(String orderno, String ebpCode, String ebcCode, String agentCode, String returnTime) throws IOException {
        returnStatus = "-451";
        returnInfo = "申报失败";
        backFunction(orderno, ebpCode, ebcCode, agentCode, returnStatus, returnInfo, returnTime);
    }

    // 清单撤单--回执模板
    static void backFunction(String orderno, String ebpCode, String ebcCode, String agentCode, String returnStatus, String returnInfo, String returnTime) {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB624Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"2B91DA66-77A7-409D-AC5C-982B441E5585\">" +
                "<InvtCancelReturn>" +
                "<guid>e3e55fe2-1218-40ae-8bc7-043ee3ed5cea</guid>" +
                "<customsCode>2924</customsCode>" +
                "<agentCode>" + agentCode + "</agentCode>" +
                "<ebpCode>" + ebpCode + "</ebpCode>" +
                "<ebcCode>" + ebcCode + "</ebcCode>" +
                "<copNo>" + orderno + "</copNo>" +
                "<preNo>C20200629524696153</preNo>" +
                "<invtNo>29242020I451907002</invtNo>" +
                "<returnStatus>" + returnStatus + "</returnStatus>" +
                "<returnTime>" + returnTime + "</returnTime>" +
                "<returnInfo>" + returnInfo + "</returnInfo>" +
                "</InvtCancelReturn>" +
                "</CEB624Message>";
        ApiClient.doPostForm(BaseParam.URL_BACK,null,null,new Param(data));
    }


}
