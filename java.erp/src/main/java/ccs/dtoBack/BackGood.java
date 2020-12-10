package ccs.dtoBack;

import ccs.Data;
import ccs.dto.GoodWare;
import ccs.dto.Param;
import client.ApiClient;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/24 15:10
 */
public class BackGood {

    /**
     *
     * @param bookId 账册编号
     * @param goodWare 仓库商品
     * @param hscode hs编码
     * @throws IOException
     */
    public static void backAddGood(String bookId, GoodWare goodWare, String hscode) throws IOException {
        String data = "<?xml version=\"1.0\" encoding=\"gb2312\"?>" +
                "<Package xmlns=\"http://www.w3.org/2000/09/xmldsig#\">" +
                    "<EnvelopInfo>" +
                        "<version>1.0</version>" +
                        "<message_id>CUS0000E0100002020072210123800191227428</message_id>" +
                        "<file_name>CUS0000E0100002020072210123800191227428.INV</file_name>" +
                        "<message_type>INV211</message_type>" +
                        "<sender_id>CUS0000</sender_id>" +
                        "<receiver_id>E010000</receiver_id>" +
                    "</EnvelopInfo>" +
                    "<DataInfo>" +
                        "<PocketInfo>" +
                            "<pocket_id>QD292420I000003674-c13f712f6bb249ccad05f70781ae16f8</pocket_id>" +
                            "<total_pocket_qty>1</total_pocket_qty>" +
                            "<cur_pocket_no>1</cur_pocket_no>" +
                            "<is_unstructured/>" +
                        "</PocketInfo>" +
                        "<BussinessData>" +
                            "<INV211>" +
                                "<BondInvtBsc>" +
                                    "<bondInvtNo>QD292420I000003674</bondInvtNo>" +
                                    "<chgTmsCnt>0</chgTmsCnt>" +
                                    "<invtPreentNo>202000000027097128</invtPreentNo>" +
                                    "<putrecNo>T2924W000088</putrecNo>" +
                                    "<etpsInnerInvtNo/>" +
                                    "<bizopEtpsSccd>91330703MA2EEG4GX8</bizopEtpsSccd>" +
                                    "<bizopEtpsno>330766K00W</bizopEtpsno>" +
                                    "<bizopEtpsNm>金华凡尔纳供应链管理有限公司</bizopEtpsNm>" +
                                    "<rvsngdEtpsSccd/>" +
                                    "<rcvgdEtpsno>330766K00W</rcvgdEtpsno>" +
                                    "<rcvgdEtpsNm>金华凡尔纳供应链管理有限公司</rcvgdEtpsNm>" +
                                    "<dclEtpsSccd>91330703MA2EEG4GX8</dclEtpsSccd>" +
                                    "<dclEtpsno>330766K00W</dclEtpsno>" +
                                    "<dclEtpsNm>金华凡尔纳供应链管理有限公司</dclEtpsNm>" +
                                    "<invtDclTime>2020-07-20 00:00:00</invtDclTime>" +
                                    "<entryDclTime/>" +
                                    "<entryNo/>" +
                                    "<rltInvtNo>QD520820E000139309</rltInvtNo>" +
                                    "<rltPutrecNo>T5208W000150</rltPutrecNo>" +
                                    "<rltEntryNo/>" +
                                    "<rltEntryBizopEtpsSccd/>" +
                                    "<rltEntryBizopEtpsno/>" +
                                    "<rltEntryBizopEtpsNm/>" +
                                    "<impexpPortcd>5208</impexpPortcd>" +
                                    "<dclPlcCuscd>2924</dclPlcCuscd>" +
                                    "<impexpMarkcd>I</impexpMarkcd>" +
                                    "<mtpckEndprdMarkcd>I</mtpckEndprdMarkcd>" +
                                    "<supvModecd>1200</supvModecd>" +
                                    "<trspModecd>9</trspModecd>" +
                                    "<stshipTrsarvNatcd>142</stshipTrsarvNatcd>" +
                                    "<applyNo/>" +
                                    "<dclcusFlag>2</dclcusFlag>" +
                                    "<dclcusTypecd/>" +
                                    "<prevdTime/>" +
                                    "<formalVrfdedTime>2020-07-22 10:12:32</formalVrfdedTime>" +
                                    "<invtIochkptStucd>3</invtIochkptStucd>" +
                                    "<vrfdedMarkcd>2</vrfdedMarkcd>" +
                                    "<invtStucd>0</invtStucd>" +
                                    "<vrfdedModecd>D</vrfdedModecd>" +
                                    "<duCode>O1</duCode>" +
                                    "<rmk/>" +
                                    "<bondInvtTypecd>0</bondInvtTypecd>" +
                                    "<entryStucd>0</entryStucd>" +
                                    "<passportUsedTypecd>3</passportUsedTypecd>" +
                                    "<param1/>" +
                                    "<param2/>" +
                                    "<param3/>" +
                                    "<param4/>" +
                                    "<needEntryModified/>" +
                                    "<levyBlAmt>0</levyBlAmt>" +
                                    "<dclTypecd>1</dclTypecd>" +
                                "</BondInvtBsc>" +
                                "<BwsDt>" +
                                    "<bwsNo>"+bookId+"</bwsNo>" +
                                    "<chgTmsCnt>0</chgTmsCnt>" +
                                    "<gdsSeqno>773</gdsSeqno>" +
                                    "<inDate>2020-07-22 10:12:32</inDate>" +
                                    "<gdsMtno>"+goodWare.getSkuSn()+"</gdsMtno>" +
                                    "<gdecd>"+hscode+"</gdecd>" +
                                    "<gdsNm>"+goodWare.getSkuName()+"</gdsNm>" +
                                    "<gdsSpcfModelDesc>60片/瓶</gdsSpcfModelDesc>" +
                                    "<natcd>601</natcd>" +
                                    "<dclUnitcd>142</dclUnitcd>" +
                                    "<lawfUnitcd>035</lawfUnitcd>" +
                                    "<secdLawfUnitcd/>" +
                                    "<dclUprcAmt>42.55</dclUprcAmt>" +
                                    "<dclCurrcd>142</dclCurrcd>" +
                                    "<avgPrice>6.01032</avgPrice>" +
                                    "<totalAmt>12657.72371</totalAmt>" +
                                    "<inQty>2106</inQty>" +
                                    "<inLawfQty>320.112</inLawfQty>" +
                                    "<inSecdLawfQty/>" +
                                    "<actlIncQty/>" +
                                    "<actlRedcQty/>" +
                                    "<prevdIncQty/>" +
                                    "<prevdRedcQty/>" +
                                    "<outDate/>" +
                                    "<limitDate/>" +
                                    "<inType/>" +
                                    "<invtNo>QD292420I000003674</invtNo>" +
                                    "<invtGNo>2</invtGNo>" +
                                    "<cusmExeMarkcd>1</cusmExeMarkcd>" +
                                    "<rmk/>" +
                                    "<modfMarkcd>3</modfMarkcd>" +
                                "</BwsDt>" +
                            "</INV211>" +
                        "</BussinessData>" +
                    "</DataInfo>" +
                "</Package>";
//        new ApiClient(BaseParam.URL_BACKMOCK).doPostForm(new Param2(data));
        ApiClient.doPostForm(Data.URL_BACKMOCK,null,null,new Param(data));
    }
}
