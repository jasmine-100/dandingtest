package casetest;

import client.ApiClient;
import domainout.stockin.StoOrderItem;
import domainout.stockin.StockinOrder;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/22 16:35
 */
public class StockinApi {
    // 添加入库单
    public static void stockin(String purchaseId,String procode,int num) throws Exception {
        // 入库单商品项
        List<StoOrderItem> stoOrderItems = new LinkedList<>();
        stoOrderItems.add(new StoOrderItem(procode,num));

        // 入库单信息
        StockinOrder stockinOrder = new StockinOrder("LSPUAO0N1X",purchaseId,stoOrderItems);

        // 接口推送
        ApiClient.doPostJson(BaseParam.STOCKIN_ADD,null, BaseParam.getCookie(),stockinOrder);
    }
}
