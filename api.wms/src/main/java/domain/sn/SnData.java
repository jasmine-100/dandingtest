package domain.sn;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 11:23
 */
@XmlRootElement(name = "wmsRequestRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class SnData {
    private String BillId;
    private String SyncBillId;
    private String WarehouseCode;
    private String HZID;
    private String OrderType;
    private int PageSize;
    private int CurrentPage;
    private int TotalPage;
    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
    private List<Product> Products;

    public SnData() {
    }

    public SnData(String syncBillId, String warehouseCode, String HZID, String orderType, List<Product> products) {
        BillId = "RELHXY20021100953752";
        SyncBillId = syncBillId;
        WarehouseCode = warehouseCode;
        this.HZID = HZID;
        OrderType = orderType;
        PageSize = 10;
        CurrentPage = 1;
        TotalPage = 1;
        Products = products;
    }
}
