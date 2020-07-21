package apiout;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : 清单回执报文，未完成
 * @Date : Created in 2020/7/20 13:11
 */
public class BackApi {
    static String url = "http://ccs.backend.daily.yang800.com/xhr/order/mockReceive";

    //总署回执：逻辑校验通过
    public static void backVertifyPass(String orderNo) throws IOException {

    }

    //总署回执：新增校验成功
    public void backDeclareSuccess(String orderNo){


    }

    //总署回执：放行
    public void backPass(String orderNo){


    }

    //总署回执：税费
    public void backTaxrd(String orderNo){

    }

    //口岸回执
    public void backDealSuccess(){

    }
}
