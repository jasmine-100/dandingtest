package qimen.api.jxc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description : 调拨入库单、wms回执
 * @Date : Created in 2020/9/23 17:21
 */
public class TestStockin {
    // 采购入库、调拨入库单
    @Test(dataProvider = "billtype")
    public void orderPurchase(String billType) {//推单

        if(billType.equals("THRK")){
            ModelOrder.stockinTuihuo(billType);
        }else{
            ModelOrder.stockinPurchaseDiaobo(billType);
        }
    }

    @DataProvider(name = "billtype")
    public Object[] getBilltype(){
        Object[] objects = {"CGRK","DBRK","THRK"};//采购和调拨入库单
        return objects;
    }

    @Test
    public void backPurchase() {//回执采购入库单
        ModelWmsBack.backStockin("CGRKD");
    }
    @Test
    public void backDiaobo() {//回执调拨入库单
        ModelWmsBack.backStockin("DBRKD");
    }
    @Test
    public void backTuihuo() {//回执
        ModelWmsBack.backStockin("SOTHRKD");
    }

}
