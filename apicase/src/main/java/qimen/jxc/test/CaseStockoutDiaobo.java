package qimen.jxc.test;

import org.junit.jupiter.api.Test;
import qimen.jxc.api.Data;
import qimen.jxc.api.OrderStockout;
import wms.jxc.BackStockout;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/31 10:25
 */
public class CaseStockoutDiaobo {
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 无批次--下单
    @Test
    public void diaobo() throws Exception {
        OrderStockout.diaoboOrder(orderno, Data.shopNick,Data.sku,"",10);
        System.out.println(orderno);
    }
    // 回执
    @Test
    public void back() throws Exception {
        BackStockout.backOutDiaobo("OB20200831150820076299",Data.sku,"",9,"","","ZP");
    }

    // 有批次--下单
    @Test
    public void diaoboBatch() throws Exception {
        OrderStockout.diaoboOrder(orderno,Data.shopNick,Data.skuBatch,Data.batch,10);
        System.out.println(orderno);
    }
    // 回执
    @Test
    public void backBatch() throws Exception {
        BackStockout.backOutDiaobo("",Data.skuBatch,Data.batch,10,"","","ZP");
    }

    // 取消出库单
    @Test
    public void cancel () throws Exception {
        OrderStockout.orderCancel("QM20200831150833791");
    }
}
