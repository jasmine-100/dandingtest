package domainout;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import dao.Data;
import orderutils.Param;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description : 清单回执报文，未完成
 * 税费回执：只校验清单编号，其他信息随意填；其他回执必须填写完整正确的企业编号和订单清单信息。
 * @Date : Created in 2020/7/20 13:11
 */
public class BackQingDan {
    static String data = null;

    static String returnStatus;
    static String returnInfo;

    //总署回执：逻辑校验通过
    public static void backLogicPass(String orderNo,String ebpCode,String ebcCode,String agentCode,String invtNo,String returntime) throws IOException {
        returnStatus = "120";
        returnInfo = "[Code:1800;Desc:逻辑校验通过]";
        function(orderNo,ebpCode,ebcCode,agentCode,invtNo,returnStatus,returnInfo,returntime);
    }

    //总署回执：新增申报成功
    public static void backDeclareSuccess(String orderNo,String ebpCode,String ebcCode,String agentCode,String invtNo,String returntime) throws IOException {
        returnStatus = "2";
        returnInfo = "清单新增申报成功[电商企业编码：4401962010订单编号：124183351885]";
        function(orderNo,ebpCode,ebcCode,agentCode,invtNo,returnStatus,returnInfo,returntime);
    }

    //总署回执：放行
    public static void backPass(String orderNo,String ebpCode,String ebcCode,String agentCode,String invtNo,String returntime) throws IOException {
        returnStatus = "800";
        returnInfo = "[Code:2600;Desc:放行]";
        function(orderNo,ebpCode,ebcCode,agentCode,invtNo,returnStatus,returnInfo,returntime);
    }

    /**
     * 口岸回执：处理成功
     * @param orderno 订单号
     * @param companyCode 清关企业代码
     */
    public static void kouan(String orderno,String companyCode) throws IOException {
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<mo version=\"1.0.0\">" +
                    "<head>" +
                        "<businessType>RESULT</businessType>" +
                    "</head>" +
                    "<body>" +
                        "<list>" +
                            "<jkfResult>" +
                                "<companyCode>"+companyCode+"</companyCode>" +
                                "<businessNo>"+orderno+"</businessNo>" +
                                "<businessType>PERSONAL_GOODS_DECLAR</businessType>" +
                                "<declareType>1</declareType>" +
                                "<chkMark>1</chkMark>" +
                                "<noticeDate>2020-06-15</noticeDate>" +
                                "<noticeTime>17:15</noticeTime>" +
                                "<resultList>" +
                                "<jkfResultDetail>" +
                                "<resultInfo>处理成功</resultInfo>" +
                                    "</jkfResultDetail>" +
                                "</resultList>" +
                            "</jkfResult>" +
                        "</list>" +
                    "</body>" +
                "</mo>";
        new ApiClient(Data.URL2).doPostForm(new Param(data,"kouan"));
    }

    /**
     * 清单申报--回执模板
     * @param orderNo 传入申报单编号
     * @param ebcCode 电商企业编码
     * @param ebpCode 电商平台编码
     * @param agentCode 清关企业代码
     * @param invtNo 清单编号
     * @param returnStatus 报文状态
     * @param returnInfo 报文信息
     * @param returntime 海关回执时间
     * @throws IOException
     */
    static void function(String orderNo,String ebcCode,String ebpCode,String agentCode,String invtNo,String returnStatus,String returnInfo,String returntime) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB622Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"c988cb9e-ea4b-463a-87c4-36e3d24aa7d9\">" +
                "    <InventoryReturn>" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>" +
                "        <customsCode>2924</customsCode>" +
                "        <ebpCode>"+ebpCode+"</ebpCode>" +
                "        <ebcCode>"+ebcCode+"</ebcCode>" +
                "        <agentCode>"+agentCode+"</agentCode>" +
                "        <copNo>"+orderNo+"</copNo>" +
                "        <preNo>B20200615494000227</preNo>" +
                "        <invtNo>"+invtNo+"</invtNo>" +
                "        <returnStatus>"+returnStatus+"</returnStatus>" +
                "        <returnTime>"+returntime+"</returnTime>" +
                "        <returnInfo>"+returnInfo+"</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        new ApiClient(Data.URL2).doPostForm(new Param(data));
    }

}
