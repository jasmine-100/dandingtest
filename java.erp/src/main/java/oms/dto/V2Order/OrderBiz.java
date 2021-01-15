package oms.dto.V2Order;

import com.google.common.io.BaseEncoding;
import lombok.Data;
import org.testng.annotations.Test;
import utils.MD5Util;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/15 10:00
 */
@Data
public class OrderBiz {
    String v;
    String sign;
    String bizData;
    String partnerId;
    String serviceName;

    public OrderBiz(String originData,String partnerId,String token) {
        this.v = "2.0";
        this.partnerId = partnerId;
        this.serviceName = "order.out.set";
        this.bizData = BaseEncoding.base64().encode(originData.getBytes());
        this.sign = getSign(v,partnerId,serviceName,bizData,token);
    }

    public String getSign(String v,String partnerId,String serviceName,String bizData,String token) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bizData="+bizData);
        stringBuffer.append("partnerId="+partnerId);
        stringBuffer.append("serviceName="+serviceName);
        stringBuffer.append("v="+v);
        stringBuffer.append(token);
        String sign = MD5Util.MD5(stringBuffer.toString());
        return sign;
    }

}
