package domain;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 17:51
 */
@Data
public class ListBack {
    private String sign;
    private String partnerId;
    private String serviceVersion;
    private String serviceType;
    private String bizData;

    public ListBack(String orderno) {
        this.sign = "091443acea0d1b927859fa4b0420ab43";
        this.partnerId = "test001";
        this.serviceVersion = "1.0";
        this.serviceType = "wms.qgreceipt.update";
        this.bizData = "<wmsRequestRoot><BillId>RELDLT20021816212829</BillId><SyncBillId>"+orderno+"</SyncBillId>" +
                "<HZID>PDDLT</HZID><WarehouseCode>KJC</WarehouseCode><CompanyCode>123456</CompanyCode><BusinessNo>341920021816212829</BusinessNo>" +
                "<ChkMark>800</ChkMark><NoticeTime>20200310120000000</NoticeTime><ResultInfo>[Code:2600;Desc:放行]</ResultInfo>";
    }
}
