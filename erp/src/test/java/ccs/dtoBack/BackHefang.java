package ccs.dtoBack;

import ccs.Data;
import ccs.dto.Param;
import utils.client.ApiClient;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 核放单回执
 * @Date : Created in 2020/8/10 9:40
 */
public class BackHefang {
    static String data = null;

    // 审核通过
    public static void backExaminePass(String etpsPreentNo,String businessId,String time) {
        backExamine(etpsPreentNo,businessId,1,1,time);
    }

    // 退单
    public static void backQuit(String etpsPreentNo, String businessId, String time) {
        backExamine(etpsPreentNo,businessId,1,3,time);
    }

    /**
     * 核放单审核回执
     * @param etpsPreentNo  预录入核放单号
     * @param businessId  核放单号
     * @param typecd  1-备案;3-作废
     * @param manageResult  1-通过;3-退单
     * @throws IOException
     */
    static void backExamine(String etpsPreentNo,String businessId, int typecd, int manageResult,String time) {
        data = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
                "<Package>" +
                "<EnvelopInfo>" +
                "<version>1.0</version>" +
                "<message_id>CUS0000E0100002020072317184300192160781</message_id>" +
                "<file_name>CUS0000E0100002020072317184300192160781.SAS</file_name>" +
                "<message_type>SAS221</message_type>" +
                "<sender_id>CUS0000</sender_id>" +
                "<receiver_id>E010000</receiver_id>" +
                "<send_time>"+time+"</send_time>" +
                "</EnvelopInfo>" +
                "<DataInfo>" +
                "<PocketInfo>" +
                "<pocket_id>Z2924I200723000000000071-c3073600380541bf9cadb20a994a4618</pocket_id>" +
                "<total_pocket_qty>1</total_pocket_qty>" +
                "<cur_pocket_no>1</cur_pocket_no>" +
                "<is_unstructured/>" +
                "</PocketInfo>" +
                "<BussinessData>" +
                "<SAS221>" +
                "<HdeApprResult>" +
                "<etpsPreentNo>"+etpsPreentNo+"</etpsPreentNo>" +
                "<businessId>"+businessId+"</businessId>" +
                "<tmsCnt>0</tmsCnt>" +
                "<typecd>"+typecd+"</typecd>" +
                "<manageResult>"+manageResult+"</manageResult>" +
                "<manageDate>"+time+"</manageDate>" +
                "<rmk/>" +
                "</HdeApprResult>" +
                "<SasPassportBsc>" +
                "<passportNo>Z2924I200723000000000071</passportNo>" +
                "<chgTmsCnt>0</chgTmsCnt>" +
                "<passportTypecd>6</passportTypecd>" +
                "<sasPassportPreentNo>202000000021252028</sasPassportPreentNo>" +
                "<dclTypecd>1</dclTypecd>" +
                "<ioTypecd>I</ioTypecd>" +
                "<bindTypecd/>" +
                "<masterCuscd>2924</masterCuscd>" +
                "<rltTbTypecd/>" +
                "<rltNo/>" +
                "<areainEtpsno>330766K00W</areainEtpsno>" +
                "<areainEtpsNm>金华凡尔纳供应链管理有限公司</areainEtpsNm>" +
                "<areainEtpsSccd>91330703MA2EEG4GX8</areainEtpsSccd>" +
                "<vehicleNo>沪B2U213</vehicleNo>" +
                "<vehicleIcNo/>" +
                "<containerNo/>" +
                "<vehicleWt>3240</vehicleWt>" +
                "<vehicleFrameNo>1</vehicleFrameNo>" +
                "<vehicleFrameWt>50</vehicleFrameWt>" +
                "<containerType/>" +
                "<containerWt/>" +
                "<totalWt>3290</totalWt>" +
                "<passCollectWt/>" +
                "<wtError/>" +
                "<totalGrossWt>0</totalGrossWt>" +
                "<totalNetWt>0</totalNetWt>" +
                "<dclErConc>沈辉</dclErConc>" +
                "<dclTime>"+time+"</dclTime>" +
                "<passID/>" +
                "<secdPassId/>" +
                "<passTime/>" +
                "<secdPassTime/>" +
                "<stucd>1</stucd>" +
                "<emapvMarkcd>1</emapvMarkcd>" +
                "<logisticsStucd/>" +
                "<ownerSystem>1</ownerSystem>" +
                "<rmk/>" +
                "<col1/>" +
                "</SasPassportBsc>" +
                "</SAS221>" +
                "</BussinessData>" +
                "</DataInfo>" +
                "</Package>";
        ApiClient.doPostForm(Data.URL_BACKMOCK,null,null,new Param(data));
    }

    // 核放单过卡回执
    public static void backCheckPass(String etpsPreentNo,String businessId,String time) {
        data = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<Package>" +
                "<EnvelopInfo>" +
                "<version>1.0</version>" +
                "<message_id>CUS0000E0100002020061120342600173579533</message_id>" +
                "<file_name>CUS0000E0100002020061120342600173579533.SAS</file_name>" +
                "<message_type>SAS223</message_type>" +
                "<sender_id>CUS0000</sender_id>" +
                "<receiver_id>E010000</receiver_id>" +
                "<send_time>"+time+"</send_time>" +
                "</EnvelopInfo>" +
                "<DataInfo>" +
                "<PocketInfo>" +
                "<pocket_id>Z2924E200611000000000099-5b2b3bee02fc4c8c8928574ac7ff6796</pocket_id>" +
                "<total_pocket_qty>1</total_pocket_qty>" +
                "<cur_pocket_no>1</cur_pocket_no>" +
                "<is_unstructured/>" +
                "</PocketInfo>" +
                "<BussinessData>" +
                "<SAS223>" +
                "<HdeApprResult>" +
                "<etpsPreentNo>"+etpsPreentNo+"</etpsPreentNo>" +
                "<businessId>"+businessId+"</businessId>" +
                "<tmsCnt>0</tmsCnt>" +
                "<typecd/>" +
                "<manageResult>1</manageResult>" +
                "<manageDate>"+time+"</manageDate>" +
                "<rmk/>" +
                "</HdeApprResult>" +
                "<SasPassportBsc>" +
                "<passportNo>Z2924E200611000000000099</passportNo>" +
                "<chgTmsCnt>0</chgTmsCnt>" +
                "<passportTypecd>3</passportTypecd>" +
                "<sasPassportPreentNo>202000000019456378</sasPassportPreentNo>" +
                "<dclTypecd>1</dclTypecd>" +
                "<ioTypecd>E</ioTypecd>" +
                "<bindTypecd>2</bindTypecd>" +
                "<masterCuscd>2924</masterCuscd>" +
                "<rltTbTypecd>1</rltTbTypecd>" +
                "<rltNo>QD292420E000005132</rltNo>" +
                "<areainEtpsno>330766K00Q</areainEtpsno>" +
                "<areainEtpsNm>金华垂直云供应链管理有限公司</areainEtpsNm>" +
                "<areainEtpsSccd>91330703MA2E91U81Q</areainEtpsSccd>" +
                "<vehicleNo>沪BZU213</vehicleNo>" +
                "<vehicleIcNo/>" +
                "<containerNo/>" +
                "<vehicleWt>3240</vehicleWt>" +
                "<vehicleFrameNo>1</vehicleFrameNo>" +
                "<vehicleFrameWt>50</vehicleFrameWt>" +
                "<containerType/>" +
                "<containerWt/>" +
                "<totalWt>3240.013</totalWt>" +
                "<passCollectWt>3553</passCollectWt>" +
                "<wtError>-312.987</wtError>" +
                "<totalGrossWt>0.013</totalGrossWt>" +
                "<totalNetWt>0.013</totalNetWt>" +
                "<dclErConc>林婷婷</dclErConc>" +
                "<dclTime>"+time+"</dclTime>" +
                "<passID/>" +
                "<secdPassId>2924210209</secdPassId>" +
                "<passTime>"+time+"</passTime>" +
                "<secdPassTime>"+time+"</secdPassTime>" +
                "<stucd>4</stucd>" +
                "<emapvMarkcd>1</emapvMarkcd>" +
                "<logisticsStucd>1</logisticsStucd>" +
                "<ownerSystem>1</ownerSystem>" +
                "<rmk/>" +
                "<col1/>" +
                "</SasPassportBsc>" +
                "</SAS223>" +
                "</BussinessData>" +
                "</DataInfo>" +
                "</Package>";
        ApiClient.doPostForm(Data.URL_BACKMOCK,null,null,new Param(data));
    }
}
