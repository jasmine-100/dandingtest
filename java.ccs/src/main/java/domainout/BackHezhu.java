package domainout;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domain.Hezhu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 核注清单审核回执报文
 * @Date : Created in 2020/8/7 17:46
 */
public class BackHezhu {
    static String url = "http://ccs.fen.daily.yang800.com/zjport/mock/manCallback";
    static String data = null;

    // 未核扣、审核通过
    public static void backHezhuPass(String etpsInnerInvtNo,String invtPreentNo,String bondInvtNo) throws IOException {
        function(etpsInnerInvtNo,invtPreentNo,bondInvtNo,"0","0");
    }

    // 已核扣、审核通过
    public static void backHezhuSuccess(String etpsInnerInvtNo,String invtPreentNo,String bondInvtNo) throws IOException {
        function(etpsInnerInvtNo,invtPreentNo,bondInvtNo,"2","0");
    }

    /**
     *
     * @param etpsInnerInvtNo 企业内部编码
     * @param invtPreentNo 预录入核注编号
     * @param bondInvtNo 核注清单编号
     * @param vrfdedMarkcd 0-未核扣，2-已核扣
     * @param invtStucd 2-退单;0-审核通过
     * @throws IOException
     */
    static void function(String etpsInnerInvtNo,String invtPreentNo,String bondInvtNo,String vrfdedMarkcd,String invtStucd) throws IOException {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        data = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
                "<Package xmlns=\"http://www.w3.org/2000/09/xmldsig#\">" +
                    "<EnvelopInfo>" +
                        "<version>1.0</version>" +
                        "<message_id>CUS0000E0100002020072314112100191970800</message_id>" +
                        "<file_name>CUS0000E0100002020072314112100191970800.INV</file_name>" +
                        "<message_type>INV201</message_type>" +
                        "<sender_id>CUS0000</sender_id>" +
                        "<receiver_id>E010000</receiver_id>" +
                    "</EnvelopInfo>" +
                    "<DataInfo>" +
                        "<PocketInfo>" +
                            "<pocket_id>QD292420E000007507-fe9e0d13c89147109006428ec9322af3</pocket_id>" +
                            "<total_pocket_qty>1</total_pocket_qty>" +
                            "<cur_pocket_no>1</cur_pocket_no>" +
                            "<is_unstructured/>" +
                        "</PocketInfo>" +
                        "<BussinessData>" +
                            "<INV201>" +
                                "<HdeApprResult>" +
                                    "<etpsPreentNo>202000000027463338</etpsPreentNo>" +
                                    "<businessId>QD292420E000007507</businessId>" +
                                    "<tmsCnt>0</tmsCnt>" +
                                    "<typecd>1</typecd>" +
                                    "<manageResult>5</manageResult>" +
                                    "<manageDate>"+date+"</manageDate>" +
                                    "<rmk/>" +
                                "</HdeApprResult>" +
                                "<BondInvtBsc>" +
                                    "<bondInvtNo>"+bondInvtNo+"</bondInvtNo>" +
                                    "<chgTmsCnt>0</chgTmsCnt>" +
                                    "<invtPreentNo>"+invtPreentNo+"</invtPreentNo>" +
                                    "<putrecNo>T2924W000088</putrecNo>" +
                                    "<etpsInnerInvtNo>"+etpsInnerInvtNo+"</etpsInnerInvtNo>" +
                                    "<bizopEtpsSccd>91330703MA2EEG4GX8</bizopEtpsSccd>" +
                                    "<bizopEtpsno>330766K00W</bizopEtpsno>" +
                                    "<bizopEtpsNm>金华凡尔纳供应链管理有限公司</bizopEtpsNm>" +
                                    "<rvsngdEtpsSccd>91330703MA2EEG4GX8</rvsngdEtpsSccd>" +
                                    "<rcvgdEtpsno>330766K00W</rcvgdEtpsno>" +
                                    "<rcvgdEtpsNm>金华凡尔纳供应链管理有限公司</rcvgdEtpsNm>" +
                                    "<dclEtpsSccd>91330703MA2EEG4GX8</dclEtpsSccd>" +
                                    "<dclEtpsno>330766K00W</dclEtpsno>" +
                                    "<dclEtpsNm>金华凡尔纳供应链管理有限公司</dclEtpsNm>" +
                                    "<invtDclTime>"+date+"</invtDclTime>" +
                                    "<entryDclTime/>" +
                                    "<entryNo/>" +
                                    "<rltInvtNo/>" +
                                    "<rltPutrecNo/>" +
                                    "<rltEntryNo/>" +
                                    "<rltEntryBizopEtpsSccd/>" +
                                    "<rltEntryBizopEtpsno/>" +
                                    "<rltEntryBizopEtpsNm/>" +
                                    "<impexpPortcd>2924</impexpPortcd>" +
                                    "<dclPlcCuscd>2924</dclPlcCuscd>" +
                                    "<impexpMarkcd>E</impexpMarkcd>" +
                                    "<mtpckEndprdMarkcd>I</mtpckEndprdMarkcd>" +
                                    "<supvModecd>5000</supvModecd>" +
                                    "<trspModecd>9</trspModecd>" +
                                    "<stshipTrsarvNatcd>142</stshipTrsarvNatcd>" +
                                    "<applyNo/>" +
                                    "<dclcusFlag>2</dclcusFlag>" +
                                    "<dclcusTypecd/>" +
                                    "<prevdTime/>" +
                                    "<formalVrfdedTime/>" +
                                    "<invtIochkptStucd>0</invtIochkptStucd>" +
                                    "<vrfdedMarkcd>"+vrfdedMarkcd+"</vrfdedMarkcd>" +
                                    "<invtStucd>"+invtStucd+"</invtStucd>" +
                                    "<vrfdedModecd/>" +
                                    "<duCode/>" +
                                    "<rmk/>" +
                                    "<bondInvtTypecd>8</bondInvtTypecd>" +
                                    "<entryStucd>0</entryStucd>" +
                                    "<passportUsedTypecd>1</passportUsedTypecd>" +
                                    "<param1/>" +
                                    "<param2/>" +
                                    "<param3/>" +
                                    "<param4/>" +
                                    "<needEntryModified/>" +
                                    "<levyBlAmt/>" +
                                    "<dclTypecd>1</dclTypecd>" +
                                "</BondInvtBsc>" +
                                "<BondInvtDt>" +
                                    "<bondInvtNo>"+bondInvtNo+"</bondInvtNo>" +
                                    "<chgTmsCnt>0</chgTmsCnt>" +
                                    "<gdsSeqno>1</gdsSeqno>" +
                                    "<putrecSeqno>6</putrecSeqno>" +
                                    "<gdsMtno>JHYB4520060250000</gdsMtno>" +
                                    "<gdecd>3304990029</gdecd>" +
                                    "<gdsNm>BBLABORATORIES/复活草面膜175G/盒</gdsNm>" +
                                    "<gdsSpcfModelDesc>BBLABORATORIES/复活草面膜175G/盒</gdsSpcfModelDesc>" +
                                    "<dclUnitcd>140</dclUnitcd>" +
                                    "<lawfUnitcd>035</lawfUnitcd>" +
                                    "<secdLawfUnitcd>011</secdLawfUnitcd>" +
                                    "<natcd>116</natcd>" +
                                    "<dclUprcAmt>120</dclUprcAmt>" +
                                    "<dclTotalAmt>720</dclTotalAmt>" +
                                    "<usdStatTotalAmt>101.70216</usdStatTotalAmt>" +
                                    "<dclCurrcd>142</dclCurrcd>" +
                                    "<lawfQty>1.05</lawfQty>" +
                                    "<secdLawfQty>6</secdLawfQty>" +
                                    "<wtSfVal/>" +
                                    "<fstSfVal/>" +
                                    "<secdSfVal/>" +
                                    "<dclQty>6</dclQty>" +
                                    "<grossWt/>" +
                                    "<netWt/>" +
                                    "<lvyrlfModecd>3</lvyrlfModecd>" +
                                    "<ucnsVerno/>" +
                                    "<entryGdsSeqno/>" +
                                    "<applyTbSeqno/>" +
                                    "<clyMarkcd/>" +
                                    "<rmk/>" +
                                    "<actlPassQty>0</actlPassQty>" +
                                    "<passportUsedQty>0</passportUsedQty>" +
                                    "<param1/>" +
                                    "<param2/>" +
                                    "<param3/>" +
                                    "<param4/>" +
                                    "<destinationNatcd>142</destinationNatcd>" +
                                    "<modfMarkcd>3</modfMarkcd>" +
                                "</BondInvtDt>" +
                            "</INV201>" +
                        "</BussinessData>" +
                    "</DataInfo>" +
                "</Package>";
        new ApiClient(url).doPostForm(new Hezhu(data));
    }

}
