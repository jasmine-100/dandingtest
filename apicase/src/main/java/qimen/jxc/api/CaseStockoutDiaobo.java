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
import wms.domain.deliver.Product;
import wms.domain.outbound.OutboundData;
import wms.jxc.BackStockout;
import wms.jxc.BaseParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        BackStockout.backOutDiaobo("OB20200901105003015962",Data.sku,"",100,"","","ZP");
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
