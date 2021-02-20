package ccs.dtoBack;
import ccs.dto.Param;
import ccs.Data;
import utils.client.ApiClient;
import utils.database.CcsOrder;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 清单回执报文，未完成
 * 税费回执：只校验清单编号，其他信息随意填；其他回执必须填写完整正确的企业编号和订单清单信息。
 * @Date : Created in 2020/7/20 13:11
 */
public class BackQingdanZongshu {
    static String data = null;

    public static void backLogic(String orderNo, String ebpCode, String ebcCode, String agentCode, String invtNo, String returntime){
        modelData(orderNo,ebpCode,ebcCode,agentCode,invtNo,"120","[Code:1800;Desc:逻辑校验通过]",returntime);
    }
    public static void backAddOk(String orderNo, String ebpCode, String ebcCode, String agentCode, String invtNo, String returntime){
        modelData(orderNo,ebpCode,ebcCode,agentCode,invtNo,"2","清单新增申报成功",returntime);
    }
    public static void backPass(String orderNo,String ebpCode,String ebcCode,String agentCode,String invtNo,String returntime) {
        modelData(orderNo,ebpCode,ebcCode,agentCode,invtNo,"800","[Code:2600;Desc:放行]",returntime);
    }

    // 不常用的回执节点
    public static void backExamine(String orderno, String ebpCode, String ebcCode,String agentCode,String invtNo, String returnTime) {
        modelData(orderno,ebpCode,ebcCode,agentCode,invtNo,"399","海关审结",returnTime);
    }
    public static void backCheck(String orderno, String ebpCode, String ebcCode,String agentCode,String invtNo, String returnTime) {
        modelData(orderno,ebpCode,ebcCode,agentCode,invtNo,"500","查验",returnTime);
    }
    public static void backSuspend(String orderno, String ebpCode, String ebcCode,String agentCode,String invtNo, String returnTime) {
        modelData(orderno,ebpCode,ebcCode,agentCode,invtNo,"600","挂起",returnTime);
    }
    public static void backReturn(String orderno, String ebpCode, String ebcCode,String agentCode,String invtNo, String returnTime) {
        modelData(orderno,ebpCode,ebcCode,agentCode,invtNo,"700","退运",returnTime);
    }

    // 申报失败的回执
    public static void errorLimit(String orderNo,String ebpCode,String ebcCode,String agentCode,String invtNo,String returntime) {
        modelData(orderNo,ebpCode,ebcCode,agentCode,invtNo,"100","[Code:1313;Desc:订购人购买超过年度限额,超过个人年度购买额度]",returntime);
    }
    public static void errorItem(String orderno, String ebpCode, String ebcCode,String agentCode,String invtNo, String returnTime) {
        modelData(orderno,ebpCode,ebcCode,agentCode,invtNo,"100","[Code:1322;Desc:订单清单表体商品项不一致]",returnTime);
    }

    /**
     * 清单申报--回执模板
     * @param declareOrderNo 传入申报单编号
     * @param ebcCode 电商企业编码
     * @param ebpCode 电商平台编码
     * @param agentCode 清关企业代码
     * @param invtNo 清单编号
     * @param returnStatus 报文状态
     * @param returnInfo 报文信息
     * @param returntime 海关回执时间
     * @throws IOException
     */
    public static void modelData(String declareOrderNo, String ebpCode, String ebcCode, String agentCode, String invtNo, String returnStatus, String returnInfo, String returntime) {
        String orderSn = CcsOrder.getOrderSn(declareOrderNo);
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB622Message" +
                "    xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"c988cb9e-ea4b-463a-87c4-36e3d24aa7d9\">" +
                "    <InventoryReturn>" +
                "        <guid>f5885dd5-b765-41de-8f0f-e5a30592885c</guid>" +
                "        <customsCode>2924</customsCode>" +
                "        <ebpCode>"+ebpCode+"</ebpCode>" +
                "        <ebcCode>"+ebcCode+"</ebcCode>" +
                "        <agentCode>"+agentCode+"</agentCode>" +
                "        <copNo>"+orderSn+"</copNo>" +
                "        <preNo>B20200615494000227</preNo>" +
                "        <invtNo>"+invtNo+"</invtNo>" +
                "        <returnStatus>"+returnStatus+"</returnStatus>" +
                "        <returnTime>"+returntime+"</returnTime>" +
                "        <returnInfo>"+returnInfo+"</returnInfo>" +
                "    </InventoryReturn>" +
                "</CEB622Message>";
        ApiClient.doPostForm(Data.URL_BACK,null,null,new Param(data));
    }

}
