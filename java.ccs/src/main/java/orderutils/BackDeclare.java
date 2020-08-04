package orderutils;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description : 清单申报回执报文
 * @Date : Created in 2020/7/21 11:01
 */
@Data
public class BackDeclare {
    private static String data = null;

    /**
     * 申报单--口岸回执报文
     */
    public static String orderKouAnBack(String orderno){
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<mo version=\"1.0.0\">" +
                "    <head>" +
                "        <businessType>RESULT</businessType>" +
                "    </head>" +
                "    <body>" +
                "        <list>" +
                "            <jkfResult>" +
                "                <companyCode>330766K00Q</companyCode>" +
                "                <businessNo>"+orderno+"</businessNo>" +
                "                <businessType>PERSONAL_GOODS_DECLAR</businessType>" +
                "                <declareType>1</declareType>" +
                "                <chkMark>1</chkMark>" +
                "                <noticeDate>"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +"</noticeDate>" +
                "                <noticeTime>"+new SimpleDateFormat("mm:ss").format(new Date()) +"</noticeTime>" +
                "                <resultList>" +
                "                    <jkfResultDetail>" +
                "                        <resultInfo>处理成功</resultInfo>" +
                "                    </jkfResultDetail>" +
                "                </resultList>" +
                "            </jkfResult>" +
                "        </list>" +
                "    </body>" +
                "</mo>";
        return data;
    }

    /**
     * 总署回执报文--逻辑校验通过
     * @param orderno
     * @return
     */
    public static String orderZongShuBackLogic(String orderno){
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB622Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"c988cb9e-ea4b-463a-87c4-36e3d24aa7d9\">" +
                "    <InventoryReturn>" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>" +
                "        <customsCode>2924</customsCode>" +
                "        <ebpCode>4401962010</ebpCode>" +
                "        <ebcCode>4401962010</ebcCode>" +
                "        <agentCode>330766K00Q</agentCode>" +
                "        <copNo>124183351885</copNo>" +
                "        <preNo>B20200615494000227</preNo>" +
                "        <invtNo>29242020I439440284</invtNo>" +
                "        <returnStatus>120</returnStatus>" +
                "        <returnTime>20200615171556605</returnTime>" +
                "        <returnInfo>[Code:1800;Desc:逻辑校验通过]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        return data;
    }

    /**
     * 总署回执--新增申报成功
     * @return
     */
    public static String orderZongShuBackAddSuc(){
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB622Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"48604738-C342-484F-8CA1-46BCF64098D0\">" +
                "    <InventoryReturn>" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>" +
                "        <customsCode>2924</customsCode>" +
                "        <ebpCode>4401962010</ebpCode>" +
                "        <ebcCode>4401962010</ebcCode>" +
                "        <agentCode>330766K00Q</agentCode>" +
                "        <copNo>124183351885</copNo>" +
                "        <preNo>B20200615494000227</preNo>" +
                "        <returnStatus>2</returnStatus>" +
                "        <returnTime>20200615171550734</returnTime>" +
                "        <returnInfo>清单新增申报成功[电商企业编码：4401962010订单编号：124183351885]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        return data;
    }

    /**
     * 总署回执--海关放行
     * @return
     */
    public static String orderZongShuBackPass(){
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB622Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"0e24b0c5-8eea-429a-a08b-46a0bad0cabd\">" +
                "    <InventoryReturn>" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>" +
                "        <customsCode>2924</customsCode>" +
                "        <ebpCode>4401962010</ebpCode>" +
                "        <ebcCode>4401962010</ebcCode>" +
                "        <agentCode>330766K00Q</agentCode>" +
                "        <copNo>124183351885</copNo>" +
                "        <preNo>B20200615494000227</preNo>" +
                "        <invtNo>29242020I439440284</invtNo>" +
                "        <returnStatus>800</returnStatus>" +
                "        <returnTime>20200615171556654</returnTime>" +
                "        <returnInfo>[Code:2600;Desc:放行]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        return data;
    }

    /**
     * 总署回执--税金
     * @return
     */
    public static String orderZongShuBackTax(){
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB816Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"e98878cc-48ef-4ce5-968d-dddc3d47a304\">" +
                "    <Tax>" +
                "        <TaxHeadRd>" +
                "            <guid>e98878cc-48ef-4ce5-968d-dddc3d47a304</guid>" +
                "            <returnTime>20200615171556658</returnTime>" +
                "            <invtNo>29242020I439440284</invtNo>" +
                "            <taxNo>29242020I439440284_0</taxNo>" +
                "            <customsTax>0.0</customsTax>" +
                "            <valueAddedTax>37.31</valueAddedTax>" +
                "            <consumptionTax>0.0</consumptionTax>" +
                "            <status>1</status>" +
                "            <entDutyNo></entDutyNo>" +
                "            <note></note>" +
                "            <assureCode>330766K00Q</assureCode>" +
                "            <ebcCode>4401962010</ebcCode>" +
                "            <logisticsCode>11089609XE</logisticsCode>" +
                "            <agentCode>330766K00Q</agentCode>" +
                "            <customsCode>2924</customsCode>" +
                "            <orderNo>124183351885</orderNo>" +
                "            <logisticsNo>JD0018734413066</logisticsNo>" +
                "        </TaxHeadRd>" +
                "        <TaxListRd>" +
                "            <gnum>1</gnum>" +
                "            <gcode>2201101000</gcode>" +
                "            <taxPrice>410.0</taxPrice>" +
                "            <customsTax>0.0</customsTax>" +
                "            <valueAddedTax>37.31</valueAddedTax>" +
                "            <consumptionTax>0.0</consumptionTax>" +
                "        </TaxListRd>" +
                "    </Tax>" +
                "</CEB816Message>";
        return data;
    }

}
