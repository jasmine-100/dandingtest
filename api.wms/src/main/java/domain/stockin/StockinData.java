package domain.stockin;

import domain.deliver.Product;

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
public class StockinData {
    private String BillId;
    private String OrigSystem;
    private String SyncBillId;
    private String HZID;
    private String WarehouseCode;
    private String BillType;
    private String Operator;
    private String OpertatorTime;
    private String Memo;
    private String BillDate;
    private String IsConfirm;


    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
    private List<Product> Products;

    public StockinData() {
    }

    public StockinData(String syncBillId, String warehouseCode, String HZID, String billType, List<Product> products) {
        BillId = "RELBRJ20012000950392";
        OrigSystem = "Y800OMS";
        SyncBillId = syncBillId;
        WarehouseCode = warehouseCode;
        BillType = billType;
        Operator = "小小";
        OpertatorTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Memo = "你好备注";
        BillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        IsConfirm = "0";
        this.HZID = HZID;
        Products = products;
    }
}