package test.erp.api.dto.good;

import lombok.Data;
import utils.util.UtilsTime;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/5 15:30
 */
@Data
public class PurPrice {

    private String supplierCode;//供应商编码
    private String supplierName;
    private String goodsCode;//货品id
    private String goodsName;
    private String currency;//币值：HKD 港币，EUR 欧元，USD 美元
    private int purchasePrice;//采购价
    private long effectTime;//生效开始时间
    private long noEffectTime;//生效结束时间

    public PurPrice(String supplierCode, String goodsCode, String currency, int purchasePrice, String effectTime, String noEffectTime) {
        this.supplierCode = supplierCode;
        this.supplierName = "供应商嘿嘿";
        this.goodsCode = goodsCode;
        this.goodsName = "小傻瓜";
        this.currency = currency;
        this.purchasePrice = purchasePrice;
        this.effectTime = UtilsTime.getTime(effectTime);//转换为时间戳
        this.noEffectTime = UtilsTime.getTime(noEffectTime);
    }
}
