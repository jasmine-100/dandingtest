package domainout;

import client.ApiClient;
import jxc.BaseParam;
import domain.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 海关订单申报--单一窗口回执报文
 * @Date : Created in 2020/8/4 15:36
 */
public class BackDingdanKouan {
    static String data = null;

    public static void backPass(String orderno,String date) throws IOException {
        modelKouan(orderno,"1","处理成功",date);
    }

    // 申报失败的回执
    public static void errorPayCompany(String orderno,String date) throws IOException {
        modelKouan(orderno,"2","22001:支付企业未备案",date);
    }
    public static void errorEndorse(String orderno,String date) throws IOException {
        modelKouan(orderno,"-301020","验签失败",date);
    }

    /**
     * 回执加签失败
     * @param orderno
     * @throws IOException
     */
    public static void modelKouan(String orderno,String status,String resulInfo,String date) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<mo version=\"1.0.0\">" +
                "    <head>" +
                "        <businessType>RESULT</businessType>" +
                "    </head>" +
                "    <body>" +
                "        <list>" +
                "  <jkfResult>" +
                "      <companyCode>3301964J31</companyCode>" +
                "      <businessNo>" + orderno + "</businessNo>" +
                "      <businessType>IMPORTORDER</businessType>" +
                "      <declareType>1</declareType>" +
                "      <chkMark>"+status+"</chkMark>" +
                "      <noticeDate>"+date+"</noticeDate>" +
                "      <noticeTime>00:03</noticeTime>" +
                "      <resultList>" +
                "          <jkfResultDetail>" +
                "              <resultInfo>"+resulInfo+"</resultInfo>" +
                "          </jkfResultDetail>" +
                "      </resultList>" +
                "  </jkfResult>" +
                "        </list>" +
                "    </body>" +
                "</mo>";
        new ApiClient(BaseParam.URL_BACK).doPostForm(new Param(data,"other"));
    }
}
