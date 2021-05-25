package test.qimen.testcase.dto.stockin.purchase;

import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/24 16:54
 */
@Data
public class ExtendProps {
    String purchaseWmsAdd;
    String omsPurchaseNo;

    public ExtendProps(String purchaseWmsAdd, String omsPurchaseNo) {
        this.purchaseWmsAdd = purchaseWmsAdd;
        this.omsPurchaseNo = omsPurchaseNo;
    }

}
