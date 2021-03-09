package test.erp.testcase.wmsfuchun.dto.deliver;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 9:03
 */
@Data
@XmlRootElement(name = "wmsRequestRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeliverData {
     String BillId;
     String SyncBillId;
     String DealCode;
     String WarehouseCode;
     String Operator;
     String OperatorTime;
     String ShippingCode;
     String ShippingCompany;
     String OrigSystem;
     String BillDate;
     double Weight;
     String Memo;
     String QGBillId;
     String HZID;

    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
     List<Product> Products;

    public DeliverData(String syncBillId, String warehouseCode, String shippingCompany, double weight, String HZID, List<Product> products) {
        BillId = "RELHXY20021100953752";
        SyncBillId = syncBillId;
        DealCode = "420000050620200210473068849300";
        WarehouseCode = warehouseCode;
        Operator = "笑笑";
        OperatorTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ShippingCode = "Y"+new Random().nextInt(10000000);
        ShippingCompany = shippingCompany;
        OrigSystem = "Y800OMS";
        BillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Weight = weight;
        Memo = "你好备注";
        this.QGBillId = "29242020I090828278";
        this.HZID = HZID;
        Products = products;
    }

    public DeliverData() {
    }
}
