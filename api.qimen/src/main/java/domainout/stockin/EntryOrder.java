package domainout.stockin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 13:54
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryOrder {
     String entryOrderCode;
     String ownerCode;
     String warehouseCode;
     String orderType;
     String expectStartTime;
     String supplierCode;
     String supplierName;
     SenderInfo senderInfo;


    public EntryOrder(String entryOrderCode, String ownerCode, String warehouseCode, String orderType, String supplierName) {
        this.entryOrderCode = entryOrderCode;
        this.ownerCode = ownerCode;
        this.warehouseCode = warehouseCode;
        this.orderType = orderType;
        this.expectStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.supplierCode = "";
        this.supplierName = supplierName;
        this.senderInfo = new SenderInfo("浙江省","杭州市","江干区");;
    }
}
