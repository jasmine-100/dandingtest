package test.erp.testcase.apiuser.dto.purchase;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/23 14:17
 */
@Data
public class PurchaseSubmit {

    private String purchaseOrderNo;

    public PurchaseSubmit(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }
}
