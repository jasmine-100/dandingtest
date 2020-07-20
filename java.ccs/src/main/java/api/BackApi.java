package api;

import client.ApiClient;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 清单回执报文
 * @Date : Created in 2020/7/20 13:11
 */
public class BackApi {
    static String url = "http://ccs.backend.daily.yang800.com/xhr/order/mockReceive";

    //总署回执：逻辑校验通过
    public static void backVertifyPass(String orderNo) throws IOException {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB622Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"c988cb9e-ea4b-463a-87c4-36e3d24aa7d9\">" +
                "    <InventoryReturn>" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>" +
                "        <customsCode>2924</customsCode>" +
                "        <ebpCode>4401962010</ebpCode>" +
                "        <ebcCode>4401962010</ebcCode>" +
                "        <agentCode>330766K00Q</agentCode>" +
                "        <copNo>"+orderNo+"</copNo>" +
                "        <preNo>B"+System.currentTimeMillis()+"</preNo>" +
                "        <invtNo>QD"+System.currentTimeMillis()+"</invtNo>" +
                "        <returnStatus>120</returnStatus>" +
                "        <returnTime>"+System.currentTimeMillis()+"</returnTime>" +
                "        <returnInfo>[Code:1800;Desc:逻辑校验通过]</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";

    }

    //总署回执：新增校验成功
    public void backDeclareSuccess(String orderNo){
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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

    }

    //总署回执：放行
    public void backPass(String orderNo){
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
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

    }

    //总署回执：税费
    public void backTaxrd(String orderNo){

    }

    //口岸回执
    public void backDealSuccess(){

    }
}
