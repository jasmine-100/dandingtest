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
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<CEB622Message\n" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"48604738-C342-484F-8CA1-46BCF64098D0\">\n" +
                "    <InventoryReturn>\n" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>\n" +
                "        <customsCode>2924</customsCode>\n" +
                "        <ebpCode>4401962010</ebpCode>\n" +
                "        <ebcCode>4401962010</ebcCode>\n" +
                "        <agentCode>330766K00Q</agentCode>\n" +
                "        <copNo>124183351885</copNo>\n" +
                "        <preNo>B20200615494000227</preNo>\n" +
                "        <returnStatus>2</returnStatus>\n" +
                "        <returnTime>20200615171550734</returnTime>\n" +
                "        <returnInfo>清单新增申报成功[电商企业编码：4401962010订单编号：124183351885]</returnInfo>\n" +
                "    </InventoryReturn>\n" +
                "</CEB622Message>";
        return data;
    }

    /**
     * 总署回执--海关放行
     * @return
     */
    public static String orderZongShuBackPass(){
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<CEB622Message\n" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"0e24b0c5-8eea-429a-a08b-46a0bad0cabd\">\n" +
                "    <InventoryReturn>\n" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>\n" +
                "        <customsCode>2924</customsCode>\n" +
                "        <ebpCode>4401962010</ebpCode>\n" +
                "        <ebcCode>4401962010</ebcCode>\n" +
                "        <agentCode>330766K00Q</agentCode>\n" +
                "        <copNo>124183351885</copNo>\n" +
                "        <preNo>B20200615494000227</preNo>\n" +
                "        <invtNo>29242020I439440284</invtNo>\n" +
                "        <returnStatus>800</returnStatus>\n" +
                "        <returnTime>20200615171556654</returnTime>\n" +
                "        <returnInfo>[Code:2600;Desc:放行]</returnInfo>\n" +
                "    </InventoryReturn>\n" +
                "</CEB622Message>";
        return data;
    }

    /**
     * 总署回执--税金
     * @return
     */
    public static String orderZongShuBackTax(){
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<CEB816Message\n" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"e98878cc-48ef-4ce5-968d-dddc3d47a304\">\n" +
                "    <Tax>\n" +
                "        <TaxHeadRd>\n" +
                "            <guid>e98878cc-48ef-4ce5-968d-dddc3d47a304</guid>\n" +
                "            <returnTime>20200615171556658</returnTime>\n" +
                "            <invtNo>29242020I439440284</invtNo>\n" +
                "            <taxNo>29242020I439440284_0</taxNo>\n" +
                "            <customsTax>0.0</customsTax>\n" +
                "            <valueAddedTax>37.31</valueAddedTax>\n" +
                "            <consumptionTax>0.0</consumptionTax>\n" +
                "            <status>1</status>\n" +
                "            <entDutyNo></entDutyNo>\n" +
                "            <note></note>\n" +
                "            <assureCode>330766K00Q</assureCode>\n" +
                "            <ebcCode>4401962010</ebcCode>\n" +
                "            <logisticsCode>11089609XE</logisticsCode>\n" +
                "            <agentCode>330766K00Q</agentCode>\n" +
                "            <customsCode>2924</customsCode>\n" +
                "            <orderNo>124183351885</orderNo>\n" +
                "            <logisticsNo>JD0018734413066</logisticsNo>\n" +
                "        </TaxHeadRd>\n" +
                "        <TaxListRd>\n" +
                "            <gnum>1</gnum>\n" +
                "            <gcode>2201101000</gcode>\n" +
                "            <taxPrice>410.0</taxPrice>\n" +
                "            <customsTax>0.0</customsTax>\n" +
                "            <valueAddedTax>37.31</valueAddedTax>\n" +
                "            <consumptionTax>0.0</consumptionTax>\n" +
                "        </TaxListRd>\n" +
                "    </Tax>\n" +
                "</CEB816Message>";
        return data;
    }

}
