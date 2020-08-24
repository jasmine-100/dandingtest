package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import dao.BaseParam;
import domain.Item;
import domain.Order;
import domainout.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author： jasmine
 * @Description : CCS申报单完整流程：推送申报单--申报订单-申报清单--回执电子税单
 * @Date : Created in 2020/7/20 12:23
 */
public class OrdersSetApi {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";
    // 此项要配置，不要改
    static String agentCode = "330766K00W";

    // 批量造订单
    @Test
    public void batchOrders() throws IOException, InterruptedException {
        for(int i=0;i<=500;i++){
            pushOrder(i);
        }
    }

    /**
     * 步骤一：推送申报单
     */
    @Test
    public void pushOrder(int i) throws IOException, InterruptedException {
        // 渠道订单号
        String outOrderNo = "JOS_A"+i;
        // 申报单号
        String declareOrderno = "DOS_A"+i;

        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("JHKY08241053",3,9));
        items.add(new Item("JHKY08241046",10,2));

        // 组装申报单
        Order order = new Order("xiaoyuer","小鱼儿",outOrderNo,declareOrderno,"SF","SF"+i,"xiaohei", items);

        //接口：推送申报单
        new ApiClient(BaseParam.URL_ORDER).doPostJson(JSON.toJSON(order));
        Thread.sleep(10000);

        //回执订单申报结果
        dingdanBack(declareOrderno);

        //回执清单申报结果
        qingdanBack(declareOrderno);
    }

    /**
     * 步骤二：订单申报回执
     * 回传时间格式：年月日时分秒毫秒
     */
    public void dingdanBack(String orderno) throws IOException, InterruptedException {
        // 口岸：处理成功
        BackDingdanKouan.backPass(orderno,"2020-8-06");
        Thread.sleep(2000);
        // 总署：逻辑校验通过
        BackDingdanZongshu.logicOk(orderno,ebcCode,ebcCode,"20200806090000001");
        Thread.sleep(2000);
        // 总署:新增申报成功
        BackDingdanZongshu.declareAddOk(orderno,ebcCode,ebcCode,"20200807100000000");
    }

    /**
     * 步骤三：清单申报回执
     */
    public void qingdanBack(String orderno) throws IOException, InterruptedException {
        // 回执清单号
        String invtNo = "QD"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 口岸回执：处理成功
        BackQingdanKouan.backPass(orderno,agentCode,"2020-8-16");
        Thread.sleep(1000);

        //回执逻辑校验通过报文
        //回传时间格式：年月日时分秒毫秒
        BackQingdanZongshu.backLogic(orderno,ebcCode,ebpCode,agentCode,invtNo,"20200810130000001");
        Thread.sleep(1000);

        // 回执新增申报成功报文
        BackQingdanZongshu.backAddOk(orderno,ebcCode,ebpCode,agentCode,invtNo,"20200810140000001");
        Thread.sleep(1000);

        //回执放行报文
        BackQingdanZongshu.backPass(orderno,ebcCode,ebpCode,agentCode,invtNo,"20200810150000001");
        Thread.sleep(1000);

        // 回执：税金
        BackTax.backTaxrd(invtNo,100,5.2,3.6,"20200831114735001");

    }

}
