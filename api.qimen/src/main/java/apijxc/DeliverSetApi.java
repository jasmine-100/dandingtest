package apijxc;

import client.ApiClient;
import domain.Method;
import domain.Param;
import domain.deliver.*;
import domain.stockin.SenderInfo;
import org.junit.Test;
import utils.XmlUtil;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/27 9:54
 */
public class DeliverSetApi {
    String url = "http://outtest.order.yang800.cn/qimen/api";

    //仓库编码：取经销存系统的逻辑仓编码
    String whCode = "LSXKOGSI7E";
    //用不上，可以不填
    String ownerCode = "GL01";
    //外部订单号，相同货主内唯一
    String orderno = "JOS2020073102";
    //yang-test的外部店铺的outkey（去掉QM）
    String customerId = "C1590459235731";

    //进销存存在的店铺名称
    String shopName = "小店";

    @Test
    public void deliverOrder() throws Exception {
        // 组装body的商品项
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(orderno,ownerCode,"xhs950001","",100,10));

        // 组装body的订单项
        DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK",whCode,shopName,orderLines,"SF",new SenderInfo(),new ReceiverInfo());

        // 组装body消息体
        DeliverData deliverData = new DeliverData(deliveryOrder,orderLines);

        // 组装接口参数
        Param param = new Param(Method.DELIVER,customerId);

        ApiClient.doPostXml(url,param,null, XmlUtil.objToXml(deliverData));
        
    }

    @Test
    public void orderCancel () throws Exception {
        // 接口参数
        Param param = new Param("order.cancel",customerId);
        // 接口消息体
        Cancel cancel = new Cancel(orderno,"JYCK",whCode, ownerCode);

        ApiClient.doPostXml(url,param,null,XmlUtil.objToXml(cancel));
    }
}
