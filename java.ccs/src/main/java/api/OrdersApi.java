package api;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import jxc.BaseParam;
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
public class OrdersApi {
    // 电商平台编码
    static String ebpCode = "1234650123";
    // 电商企业编码
    static String ebcCode= "1234650123";
    // 此项要配置，不要改
    static String agentCode = "330766K00W";

    @Test
    public void test(){
        for (int i=0;i<3;i++){
            pushOrder();
        }
    }

    /**
     * 步骤一：推送申报单
     */
    @Test
    public void pushOrder(){

        String str = new SimpleDateFormat("MMddHHmmssSSS").format(new Date());
        // 渠道订单号
        String outOrderNo = "JOS"+str;
        // 申报单号
        String declareOrderno = "DOS"+str;

        // 添加商品项
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("JHKY09101743","SKU09101743",3,9));
        items.add(new Item("SKA205","SKA205",1,2));
        items.add(new Item("JHKY200914091330","SKU200914091330",2,2));
        items.add(new Item("JHKY200914091143","SKU200914091143",9,2));
        items.add(new Item("JHKY200914090547","SKU200914090547",100,2));

        // 组装申报单
        Order order = new Order("xiaoyuer","小鱼儿",outOrderNo,declareOrderno,"SF","SF"+str,"xiaohei",items);

        //接口：推送申报单
        ApiClient.doPostJson(BaseParam.URL_ORDER,null,null,order);

        //回执订单申报结果
//        dingdanBack(declareOrderno);

        //回执清单申报结果
        qingdanBack(declareOrderno);
    }

    /**
     * 步骤二：订单申报回执
     * 回传时间格式：年月日时分秒毫秒
     */
    public void dingdanBack(String orderno){
        // 口岸：处理成功
        BackDingdanKouan.backPass(orderno,"2020-8-06");
//        Thread.sleep(1000);
        // 总署：逻辑校验通过
        BackDingdanZongshu.logicOk(orderno,ebcCode,ebcCode,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//        Thread.sleep(1000);
        // 总署:新增申报成功
        BackDingdanZongshu.declareAddOk(orderno,ebcCode,ebcCode,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//        Thread.sleep(3000);
    }

    /**
     * 步骤三：清单申报回执
     */
    public void qingdanBack(String declareOrderNo) {
        // 回执清单号
        String invtNo = "QD"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        // 口岸回执：处理成功
        BackQingdanKouan.backPass(declareOrderNo,agentCode,"2020-8-16");
//        Thread.sleep(1000);

        //回执逻辑校验通过报文
        //回传时间格式：年月日时分秒毫秒
        BackQingdanZongshu.backLogic(declareOrderNo,ebcCode,ebpCode,agentCode,invtNo,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//        Thread.sleep(1000);

        // 回执新增申报成功报文
        BackQingdanZongshu.backAddOk(declareOrderNo,ebcCode,ebpCode,agentCode,invtNo,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
//        Thread.sleep(1000);

        //回执放行报文
        BackQingdanZongshu.backPass(declareOrderNo,ebcCode,ebpCode,agentCode,invtNo,"20200916110030001");
//        Thread.sleep(1000);

        // 回执：税金
        BackTax.backTaxrd(invtNo,100,5.2,3.6,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
    }
}
