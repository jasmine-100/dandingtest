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

    public ListBack(String orderno,String desc) {
        this.sign = "091443acea0d1b927859fa4b0420ab43";
        this.partnerId = "test001";
        this.serviceVersion = "1.0";
        this.serviceType = "wms.qgreceipt.update";
        switch (desc){
            case "放行":
                this.bizData = "<wmsRequestRoot><BillId>RELDLT20021816212829</BillId><SyncBillId>"+orderno+"</SyncBillId>" +
                        "<HZID>PDDLT</HZID><WarehouseCode>KJC</WarehouseCode><CompanyCode>123456</CompanyCode><BusinessNo>341920021816212829</BusinessNo>" +
                        "<ChkMark>800</ChkMark><NoticeTime>20200310120000000</NoticeTime><ResultInfo>[Code:2600;Desc:放行]</ResultInfo></wmsRequestRoot>";
                break;
            case "逻辑校验通过":
                this.bizData = "<wmsRequestRoot><BillId>RELHZX20022501025980</BillId><SyncBillId>"+orderno+"</SyncBillId><HZID>JHZX</HZID>" +
                        "<WarehouseCode>11</WarehouseCode><CompanyCode>3105961682</CompanyCode><BusinessNo>330720022501025980</BusinessNo>" +
                        "<ChkMark>120</ChkMark><NoticeTime>20200225092903745</NoticeTime><ResultInfo>[Code:1800;Desc:逻辑校验通过]</ResultInfo></wmsRequestRoot>";
                break;
            case "新增申报成功":
                this.bizData = "<wmsRequestRoot><BillId>RELDLT20021816212829</BillId><SyncBillId>"+orderno+"</SyncBillId><HZID>PDDLT</HZID>" +
                        "<WarehouseCode>KJC</WarehouseCode><CompanyCode>hzddy</CompanyCode><BusinessNo>341920021816212829</BusinessNo>" +
                        "<ChkMark>2</ChkMark><NoticeTime>20200310120000000</NoticeTime>" +
                        "<ResultInfo>清单新增申报成功[电商企业编码：123456订单编号：{{DOS}}]</ResultInfo></wmsRequestRoot>";
                break;
            case "支付信息不存在":
                this.bizData = "<wmsRequestRoot><BillId>RELHYB20032501386904</BillId><SyncBillId>"+orderno+"</SyncBillId>" +
                        "<HZID>JHYB</HZID><WarehouseCode>11</WarehouseCode><CompanyCode>33169667BG</CompanyCode>" +
                        "<BusinessNo>330720032501386904</BusinessNo><ChkMark>2</ChkMark><NoticeTime>20200325132959974</NoticeTime>" +
                        "<ResultInfo>清单新增申报成功[电商企业编码：3301964J31订单编号：2020021708362779148]; 对应电商平台为[33169667BG]订单号为[2020021708362779148]支付信息不存在</ResultInfo>" +
                        "</wmsRequestRoot>";
                break;
            case "清单上的订购人电话号码与订单上的订购人电话号码不一致":
                this.bizData = "<wmsRequestRoot><BillId>RELHZX20032501385694</BillId><SyncBillId>"+orderno+"</SyncBillId><HZID>JHZX</HZID>" +
                        "<WarehouseCode>11</WarehouseCode><CompanyCode>3105961682</CompanyCode><BusinessNo>330720032501385694</BusinessNo>" +
                        "<ChkMark>100</ChkMark><NoticeTime>20200325132817321</NoticeTime>" +
                        "<ResultInfo>[Code:130126;Desc:清单上的订购人电话号码与订单上的订购人电话号码不一致]</ResultInfo></wmsRequestRoot>";
                break;
            case "海关超限":
                this.bizData = "<wmsRequestRoot><BillId>RELHZC20032101343487</BillId><SyncBillId>"+orderno+"</SyncBillId><HZID>JHZC</HZID>" +
                        "<WarehouseCode>11</WarehouseCode><CompanyCode>3301964J31</CompanyCode><BusinessNo>330720032101343487</BusinessNo>" +
                        "<ChkMark>100</ChkMark><NoticeTime>20200321104414489</NoticeTime>" +
                        "<ResultInfo>[Code:1313;Desc:订购人购买超过年度限额,超过个人年度购买额度;totalPrice：26,114.44 &gt; limitPrice: 26,000;]</ResultInfo>" +
                        "</wmsRequestRoot>";
                break;
        }

    }
}
