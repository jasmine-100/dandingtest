package domain.wmsback;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/23 16:40
 */
@XmlRootElement(name = "wmsRequestRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class WmsRequestRoot {
    private String BillId;
    private String OrigSystem;
    private String SyncBillId;
    private String WarehouseCode;
    private String BillType;
    private String Operator;
    private String OpertatorTime;
    private String Memo;
    private String BillDate;
    private String IsConfirm;
    private String BatchNo;
    private String HZID;

    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
    private List<Product> Products;

    public WmsRequestRoot() {
    }

    public WmsRequestRoot(String syncBillId, String warehouseCode, String HZID, String billType, List<Product> products) {
        BillId = "ASN"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        OrigSystem = "Y800OMS";
        SyncBillId = syncBillId;
        WarehouseCode = warehouseCode;
        BillType = billType;
        Operator = "小小";
        OpertatorTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Memo = "你好备注";
        BillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        IsConfirm = "";
        BatchNo = "1234560";
        this.HZID = HZID;
        Products = products;
    }
}
