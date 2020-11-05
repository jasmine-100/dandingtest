package casetest;

import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/5 16:34
 */
public class OrderCaseTotal {

    @Test
    public void order(){
        // 下单
        OrderSet.orderSet();

        //订单回执
        OrderDingdanCase.backAddOk();
        OrderDingdanCase.backLogic();

        //运单回执
        OrderYundanCase.backAddOk();
        OrderYundanCase.backLogic();

        // 清单回执
        OrderQingdanCase.backAddOk();
        OrderQingdanCase.backLogic();
        OrderQingdanCase.backPass();

        //税费回执
        OrderQingdanCase.backTax();
    }
}
