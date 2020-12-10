package ccs.dtoBack;

import ccs.Data;
import ccs.dto.Param;
import client.ApiClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/6 13:29
 */
public class BackTax {
    static String data = null;

    // 海关回执：税费
    // 回执报文报文中，清单号必须正确，其他信息取CCS系统中的信息，不校验
    public static void backTaxrd(String invtNo,String ebcCode,double taxPrice,double valueAddedTax,double consumptionTax,String returntime) {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB816Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"e98878cc-48ef-4ce5-968d-dddc3d47a304\">" +
                    "<Tax>" +
                        "<TaxHeadRd>" +
                            "<guid>e98878cc-48ef-4ce5-968d-dddc3d47a304</guid>" +
                            "<returnTime>"+returntime+"</returnTime>" +
                            "<invtNo>"+invtNo+"</invtNo>" +
                            "<taxNo>TX"+System.currentTimeMillis()+"_0</taxNo>" +
                            "<customsTax>0.0</customsTax>" +
                            "<valueAddedTax>"+valueAddedTax+"</valueAddedTax>" +
                            "<consumptionTax>"+consumptionTax+"</consumptionTax>" +
                            "<status>1</status>" +
                            "<entDutyNo></entDutyNo>" +
                            "<note></note>" +
                            "<assureCode>330766K00Q</assureCode>" +
                            "<ebcCode>"+ebcCode+"</ebcCode>" +
                            "<logisticsCode>123</logisticsCode>" +
                            "<agentCode>123</agentCode>" +
                            "<customsCode>2924</customsCode>" +
                            "<orderNo>Jos123</orderNo>" +
                            "<logisticsNo>JD0018734413066</logisticsNo>" +
                        "</TaxHeadRd>" +
                        "<TaxListRd>" +
                            "<gnum>1</gnum>" +
                            "<gcode>2201101000</gcode>" +
                            "<taxPrice>"+taxPrice+"</taxPrice>" +
                            "<customsTax>0.0</customsTax>" +
                            "<valueAddedTax>"+valueAddedTax+"</valueAddedTax>" +
                            "<consumptionTax>"+consumptionTax+"</consumptionTax>" +
                        "</TaxListRd>" +
                    "</Tax>" +
                "</CEB816Message>";
//        new ApiClient(BaseParam.URL_BACK).doPostForm(new Param(data));
        ApiClient.doPostForm(Data.URL_BACK,null,null,new Param(data));
    }

    // 回执税金状态--汇总
    public static void backTaxTotal(String invtNo,String returnTime)  {
        function(invtNo,returnTime,"2");
    }

    // 回执税金状态--作废
    public static void backTaxCancel(String invtNo, String returnTime) {
        function(invtNo,returnTime,"3");
    }

    // 税金状态回执模板
    // status:1-已生成;2-已汇总;3-作废
    static void function(String invtNo,String returnTime,String status) {
        data = "<CEB818Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"ec43d7c9-21bc-448d-8b11-aba3ca9beb5b\">" +
                "<Tax>" +
                "<TaxHeadStatus>" +
                "<guid>ec43d7c9-21bc-448d-8b11-aba3ca9beb5b</guid>" +
                "<returnTime>"+returnTime+"</returnTime>" +
                "<invtNo>"+invtNo+"</invtNo>" +
                "<taxNo>TX"+System.currentTimeMillis()+"_2</taxNo>" +
                "<status>"+status+"</status>" +
                "<entDutyNo></entDutyNo>" +
                "<assureCode>330766K00W</assureCode>" +
                "</TaxHeadStatus>" +
                "</Tax>" +
                "</CEB818Message>";
        ApiClient.doPostForm(Data.URL_BACK,null,null,new Param(data));
    }

}
