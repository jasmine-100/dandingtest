package test.erp.testcase.apiadmin.dto.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/16 17:37
 */
@Data
public class StockinPush {

    private String inOrderNo;

    public StockinPush(String inOrderNo) {
        this.inOrderNo = inOrderNo;
    }

}
