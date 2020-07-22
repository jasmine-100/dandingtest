package gx.domain;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/22 12:25
 */
@Data
public class GoodUp {
    private String  shopItemName;
    //大B用户id
    private String userId;
    //外部商品编码，自定义
    private String outerItemCode;
    //洋800SKU商品编码
    private String itemCode;

    public GoodUp(String shopItemName, String userId, String itemCode) {
        this.shopItemName = shopItemName;
        this.userId = userId;
        this.outerItemCode = "GX"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        this.itemCode = itemCode;
    }
}
