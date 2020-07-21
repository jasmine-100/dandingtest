package orderutils;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/21 10:48
 */
@Data
public class BackOrigin {
    private String oriStr;

    public BackOrigin(String orderNo,String desc){
        if ("逻辑校验通过".equals(desc)) {
            this.oriStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<CEB622Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"c988cb9e-ea4b-463a-87c4-36e3d24aa7d9\">" +
                    "<InventoryReturn><guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid><customsCode>2924</customsCode>" +
                    "<ebpCode>4401962010</ebpCode><ebcCode>4401962010</ebcCode><agentCode>330766K00Q</agentCode>" +
                    "<copNo>" + orderNo + "</copNo><preNo>B" + System.currentTimeMillis() + "</preNo><invtNo>QD" + System.currentTimeMillis() + "</invtNo>" +
                    "<returnStatus>120</returnStatus><returnTime>" + System.currentTimeMillis() + "</returnTime><returnInfo>[Code:1800;Desc:逻辑校验通过]</returnInfo>" +
                    "</InventoryReturn></CEB622Message>";
        } else if ("清单新增申报成功".equals(desc)) {
            this.oriStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<CEB622Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"48604738-C342-484F-8CA1-46BCF64098D0\">" +
                    "<InventoryReturn><guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid><customsCode>2924</customsCode>" +
                    "<ebpCode>4401962010</ebpCode><ebcCode>4401962010</ebcCode><agentCode>330766K00Q</agentCode><copNo>124183351885</copNo>" +
                    "<preNo>B20200615494000227</preNo><returnStatus>2</returnStatus><returnTime>20200615171550734</returnTime>" +
                    "<returnInfo>清单新增申报成功[电商企业编码：4401962010订单编号：124183351885]</returnInfo></InventoryReturn></CEB622Message>";
        } else if ("放行".equals(desc)) {
            this.oriStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                    "<CEB622Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"0e24b0c5-8eea-429a-a08b-46a0bad0cabd\">" +
                    "<InventoryReturn><guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid><customsCode>2924</customsCode>" +
                    "<ebpCode>4401962010</ebpCode><ebcCode>4401962010</ebcCode><agentCode>330766K00Q</agentCode><copNo>124183351885</copNo>" +
                    "<preNo>B20200615494000227</preNo><invtNo>29242020I439440284</invtNo><returnStatus>800</returnStatus>" +
                    "<returnTime>20200615171556654</returnTime><returnInfo>[Code:2600;Desc:放行]</returnInfo></InventoryReturn></CEB622Message>";
        }

    }
}
