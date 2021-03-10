package test.erp.testcase.api.dto.goodPrice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/3/5 15:24
 */
@Data
public class PurSupplier {

    private String goodsCode;
    private List<String> supplierCodeString;//供应商编码list

    public PurSupplier(String goodsCode, List<String> supplierCodeString) {
        this.supplierCodeString = supplierCodeString;
        this.goodsCode = goodsCode;
    }

}
