package test.ccs;

import org.testng.annotations.Test;
import test.ccs.dto.Item;
import test.ccs.dto.order.Order;
import test.ccs.dto.back.BackDingdanZongshu;
import test.ccs.dto.back.BackQingdanZongshu;
import test.ccs.dto.back.BackTax;
import test.ccs.dto.back.BackYundanZongshu;
import utils.client.apiclientDTO.ApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/5 16:34
 */
public class OrderCaseTotal {
    String str = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
    String outOrderNo = "JOS" + str;// 外部单号
    String declareOrderNo = "DOS" + str;// 申报单号
    String invtNo = "QD" + str;// 清单号
    String logiticsNo = "SF" +str;// 运单号
    String routeCode = "xiaohei2";//xiaohei1 支付单运单；xiaohei2 订单清单；xiaohei3 清单

    @Test
    public void order() throws Exception{
        // 下单
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("JHY10131611","SKU10131611",3,9));
        items.add(new Item("JHY10131610","SKU10131610",10,2));
        items.add(new Item("JHY10131612","SKU10131612",7,2.3));
        Order order = new Order("xiaoyuer","小鱼儿", outOrderNo,declareOrderNo,"SF",logiticsNo,routeCode,items);
        //接口：推送申报单
        ApiClient.doPostJson(Data.URL_ORDER,null,null,order);

        //订单回执
        BackDingdanZongshu.declareAddOk(declareOrderNo, Data.ebpCode, Data.ebcCode,"20201110150000001");
        BackDingdanZongshu.logicOk(declareOrderNo, Data.ebpCode, Data.ebcCode,"20201110160000001");
        Thread.sleep(1000);

        //运单回执
        BackYundanZongshu.backAddOk(logiticsNo, Data.agentCode,"20201110170000001");
        BackYundanZongshu.backLogic(logiticsNo, Data.agentCode,"20201110180000001");

        // 清单回执
        BackQingdanZongshu.backAddOk(declareOrderNo, Data.ebpCode, Data.ebcCode, Data.agentCode,invtNo,"20201110190000001");
        BackQingdanZongshu.backLogic(declareOrderNo, Data.ebpCode, Data.ebcCode, Data.agentCode,invtNo,"20201110200000001");
        BackQingdanZongshu.backPass(declareOrderNo, Data.ebpCode, Data.ebcCode, Data.agentCode,invtNo,"20201110210000001");

        //税费回执
        BackTax.backTaxrd(invtNo, Data.ebcCode,600.6,10,30,"20201110220000001");
    }
}
