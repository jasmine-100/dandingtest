package test.erp.testcase.apiadmin.dto.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/16 18:09
 */
@Data
public class StockinCancel {

    private String inOrderNo;
    private String revocation;

    public StockinCancel(String inOrderNo) {
        this.inOrderNo = inOrderNo;
        this.revocation = "取消入库单";
    }
}
