package domainout;

import client.ApiClient;
import orderutils.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/4 15:36
 */
public class BackDingdan {
    static String url = "http://ccs.fen.daily.yang800.com/zjport/callback";
    static String data = null;
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";

    /**
     * 回执新增申报成功
     * @param orderno
     * @throws IOException
     */
    public static void declareSuccess(String orderno) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB312Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"C9C9AD3E-1F8D-4583-B62B-07A5FD3E02FB\">" +
                "    <OrderReturn>" +
                "        <guid>6656067b-adc2-4880-a9cd-0d78f4bb6d81</guid>" +
                "        <ebpCode>"+ebpCode+"</ebpCode>" +
                "        <ebcCode>"+ebcCode+"</ebcCode>" +
                "        <orderNo>"+orderno+"</orderNo>" +
                "        <returnStatus>2</returnStatus>" +
                "        <returnTime>20200708000409381</returnTime>" +
                "        <returnInfo>新增申报成功[3755623E-EC89-4B3E-8894-4DC7136457AF]</returnInfo>" +
                "    </OrderReturn>" +
                "</CEB312Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    /**
     * 回执逻辑校验通过
     * @param orderno
     * @throws IOException
     */
    public static void logicSuccess(String orderno) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB312Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"479237c3-ec79-4d05-bced-3f3299e64c57\">" +
                "    <OrderReturn>" +
                "        <guid>5f872141-8cbb-4537-9867-787071afaa72</guid>" +
                "        <ebpCode>"+ebpCode+"</ebpCode>" +
                "        <ebcCode>"+ebcCode+"</ebcCode>" +
                "        <orderNo>"+orderno+"</orderNo>" +
                "        <returnStatus>120</returnStatus>" +
                "        <returnTime>20200709083910849</returnTime>" +
                "        <returnInfo>[Code:1800;Desc:逻辑校验通过]</returnInfo>" +
                "    </OrderReturn>" +
                "</CEB312Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    /**
     * 回执加签失败
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
                "                <businessNo>"+orderno+"</businessNo>" +
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
        new ApiClient(url).doPostForm(new Param(data));
    }

}
