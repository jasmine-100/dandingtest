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
        String procode = "20200826092934";
        int num = 100;

        String orderId = PurchaseApi.createPurchaseOrder(procode,num);

        PurchaseApi.examine(orderId);

        StockinApi.stockin(orderId,procode,num);
    }
}
