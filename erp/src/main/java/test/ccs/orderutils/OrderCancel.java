package test.ccs.orderutils;

/**
 * @Author： jasmine
 * @Description : 未完成
 * @Date : Created in 2020/8/4 13:28
 */
public class OrderCancel {
 static String data;

public static String createOrder(){
data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
"<ceb:CEB623Message guid=\"9EFDC2DF-014E-4D77-ADAB-E14C73B2E2A8\" version=\"1.0\" " +
"xmlns:ceb=\"http://www.chinaport.gov.cn/ceb\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" +
"<ceb:InvtCancel>" +
            "<ceb:guid>9EFDC2DF-014E-4D77-ADAB-E14C73B2E2A8</ceb:guid>" +
                "<ceb:appType>1</ceb:appType>" +
                "<ceb:appTime>20200629134101</ceb:appTime>" +
                "<ceb:appStatus>2</ceb:appStatus>" +
                "<ceb:customsCode>2924</ceb:customsCode>" +
                "<ceb:orderNo>124489829575</ceb:orderNo>" +
                "<ceb:ebpCode>4401962010</ceb:ebpCode>" +
                "<ceb:ebpName>广州晶东贸易有限公司</ceb:ebpName>" +
                "<ceb:ebcCode>4401962010</ceb:ebcCode><ceb:ebcName>广州晶东贸易有限公司</ceb:ebcName>" +
                "<ceb:logisticsNo>JD0019134788055</ceb:logisticsNo><ceb:logisticsCode>11089609XE</ceb:logisticsCode>" +
                "<ceb:logisticsName>北京京邦达贸易有限公司</ceb:logisticsName>" +
                "<ceb:copNo>124489829575</ceb:copNo>" +
                "<ceb:invtNo>29242020I462713642</ceb:invtNo>" +
                "<ceb:buyerIdType>1</ceb:buyerIdType>" +
                "<ceb:buyerIdNumber>130421198803032436</ceb:buyerIdNumber>" +
                "<ceb:buyerName>陈蒙</ceb:buyerName><ceb:buyerTelephone>15188804321</ceb:buyerTelephone>" +
                "<ceb:agentCode>330766K00Q</ceb:agentCode><ceb:agentName>金华垂直云供应链管理有限公司</ceb:agentName>" +
                "<ceb:reason>交易订单取消,买家申请退款</ceb:reason>" +
                "</ceb:InvtCancel><ceb:BaseTransfer><ceb:copCode>330766K00Q</ceb:copCode>" +
                "<ceb:copName>金华垂直云供应链管理有限公司</ceb:copName><ceb:dxpMode>DXP</ceb:dxpMode>" +
                "<ceb:dxpId>DXPENT0000025678</ceb:dxpId></ceb:BaseTransfer></ceb:CEB623Message>";
        return data;
    }

}
