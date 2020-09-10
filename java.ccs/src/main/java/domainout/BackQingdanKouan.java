package domainout;

import client.ApiClient;
import database.CcsOrder;
import jxc.BaseParam;
import jxc.Order;
import domain.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 清单回执报文，未完成
 * 税费回执：只校验清单编号，其他信息随意填；其他回执必须填写完整正确的企业编号和订单清单信息。
 * @Date : Created in 2020/7/20 13:11
 */
public class BackQingdanKouan {
    static String data = null;

    public static void backPass(String orderno,String companyCode,String date) throws IOException {
        kouan(orderno,companyCode,"1","处理成功",date);
    }
    /**
     * 口岸回执：处理成功
     * @param declareOrderNo 订单号
     * @param companyCode 清关企业代码
     */
    public static void kouan(String declareOrderNo,String companyCode,String status,String info,String date) throws IOException {
        String orderId = CcsOrder.getOrderSn(declareOrderNo);
        String data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<mo version=\"1.0.0\">" +
                    "<head>" +
                        "<businessType>RESULT</businessType>" +
                    "</head>" +
                    "<body>" +
                        "<list>" +
                            "<jkfResult>" +
                                "<companyCode>"+companyCode+"</companyCode>" +
                                "<businessNo>"+orderId+"</businessNo>" +
                                "<businessType>PERSONAL_GOODS_DECLAR</businessType>" +
                                "<declareType>1</declareType>" +
                                "<chkMark>"+status+"</chkMark>" +
                                "<noticeDate>"+date+"</noticeDate>" +
                                "<noticeTime>17:15</noticeTime>" +
                                "<resultList>" +
                                    "<jkfResultDetail>" +
                                        "<resultInfo>"+info+"</resultInfo>" +
                                    "</jkfResultDetail>" +
                                "</resultList>" +
                            "</jkfResult>" +
                        "</list>" +
                    "</body>" +
                "</mo>";
//        new ApiClient(BaseParam.URL_BACK).doPostForm(new Param(data,"kouan"));
        ApiClient.doPostForm(BaseParam.URL_BACK,null,null,new Param(data,"kouan"));
    }

}
