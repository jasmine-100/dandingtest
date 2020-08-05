package oms.domain;

import lombok.Data;

import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 17:59
 */
@Data
public class ShipBack {
     String bizData;
     String serviceType;
     String sign;
     String serviceVersion;

    public ShipBack(String orderno) {
        this.bizData = "<?xml version=\"1.0\" encoding=\"utf-8\"?><wmsRequestRoot><BillId>SOKJCMS00123620200228</BillId>" +
                "<OrigSystem>Y800OMS</OrigSystem><SyncBillId>"+orderno+"</SyncBillId><WarehouseCode>KJC</WarehouseCode><HZID>MS</HZID>" +
                "<Operator>02350</Operator><OperatorTime>2020-3-24 16:00:00</OperatorTime><BillDate>2019-12-18 13:35:41</BillDate>" +
                "<ShippingCode>YT"+new Random().nextInt(1000000) +"</ShippingCode><ShippingCompany>STO</ShippingCompany><Memo/><Weight>12</Weight><QGBillId>12345600020200228002</QGBillId>" +
                "<Products><Product><Sku>8716200712910</Sku><BatchCode>B17093000003</BatchCode><Qty>5</Qty><Memo/>" +
                "<BatchValue1>2017-06-01</BatchValue1><BatchValue2>2019-06-22</BatchValue2></Product></Products></wmsRequestRoot>";
        this.serviceType = "wms.cstockout.update";
        this.sign = "d8a8ad6a9a33f5d08169deb52c5eb4d0";
        this.serviceVersion = "1.0";
    }

    public ShipBack(String orderno,String shippingCompany,String shippingCode,String operateDate) {
        this.bizData = "<?xml version=\"1.0\" encoding=\"utf-8\"?><wmsRequestRoot><BillId>SOKJCMS00123620200228</BillId>" +
                "<OrigSystem>Y800OMS</OrigSystem><SyncBillId>"+orderno+"</SyncBillId><WarehouseCode>KJC</WarehouseCode><HZID>MS</HZID>" +
                "<Operator>02350</Operator><OperatorTime>"+operateDate+" 16:00:00</OperatorTime><BillDate>2019-12-18 13:35:41</BillDate>" +
                "<ShippingCode>"+shippingCode+"</ShippingCode><ShippingCompany>"+shippingCompany+"</ShippingCompany><Memo/><Weight>12</Weight><QGBillId>12345600020200228002</QGBillId>" +
                "<Products><Product><Sku>8716200712910</Sku><BatchCode>B17093000003</BatchCode><Qty>5</Qty><Memo/>" +
                "<BatchValue1>2017-06-01</BatchValue1><BatchValue2>2019-06-22</BatchValue2></Product></Products></wmsRequestRoot>";
        this.serviceType = "wms.cstockout.update";
        this.sign = "d8a8ad6a9a33f5d08169deb52c5eb4d0";
        this.serviceVersion = "1.0";
    }
}
