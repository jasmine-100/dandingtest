package domainout;

import client.ApiClient;
import jxc.BaseParam;
import domain.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 海关订单申报--总署回执报文
 * @Date : Created in 2020/8/4 15:36
 */
public class BackDingdanZongshu {
    static String data = null;

    // 总署回执：正常的回执
    public static void declareAddOk(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        modelZongshu(orderno, ebpCode, ebcCode, "2", "新增申报成功", returnTime);
    }
    public static void logicOk(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        modelZongshu(orderno, ebpCode, ebcCode, "120", "[Code:1800;Desc:逻辑校验通过]", returnTime);
    }

    // 申报失败的回执
    public static void errorCompany(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        modelZongshu(orderno, ebpCode, ebcCode, "100", "[Code:13035;Desc:支付企业不一致]", returnTime);
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
    public static void modelZongshu(String orderno, String ebpCode, String ebcCode, String returnStatus, String returnInfo, String returnTime) throws IOException {
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
        new ApiClient(BaseParam.URL_BACK).doPostForm(new Param(data));
    }
}
