package utils.client.gatewayDTO;

import com.alibaba.fastjson.JSON;
import com.github.kevinsawicki.http.HttpRequest;
import lombok.Getter;
import utils.util.MD5Util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Dante-GXJ
 * @Date: 2020/10/15 10:07
 * @Description:
 */
@Getter
public class GatewayHttpClient {

    private String host;

    private String clientId;

    private String clientSecret;

    private Boolean loginFlag;

    public GatewayHttpClient(String host, String clientId, String clientSecret, Boolean loginFlag) {
        this.host = host;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.loginFlag = loginFlag;
    }
    public static String send(GatewayHttpClient client, String uri, String token, Object obj) {
        String body = JSON.toJSONString(obj);

        Long timestamp = System.currentTimeMillis();
        String version = "1.0.0";

        String data = MD5Util.stringToMD5(body).toUpperCase();
        if ("{}".equals(body)){
            data = "";
        }

        Map<String, String> params= new HashMap<String, String>();
        params.put("timestamp",timestamp + "");
        params.put("path", uri);
        params.put("clientId", client.getClientId());
        params.put("version", version);
        params.put("data", data);

        List<String> storedKeys = Arrays.stream(params.keySet()
                .toArray(new String[]{}))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        final String sign = storedKeys.stream()
                .map(key -> String.join("", key, params.get(key)))
                .collect(Collectors.joining()).trim()
                .concat(client.getClientSecret());
        String finalSign = MD5Util.stringToMD5(sign).toUpperCase();
        Map<String,String> headers = new HashMap<String, String>();
        headers.put("timestamp", timestamp + "");
        headers.put("clientId",client.getClientId());
        headers.put("sign",finalSign);
        headers.put("Content-Type", HttpRequest.CONTENT_TYPE_JSON);
        headers.put("accessToken",token);
        System.out.println("header:" + JSON.toJSONString(headers));
        try{
            HttpRequest httpRequest = HttpRequest.post(client.getHost() + uri).headers(headers).send(body);
            if (httpRequest.ok()){
//                System.out.println(httpRequest.body());
                return (httpRequest.body());
            }else {
                return ("HTTP状态码：" + httpRequest.code());
            }
        }catch (Exception e){
            return ("Http 请求失败");
        }
    }
}
