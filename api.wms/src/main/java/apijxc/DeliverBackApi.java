package apijxc;

import client.ApiClient;
import domain.ParamsWms;
import domain.ServiceType;
import domain.deliver.DeliverData;
import domain.deliver.Product;
import org.junit.jupiter.api.Test;
import utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/24 9:01
 */
public class DeliverBackApi {

    //发货单回执--进销存
    @Test
    public void deliverBack2() throws Exception {
        String url = "http://hwms-notify-fat.yang800.com/dt/notify";
        String whCode = "01";
        String hzid = "GL01";
        //系统自动生成的出库单号
        String orderno = "OB20200731181007036592";

        List<Product> products = new ArrayList<>();
        products.add(new Product("sku07301047","",10,"2020-1-2","2020-9-1","ZP"));

        //组装bizdata
        DeliverData deliverData = new DeliverData(orderno,whCode,"ZTO",1.68,hzid,products);

        //组装请求参数
        ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), ServiceType.DELIVER_BACK,"1.0");

        System.out.println(param);
        ApiClient.doPostXml(url,param,null,null);
    }



}
