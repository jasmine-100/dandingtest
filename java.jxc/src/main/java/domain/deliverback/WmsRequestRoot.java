package domain.deliverback;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 17:34
 */
@Data
@XmlRootElement(name = "wmsRequestRoot")
@XmlAccessorType(XmlAccessType.FIELD)
public class WmsRequestRoot {
    private String BillId;
    private String SyncBillId;
    private String DealCode;
    private String WarehouseCode;
    private String Operator;
    private String OperatorTime;
    private String ShippingCode;
    private String ShippingCompany;
    private String OrigSystem;
    private String BillDate;
    private double Weight;
    private String Memo;
    private String QGBillId;
    private String HZID;

    @XmlElementWrapper(name = "Products")
    @XmlElement(name = "Product")
    private List<Product> Products;

    public WmsRequestRoot(String syncBillId, String warehouseCode, String shippingCompany,List<Product> products) {
        BillId = "RELHXY"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        SyncBillId = syncBillId;
        DealCode = "420000050620200210473068849300";
        WarehouseCode = warehouseCode;
        Operator = "jim";
        OperatorTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ShippingCode = "Y"+new Random().nextInt(999999999);
        ShippingCompany = shippingCompany;
        OrigSystem = "Y800OMS";
        BillDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;
        Weight = 1.68;
        Memo = "哈哈";
        this.QGBillId = "29242020I090828278";
        this.HZID = "GL01";
        Products = products;
    }

    public WmsRequestRoot() {
    }

    @XmlTransient
    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }
}
