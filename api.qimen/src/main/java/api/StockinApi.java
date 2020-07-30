package api;

import client.ApiClient;
import domain.Method;
import domain.Param;
import domain.stockin.EntryOrder;
import domain.stockin.OrderData;
import domain.stockin.OrderLine;
import org.junit.Test;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :  奇门接口推送采购入库单
 * @Date : Created in 2020/7/24 13:43
 */
public class StockinApi {
    String url = "http://outtest.order.yang800.cn/qimen/api";
    //仓库编码：取经销存系统的逻辑仓编码
    String whCode = "LSXKOGSI7E";
    //用不上，可以不填
    String ownerCode = "";
    //外部订单号，相同货主内唯一
    String orderno = "SI2020073001";
    //yang-test的外部店铺的outkey（去掉QM）
    String customerId = "C1590459235731";


    @Test
    public void orderSet() throws Exception {
        //组装商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(ownerCode,"052903",10,"ZP"));

        //组装订单项
        EntryOrder entryOrder = new EntryOrder(orderno,ownerCode,whCode,"CGRK","123");

        //组装请求body
        OrderData orderData = new OrderData(entryOrder,orderLines);

        //组装接口头信息
        Param param = new Param(Method.STOCKIN,customerId);

        ApiClient.doPostXml(url,param,null, XmlUtil.objToXml(orderData));

    }

}
