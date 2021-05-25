package test.erp.testcase.outPuluosi.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/14 15:32
 */
@Data
public class Stock {
    private String sourceCode;
    private String method;
    private String merchantId;//货主编码
    private String warehouseId;//逻辑仓编码
    private String goodsId;
    private String sign;
    private int queryLocation;//是否查询货位：1 是，0 否
    private String appKey;
    private String appSecret;
    private String timesTamp;

    public Stock(String goodsId, String merchantId, String warehouseId, int queryLocation) {
        this.appKey = "69310916123999402868";
        this.appSecret = "kckcfnvyfbsh4flq19gg9p9q5aw0ch";
        this.sign = "0PNZ0+EIJZ1ZA3AMEG2P5W==";
        this.method = "epass.inventory.query.push";
        this.sourceCode = "170";
        this.merchantId = merchantId;
        this.warehouseId = warehouseId;
        this.goodsId = goodsId;
        this.queryLocation = queryLocation;
        this.timesTamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
