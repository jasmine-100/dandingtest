package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description : 订单申报回执类
 * @Date : Created in 2020/7/20 17:48
 */
@Data
public class DeclareBack {
    private String oriStr;

    public DeclareBack(String orderno) {
        this.oriStr = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
                "<CEB312Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"C49D69D2-2544-4C8F-96E6-F82C65C1CA0C\">" +
                "<OrderReturn><guid>4f2011fc-4ed0-478c-b190-22e76ef8b78a</guid><ebpCode>33169667BG</ebpCode><ebcCode>3301964J31</ebcCode>" +
                "<orderNo>"+orderno+"</orderNo><returnStatus>2</returnStatus><returnTime>20191112143633776</returnTime>" +
                "<returnInfo>新增申报成功[8F49799F-EA6F-4E03-87FC-6123DBF163F2]</returnInfo></OrderReturn></CEB312Message>";
    }
}
