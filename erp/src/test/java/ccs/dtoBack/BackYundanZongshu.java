package ccs.dtoBack;

import ccs.Data;
import ccs.dto.Param;
import utils.client.ApiClient;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/5 14:59
 */
public class BackYundanZongshu {
    static String data = null;

    public static void backLogic(String logisticsNo, String agentCode, String returntime){
        modelData(logisticsNo,agentCode,"120","[Code:1800;Desc:逻辑校验通过]",returntime);
    }
    public static void backAddOk(String logisticsNo, String agentCode, String returntime){
        modelData(logisticsNo,agentCode,"2","清单新增申报成功",returntime);
    }

    public static void modelData(String logisticsNo, String agentCode, String returnStatus, String returnInfo, String returntime) {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB512Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"41d9a7fc-bc48-4ca7-996a-ef5defddf6ff\">" +
                "    <LogisticsReturn>" +
                "        <guid>cf8de39b-f7e3-46ff-8cbb-9b4d5edb278d</guid>" +
                "        <logisticsCode>"+agentCode+"</logisticsCode>" +
                "        <logisticsNo>"+logisticsNo+"</logisticsNo>" +
                "        <returnStatus>"+returnStatus+"</returnStatus>" +
                "        <returnTime>"+returntime+"</returnTime>" +
                "        <returnInfo>"+returnInfo+"</returnInfo>" +
                "    </LogisticsReturn>" +
                "</CEB512Message>";
        ApiClient.doPostForm(Data.URL_BACK,null,null,new Param(data));
    }
}
