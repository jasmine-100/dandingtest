package wms.domainout.sn;

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
 String BillId;
 String SyncBillId;
 String WarehouseCode;
 String HZID;
 String OrderType;
 int PageSize;
 int CurrentPage;
 int TotalPage;
@XmlElementWrapper(name = "Products")
@XmlElement(name = "Product")
 List<Product> Products;

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
