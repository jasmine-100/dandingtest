package domainout;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
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
    static String url = "http://ccs.fen.daily.yang800.com/zjport/callback";
    static String data = null;

    //总署回执：逻辑校验通过
    public static void backLogicPass(String orderNo,String ebcCode,String ebpCode,String agentCode,String invtNo,String returntime) throws IOException {
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
                "        <returnStatus>120</returnStatus>" +
                "        <returnTime>"+returntime+"</returnTime>" +
                "        <returnInfo>[Code:1800;Desc:逻辑校验通过]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    //总署回执：新增申报成功
    public static void backDeclareSuccess(String orderNo,String ebcCode,String ebpCode,String returntime) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB622Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"48604738-C342-484F-8CA1-46BCF64098D0\">" +
                "    <InventoryReturn>" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>" +
                "        <customsCode>2924</customsCode>" +
                "        <ebpCode>"+ebpCode+"</ebpCode>" +
                "        <ebcCode>"+ebcCode+"</ebcCode>" +
                "        <agentCode>330766K00Q</agentCode>" +
                "        <copNo>"+orderNo+"</copNo>" +
                "        <preNo>B20200615494000227</preNo>" +
                "        <returnStatus>2</returnStatus>" +
                "        <returnTime>"+returntime+"</returnTime>" +
                "        <returnInfo>清单新增申报成功[电商企业编码：4401962010订单编号：124183351885]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    //总署回执：放行
    public static void backPass(String orderNo,String ebcCode,String ebpCode,String invtNo,String returntime) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB622Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"0e24b0c5-8eea-429a-a08b-46a0bad0cabd\">" +
                "    <InventoryReturn>" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>" +
                "        <customsCode>2924</customsCode>" +
                "        <ebpCode>"+ebpCode+"</ebpCode>" +
                "        <ebcCode>"+ebcCode+"</ebcCode>" +
                "        <agentCode>330766K00Q</agentCode>" +
                "        <copNo>"+orderNo+"</copNo>" +
                "        <preNo>B20200615494000227</preNo>" +
                "        <invtNo>"+invtNo+"</invtNo>" +
                "        <returnStatus>800</returnStatus>" +
                "        <returnTime>"+returntime+"</returnTime>" +
                "        <returnInfo>[Code:2600;Desc:放行]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    // 总署回执：税费
    // 回执报文报文中，清单号必须正确，其他信息取CCS系统中的信息，不校验
    public static void backTaxrd(String invtNo,double valueAddedTax,double consumptionTax,String returntime) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB816Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"e98878cc-48ef-4ce5-968d-dddc3d47a304\">" +
                "    <Tax>" +
                "        <TaxHeadRd>" +
                "            <guid>e98878cc-48ef-4ce5-968d-dddc3d47a304</guid>" +
                "            <returnTime>"+returntime+"</returnTime>" +
                "            <invtNo>"+invtNo+"</invtNo>" +
                "            <taxNo>TX"+System.currentTimeMillis()+"_1</taxNo>" +
                "            <customsTax>0.0</customsTax>" +
                "            <valueAddedTax>"+valueAddedTax+"</valueAddedTax>" +
                "            <consumptionTax>"+consumptionTax+"</consumptionTax>" +
                "            <status>1</status>" +
                "            <entDutyNo></entDutyNo>" +
                "            <note></note>" +
                "            <assureCode>330766K00Q</assureCode>" +
                "            <ebcCode>123</ebcCode>" +
                "            <logisticsCode>123</logisticsCode>" +
                "            <agentCode>123</agentCode>" +
                "            <customsCode>2924</customsCode>" +
                "            <orderNo>Jos123</orderNo>" +
                "            <logisticsNo>JD0018734413066</logisticsNo>" +
                "        </TaxHeadRd>" +
                "        <TaxListRd>" +
                "            <gnum>1</gnum>" +
                "            <gcode>2201101000</gcode>" +
                "            <taxPrice>410.0</taxPrice>" +
                "            <customsTax>0.0</customsTax>" +
                "            <valueAddedTax>"+valueAddedTax+"</valueAddedTax>" +
                "            <consumptionTax>"+consumptionTax+"</consumptionTax>" +
                "        </TaxListRd>" +
                "    </Tax>" +
                "</CEB816Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

}
