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
        String procode = "sku08261516";
        int num = 80;

        String orderId = PurchaseApi.createPurchaseOrder(procode,num,"S200826093442963114","RMB");

        PurchaseApi.examine(orderId);

        StockinApi.stockin(orderId,"LSS6TSGHGT",procode,num);
    }
}
