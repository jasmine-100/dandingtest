package domainout;

import client.ApiClient;
import dao.Data;
import orderutils.Param;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 海关订单申报--总署回执报文
 * @Date : Created in 2020/8/4 15:36
 */
public class BackDingdanZongshu {
    static String data = null;

    // 总署回执：正常的回执
    public static void declareAddOk(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        modelZongshu(orderno, ebpCode, ebcCode, "2", "新增申报成功", returnTime);
    }
    public static void logicOk(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        modelZongshu(orderno, ebpCode, ebcCode, "120", "[Code:1800;Desc:逻辑校验通过]", returnTime);
    }

    // 申报失败的回执
    public static void errorID(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        modelZongshu(orderno, ebpCode, ebcCode, "99", "订单中的订购人姓名和身份证不匹配", returnTime);
    }
    public static void errorPayer(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        modelZongshu(orderno, ebpCode, ebcCode, "100", "[Code:13127;Desc:清单上的订购人姓名与订单上的订购人姓名不一致]", returnTime);
    }
    public static void errorItem(String orderno, String ebpCode, String ebcCode, String returnTime) throws IOException {
        modelZongshu(orderno,ebpCode,ebcCode,"100","[Code:1320;Desc:清单表体商品项与订单表体商品项的项数不一致]",returnTime);
    }

    /**
     * 订单申报--回执模板
     *
     * @param orderno      传入申报单编号
     * @param ebpCode      电商平台编码
     * @param ebcCode      电商企业编码
     * @param returnStatus 报文状态
     * @param returnInfo   报文信息
     * @param returnTime   海关回执时间
     * @throws IOException
     */
    public static void modelZongshu(String orderno, String ebpCode, String ebcCode, String returnStatus, String returnInfo, String returnTime) throws IOException {
        data = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<CEB312Message xmlns=\"http://www.chinaport.gov.cn/ceb\" version=\"1.0\" guid=\"479237c3-ec79-4d05-bced-3f3299e64c57\">" +
                "    <OrderReturn>" +
                "        <guid>5f872141-8cbb-4537-9867-787071afaa72</guid>" +
                "        <ebpCode>" + ebpCode + "</ebpCode>" +
                "        <ebcCode>" + ebcCode + "</ebcCode>" +
                "        <orderNo>" + orderno + "</orderNo>" +
                "        <returnStatus>" + returnStatus + "</returnStatus>" +
                "        <returnTime>" + returnTime + "</returnTime>" +
                "        <returnInfo>" + returnInfo + "</returnInfo>" +
                "    </OrderReturn>" +
                "</CEB312Message>";
        new ApiClient(Data.URL_BACK).doPostForm(new Param(data));
    }
}
