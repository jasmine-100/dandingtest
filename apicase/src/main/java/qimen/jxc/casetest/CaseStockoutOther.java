package qimen.jxc.casetest;

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
public class CaseStockoutOther {
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 批发出库单
    @Test
    public void outbound() throws Exception {
        OrderStockout.outboundOrder(orderno, Data.shopNick,Data.sku,"",10);
        System.out.println(orderno);
    }
    @Test
    public void outboundBack() throws Exception {
        BackStockout.backDeliver("OB20200831150240019251",Data.sku,"",11,"","","ZP");
    }

    // 有批次
    @Test
    public void outboundBatch() throws Exception {
        OrderStockout.outboundOrder(orderno,Data.shopNick,Data.skuBatch,Data.batch,10);
        System.out.println(orderno);
    }
    @Test
    public void outboundBackBatch() throws Exception {
        BackStockout.backDeliver("OB20200831150505926087",Data.skuBatch,Data.batch,11,"","","ZP");
    }

    // 取消c单和B单
    @Test
    public void cancel () throws Exception {
        OrderStockout.orderCancel("QM20200831150515919");
    }

}
