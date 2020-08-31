package jxc;

import org.junit.jupiter.api.Test;

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
        OrderStockout.outboundOrder(orderno,Data.shopNick,Data.sku,"",10);
    }
    @Test
    public void outboundBack() throws Exception {
        BackStockout.backDeliver("",Data.sku,"",9,"","","ZP");
    }

    // 有批次
    @Test
    public void outboundBatch() throws Exception {
        OrderStockout.outboundOrder(orderno,Data.shopNick,Data.skuBatch,"",10);
    }
    @Test
    public void outboundBackBatch() throws Exception {
        BackStockout.backDeliver("",Data.skuBatch,Data.batch,9,"","","ZP");
    }


    // 取消c单和B单
    @Test
    public void cancel () throws Exception {
        OrderStockout.orderCancel("QM20200828193209369");
    }

}
