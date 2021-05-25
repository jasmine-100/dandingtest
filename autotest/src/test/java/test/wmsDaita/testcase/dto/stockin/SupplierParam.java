package test.wmsDaita.testcase.dto.stockin;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/24 17:25
 */
@Data
public class SupplierParam {
    String supName;

    public SupplierParam() {
        this.supName = "我是上游供应商";
    }
}
