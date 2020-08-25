package controller;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/25 10:24
 */
public class BackStockin {

    public static void backPurchase(String SyncBillId,String WarehouseCode,String HZID,String ShippingCompany,String ShippingCode){
        String data = "<wmsRequestRoot>" +
                "<BillId>RELRJN200610035033382</BillId>" +
                "<SyncBillId>"+SyncBillId+"</SyncBillId>" +
                "<DealCode ></DealCode>" +
                "<WarehouseCode>"+WarehouseCode+"</WarehouseCode>" +
                "<Operator>DM023</Operator><OperatorTime>2020-06-10 17:49:32</OperatorTime>" +
                "<ShippingCode>"+ShippingCode+"</ShippingCode>" +
                "<ShippingCompany>"+ShippingCompany+"</ShippingCompany>" +
                "<OrigSystem>ERPOMS</OrigSystem>" +
                "<BillDate>2020-06-10 17:49:32</BillDate>" +
                "<Weight>4.39</Weight><Memo ></Memo>" +
                "<QGBillId ></QGBillId>" +
                "<HZID>"+HZID+"</HZID>" +
                "<Products>" +
                    "<Product>" +
                        "<OrderLineNo ></OrderLineNo>" +
                        "<Sku>SKU-XIGUA</Sku><BatchCode>" +
                        "</BatchCode>" +
                        "<Qty>1</Qty>" +
                        "<Memo ></Memo>" +
                        "<BatchValue1></BatchValue1>" +
                        "<BatchValue2></BatchValue2>" +
                        "<BatchValue3 ></BatchValue3>" +
                        "<BatchValue4 ></BatchValue4>" +
                        "<BatchValue5 ></BatchValue5>" +
                        "<InventoryType>ZP</InventoryType>" +
                    "</Product>" +
                "</Products>" +
                "</wmsRequestRoot>";
    }
}
