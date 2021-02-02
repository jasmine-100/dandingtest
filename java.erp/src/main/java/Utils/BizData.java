package Utils;

import com.alibaba.fastjson.JSON;
import com.google.common.io.BaseEncoding;
import lombok.Data;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/15 10:00
 */
@Data
public class BizData {
    String v;
    String sign;
    String bizData;
    String partnerId;
    String serviceName;

    public BizData(Object object, String serviceName, String partnerId, String token) {
        String originData = JSON.toJSONString(object);
        this.v = "2.0";
        this.partnerId = partnerId;
        this.serviceName = serviceName;
        this.bizData = BaseEncoding.base64().encode(originData.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("bizData="+bizData);
        stringBuffer.append("partnerId="+partnerId);
        stringBuffer.append("serviceName="+serviceName);
        stringBuffer.append("v="+v);
        stringBuffer.append(token);
        this.sign = MD5Util.stringToMD5(stringBuffer.toString());
    }

}
