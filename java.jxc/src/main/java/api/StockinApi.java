package api;

import client.ApiClient;
import jxc.BaseParam;
import jxc.Cookie;
import domainout.stockin.StoOrderItem;
import domainout.stockin.StockinOrder;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/26 9:31
 */
public class StockinApi {

    // 添加采购单
    public static void stockin(String purchaseId,String logicWareCode ,String procode,int num) throws Exception {
        // 入库单商品项
        List<StoOrderItem> stoOrderItems = new LinkedList<>();
        stoOrderItems.add(new StoOrderItem(procode,num));

        // 入库单信息
        StockinOrder stockinOrder = new StockinOrder(logicWareCode,purchaseId,stoOrderItems);

        // 借口推送
        ApiClient.doPostJson(BaseParam.STOCKIN_ADD,null, Cookie.getCookie(),stockinOrder);
    }

}
