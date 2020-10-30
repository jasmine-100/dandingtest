package qimen.api.jxc;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qimen.domain.deliver.Cancel;

/**
 * @Author： jasmine
 * @Description : 发货出库单、wms回执
 * @Date : Created in 2020/9/24 13:25
 */
public class TestStockout {

    @Test(dataProvider = "params")
    public void order(String billType,String expressCode){
        ModelOrder.orderStockout(billType,expressCode);
    }

    @DataProvider(name = "params")
    public Object[][] params(){
        Object[][] objects = {
                {"JYCK","SF"},//发货单
                {"JYCK","DBL"},//批发出库单
                {"DBCK","SF"}};//调拨出库单
        return objects;
    }

    // 发货出库、批发出库回执
    @Test
    public void back(){
        ModelWmsBack.backStockoutOrder();
    }

    // 调拨出库回执
    @Test
    public void backDiaobo(){
        ModelWmsBack.backStockoutDiaobo();
    }

    @Test
    public void cancelOrder() throws Exception {
        ModelOrder.cancelOrder("200610-335351317121261");
    }
}
