package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
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
 * @Description : CCS 下单-申报订单-申报清单流程
 * @Date : Created in 2020/7/20 12:23
 */
public class OrderSetApi {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";
    // 此项要配置，不要改
    static String agentCode = "330766K00W";

    /**
     * 步骤一：推送申报单
     */
    @Test
    public void pushOrder() throws IOException, InterruptedException {

        // 渠道订单号和申报单号:随机生成
        String orderno = "JIS"+new SimpleDateFormat("MMddHHmmss").format(new Date());

        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("NO0715J01",2,10));
//        items.add(new Item("NO0715J02",6,11));
//        items.add(new Item("NO0715J03",5,12));

        // 组装申报单
//        Order order = new Order(orderno,"ZTO","Z"+new Random(999999),"jasRoute", items);
        Order order = new Order("zh-abc","租户abc",orderno,"ZTO","Z"+new Random(999999),"jasRoute", items);

        //接口：推送申报单
        ApiClient client = new ApiClient("http://ccs.backend.daily.yang800.com/xhr/order/submit");
        client.doPostJson(JSON.toJSON(order));

        //回执订单申报结果
//        dingdanBack(orderno);
    }

    /**
     * 步骤二：订单申报回执
     */
    public void dingdanBack(String orderno) throws IOException {
        //订单回执成功
        BackDingdan.declareSuccess(orderno,ebcCode,ebcCode);
        BackDingdan.logicSuccess(orderno,ebcCode,ebcCode);
    }

    /**
     * 步骤三：清单申报回执
     * @throws IOException
     */
    @Test
    public void qingdanBack() throws IOException, InterruptedException {
        // 取申报单的数据库id
        String orderno = "497803022471004161";
        //回执清单号
        String invtNo = "QD"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        String invtNo = "QD20200805151953";

                //回执逻辑校验通过报文
        BackQingDan.backLogicPass(orderno,ebcCode,ebpCode,agentCode,invtNo);
        Thread.sleep(2000);

        //回执新增申报成功报文
        BackQingDan.backDeclareSuccess(orderno,ebcCode,ebpCode);
        Thread.sleep(2000);

        //回执放行报文
        BackQingDan.backPass(orderno,ebcCode,ebpCode,invtNo);
        Thread.sleep(2000);

        //回执税费报文
        BackQingDan.backTaxrd(invtNo,10.2,15);

    }

}
