package test.qimen.dto.good;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 17:52
 */
@Data
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
public class Good {
    String actionType;// add添加
    String warehouseCode;
    String ownerCode;
    Item item;

    public Good() {
    }

    public Good(String actionType, String warehouseCode, String ownerCode, Item item) {
        this.actionType = actionType;
        this.warehouseCode = warehouseCode;
        this.ownerCode = ownerCode;
        this.item = item;
    }
}
