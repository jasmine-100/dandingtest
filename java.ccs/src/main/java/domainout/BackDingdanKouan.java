package domainout;

import client.ApiClient;
import dao.Data;
import orderutils.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 海关订单申报--单一窗口回执报文
 * @Date : Created in 2020/8/4 15:36
 */
public class BackDingdanKouan {
    static String data = null;

    // 支付企业未备案
    public static void errorPayCompany(String orderno,String date) throws IOException {
        modelKouan(orderno,"22001:支付企业未备案",date);
    }

    public static void errorEndorse(String orderno,String date) throws IOException {
        modelKouan(orderno,"-301020:调用加签接口失败",date);
    }

    public static void errorBusCompany(String orderno,String date) throws IOException {
        modelKouan(orderno,"22002:电商平台编号未备案",date);
    }

    /**
     * 回执加签失败
     * @param orderno
     * @throws IOException
     */
    public static void modelKouan(String orderno,String resulInfo,String date) throws IOException {
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
                "                <noticeDate>"+date+"</noticeDate>" +
                "                <noticeTime>00:03</noticeTime>" +
                "                <resultList>" +
                "                    <jkfResultDetail>" +
                "                        <resultInfo>"+resulInfo+"</resultInfo>" +
                "                    </jkfResultDetail>" +
                "                </resultList>" +
                "            </jkfResult>" +
                "        </list>" +
                "    </body>" +
                "</mo>";
        new ApiClient(Data.URL_BACK).doPostForm(new Param(data));
    }

}
