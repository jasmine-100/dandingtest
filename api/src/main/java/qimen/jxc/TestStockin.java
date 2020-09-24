package qimen.jxc;

import org.junit.jupiter.api.Test;

/**
 * @Author： jasmine
 * @Description : 调拨入库单、wms回执
 * @Date : Created in 2020/9/23 17:21
 */
public class TestStockin {
    // 采购入库单
    @Test
    public void orderPurchase() {//推单
        ModelOrder.stockinPurchaseDiaobo("CGRK");
    }
    @Test
    public void backPurchase() {//回执
        ModelWmsBack.backStockin("CGRKD");
    }

    // 调拨入库单
    @Test
    public void orderDiaobo() {//推单
        ModelOrder.stockinPurchaseDiaobo("DBRK");
    }
    @Test
    public void backDiaobo() {//回执
        ModelWmsBack.backStockin("DBRKD");
    }


    @Test
    public void orderTuihuo() {//推单
        ModelOrder.stockinTuihuo();
    }
    @Test
    public void backTuihuo() {//回执
        ModelWmsBack.backStockin("SOTHRKD");
    }

}
