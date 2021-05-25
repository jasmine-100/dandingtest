package test.erp.testcase.apiuser.dto.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/5/19 14:21
 */
@Data
public class Examine {

    private String inOrderNo;

    public Examine(String inOrderNo) {
        this.inOrderNo = inOrderNo;
    }
}
