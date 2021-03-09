package test.erp.testcase.wmsfuchun.dto.sn;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 11:25
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
 String Sku;
 String SN;

public Product(String sku) {
Sku = sku;
this.SN = sku;
}
}
