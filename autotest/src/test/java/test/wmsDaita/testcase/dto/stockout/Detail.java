package test.wmsDaita.testcase.dto.stockout;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/25 17:04
 */
@Data
public class Detail {
    int expSkuQty;
    int lineSeq;
    String skuCode;

    public Detail(String skuCode,int expSkuQty, int lineSeq) {
        this.expSkuQty = expSkuQty;
        this.lineSeq = lineSeq;
        this.skuCode = skuCode;
    }

}
