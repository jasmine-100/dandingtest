package domainout.stockin;

import domainout.deliver.Product;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 16:40
 */
@Data
@XmlRootElement(name = "wmsRequestRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class StockinData {
     String BillId;
     String SyncBillId;
     String OrigSystem;
     String HZID;
     String WarehouseCode;
     String BillType;
     String Operator;
     String OpertatorTime;
     String Memo;
     String BillDate;
     int IsConfirm;  // 0-全部入库；1-部分入库
     int BatchNo;

    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
     List<Product> Products;

    public StockinData() {
    }

    public StockinData(String syncBillId, String warehouseCode, String HZID, String billType,int isConfirm,int batchNo, List<Product> products) {
        BillId = "RELBRJ20012000950392";
        OrigSystem = "Y800OMS";
        SyncBillId = syncBillId;
        WarehouseCode = warehouseCode;
        BillType = billType;
        Operator = "小小";
        OpertatorTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Memo = "你好备注";
        BillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        IsConfirm = isConfirm;
        this.HZID = HZID;
        Products = products;
        BatchNo = batchNo;
    }
}
