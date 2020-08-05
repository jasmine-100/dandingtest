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
 * @Date : Created in 2020/7/20 13:11
 */
public class BackQingDan {
    static String url = "http://ccs.fen.daily.yang800.com/zjport/callback";
    static String data = null;

    //总署回执：逻辑校验通过
    public static void backLogicPass(String orderNo,String ebcCode,String ebpCode,String agentCode) throws IOException {
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
                "        <invtNo>QD"+new SimpleDateFormat("yyMMddHHmmss").format(new Date()) +"</invtNo>" +
                "        <returnStatus>120</returnStatus>" +
                "        <returnTime>20200615171556605</returnTime>" +
                "        <returnInfo>[Code:1800;Desc:逻辑校验通过]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    //总署回执：新增申报成功
    public static void backDeclareSuccess(String orderNo,String ebcCode,String ebpCode) throws IOException {
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
                "        <returnTime>20200616171550734</returnTime>" +
                "        <returnInfo>清单新增申报成功[电商企业编码：4401962010订单编号：124183351885]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    //总署回执：放行
    public static void backPass(String orderNo,String ebcCode,String ebpCode,String invtNo) throws IOException {
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
                "        <returnTime>20200618171556654</returnTime>" +
                "        <returnInfo>[Code:2600;Desc:放行]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        new ApiClient(url).doPostForm(new Param(data));
    }

    //总署回执：税费
    public static void backTaxrd(String orderNo,String invtNo,String ebcCode,String agentCode,double valueAddedTax,double consumptionTax) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB816Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"e98878cc-48ef-4ce5-968d-dddc3d47a304\">" +
                "    <Tax>" +
                "        <TaxHeadRd>" +
                "            <guid>e98878cc-48ef-4ce5-968d-dddc3d47a304</guid>" +
                "            <returnTime>20200620171556658</returnTime>" +
                "            <invtNo>"+invtNo+"</invtNo>" +
                "            <taxNo>TX"+System.currentTimeMillis()+"_1</taxNo>" +
                "            <customsTax>0.0</customsTax>" +
                "            <valueAddedTax>"+valueAddedTax+"</valueAddedTax>" +
                "            <consumptionTax>"+consumptionTax+"</consumptionTax>" +
                "            <status>1</status>" +
                "            <entDutyNo></entDutyNo>" +
                "            <note></note>" +
                "            <assureCode>330766K00Q</assureCode>" +
                "            <ebcCode>"+ebcCode+"</ebcCode>" +
                "            <logisticsCode>"+ebcCode+"</logisticsCode>" +
                "            <agentCode>"+agentCode+"</agentCode>" +
                "            <customsCode>2924</customsCode>" +
                "            <orderNo>"+orderNo+"</orderNo>" +
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
