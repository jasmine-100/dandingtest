package wms.domain.outbound;

import wms.domain.deliver.Product;
import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 9:36
 */
@XmlRootElement(name = "wmsRequestRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutboundData {
     String BillId;
     String SyncBillId;
     String WarehouseCode;
     String HZID;
     String BusinessType;
     String Operator;
     String OperatorTime;
     String ShippingCode;
     String ShippingCompany;
     String OrigSystem;
     String OrderType;
     double Weight;
     String Memo;

    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
     List<Product> Products;

    public OutboundData() {
    }

    public OutboundData( String syncBillId, String warehouseCode, String HZID, String shippingCompany,String orderType, double weight, List<Product> products) {
        BillId = "RELBRJ20012000950392";
        SyncBillId = syncBillId;
        WarehouseCode = warehouseCode;
        this.HZID = HZID;
        BusinessType = "";
        Operator = "咖宝";
        OperatorTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ShippingCode = "Y"+new Random().nextInt(99999999);
        ShippingCompany = shippingCompany;
        OrigSystem = "Y800OMS";
        OrderType = orderType;
        Weight = weight;
        Memo = "你好出库单";
        Products = products;
    }
}
