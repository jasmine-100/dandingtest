package qimen.jxc;


import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description : 发货出库单、wms回执
 * @Date : Created in 2020/9/24 13:25
 */
public class TestStockout {

    // 发货出库单
    @Test
    public void orderDeliver(){
        ModelOrder.orderStockout("JYCK","SF");
    }
    // 批发出库单(物流公司为德邦)
    @Test
    public void orderOutbound(){
        ModelOrder.orderStockout("JYCK","DBL");
    }
    // 发货出库、批发出库回执
    @Test
    public void back(){
        ModelWmsBack.backStockoutOrder();
    }


    // 调拨出库单(ordertype为DBCK)
    @Test
    public void orderDiaobo(){
        ModelOrder.orderStockout("DBCK","SF");
    }
    // 调拨出库回执
    @Test
    public void backDiaobo(){
        ModelWmsBack.backStockoutDiaobo();
    }

}
