package test.erp.testcase.apiadmin.dto.stockout;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/16 18:22
 */
@Data
public class StockoutPush {

    private String outOrderNo;

    public StockoutPush(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }
}
