package ccs;

import ccs.dto.Item;
import ccs.dto.Order;
import ccs.dtoBack.*;
import client.ApiClient;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/8/17 15:17
 */
public class OrderCase {
    String str = "JOS20210113132905";
    String declareOrderNo = str;
    String outOrderNo = str;
    String logiticsNo = "SF"+str;
    String invtNo = "QD"+str;
    String routeCode = "xiaohei2";//xiaohei1 支付单运单；xiaohei2 订单清单；xiaohei3 清单

    @Test
    public void orderSet(){
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("JHY10131611","SKU10131611",3,9));
        items.add(new Item("JHY10131610","SKU10131610",10,2));
        items.add(new Item("JHY10131612","SKU10131612",7,2.3));
        Order order = new Order("xiaoyuer","小鱼儿", outOrderNo,declareOrderNo,"SF",logiticsNo,routeCode,items);
        //接口：推送申报单
        ApiClient.doPostJson(Data.URL_ORDER,null,null,order);
    }

    // 订单回执
    @Test
    public void dingdanBackAddOk(){ // 新增申报成功
        BackDingdanZongshu.declareAddOk(declareOrderNo,Data.ebpCode,Data.ebcCode,"20210113150000001");
    }
    @Test
    public void dingdanBackLogic(){ // 逻辑校验通过
        BackDingdanZongshu.logicOk(declareOrderNo,Data.ebpCode,Data.ebcCode,"20200818160000001");
    }
    @Test
    public void dingdanErrorCompany(){ // 支付企业不一致(申报终止,可重推)
        BackDingdanZongshu.errorCompany(declareOrderNo,Data.ebpCode,Data.ebcCode,"20200818130000001");
    }

    // 运单回执
    @Test
    public void yundanBackAddOk()  { // 新增申报成功
        BackYundanZongshu.backAddOk(logiticsNo,Data.agentCode,"20210113150000001");
    }
    @Test
    public void yundanBackLogic()  { // 逻辑校验通过
        BackYundanZongshu.backLogic(logiticsNo,Data.agentCode,"20210113160000001");
    }

    // 清单回执
    @Test
    public void qingdanBackKouan()  { // 口岸处理成功
        BackQingdanKouan.backPass(declareOrderNo,Data.agentCode,"2020-8-17");
    }
    @Test
    public void qingdanBackAddOk()  { // 新增申报成功
        BackQingdanZongshu.backAddOk(declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,invtNo,"20201112100000001");
    }
    @Test
    public void qingdanBackLogic()  { // 逻辑校验通过
        BackQingdanZongshu.backLogic(declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,invtNo,"20201112110000001");
    }
    @Test
    public void qingdanBackPass() { // 放行
        BackQingdanZongshu.backPass(declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,invtNo,"20201120120000001");
    }
    @Test
    public void qingdanBackTax()  { // 税费
        BackTax.backTaxrd(invtNo,Data.ebcCode,600.6,10,30,"20201120130000001");
    }
    @Test
    public void qingdanErrorItem() { // 清单和订单表体不一致(申报终止,可重推)
        BackQingdanZongshu.errorItem(declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,invtNo,"20201112140000001");
    }
    @Test
    public void qingdanErrorLimit(){ // 海关超限(申报失败,不可重推)
        BackQingdanZongshu.errorLimit(declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,invtNo,"20201112150000001");
    }
}
