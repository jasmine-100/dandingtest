package test.erp.testcase.apiadmin.dto.stockout;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/16 18:09
 */
@Data
public class StockoutCancel {

    private String outOrderNo;
    private String revocation;

    public StockoutCancel(String outOrderNo) {
        this.outOrderNo = outOrderNo;
        this.revocation = "取消入库单";
    }
}
