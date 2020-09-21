package casetest;

import api.PurchaseApi;
import api.StockinApi;
import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/26 9:30
 */
public class StokcinCase {

    @Test
    public void stockinAdd () throws Exception {
        String procode = "SKU1647";
        int num = 2000;

        String orderId = PurchaseApi.createPurchaseOrder(procode,2000,"S200831160104647486","RMB");

        PurchaseApi.examine(orderId);

        StockinApi.stockin(orderId,"LSPUAO0N1X",procode,num);
    }
}
