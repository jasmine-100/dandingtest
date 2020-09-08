package qimen.jxc.api;

import client.ApiClient;
import org.junit.jupiter.api.Test;
import qimen.domain.Param;
import qimen.domain.deliver.DeliveryOrder;
import qimen.domain.deliver.OrderLine;
import qimen.domain.deliver.ReceiverInfo;
import qimen.domain.deliver.RequestOrderDeliver;
import qimen.domain.stockin.SenderInfo;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.DeliverData;
import wms.domain.deliver.Product;
import wms.jxc.BackStockout;
import wms.jxc.BaseParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        BackStockout.backDeliver("OB20200901172116083169",Data.sku,"",100,"","","ZP");
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
