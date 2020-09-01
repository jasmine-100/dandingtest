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
 * @Date : Created in 2020/8/28 18:11
 */
public class CaseStockoutDeliver {
    String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

    // 发货出库单--无批次--下单
    @Test
    public void deliver() throws Exception {
        OrderStockout.deliverOrder(orderno, Data.shopNick,Data.sku,"",100);
        System.out.println(orderno);
    }
    // 回传
    @Test
    public void deliverBack() throws Exception {
        BackStockout.backDeliver("OB20200901151812321615",Data.sku,"",200,"","","ZP");
    }

    // 有批次--下单
    @Test
    public void deliverBatch() throws Exception {
        OrderStockout.deliverOrder(orderno,Data.shopNick,Data.skuBatch,"",100);
        System.out.println(orderno);
    }
    // 回传
    @Test
    public void deliverBackBatch() throws Exception {
        BackStockout.backDeliver("OB20200831150037390820",Data.skuBatch,Data.batch,9,"","","ZP");
    }

    // 取消c单和B单
    @Test
    public void cancel () throws Exception {
        OrderStockout.orderCancel("QM20200831150155873");
    }

}
