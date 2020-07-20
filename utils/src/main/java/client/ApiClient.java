package client;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author： jasmine
 * @Description : OMS推送订单接口（已调试完成）
 * @Date : Created in 2020/7/20 11:15
 */
public class ApiClient {
    private String url;

    private CloseableHttpClient client = null;
    private HttpPost post = null;
    private HttpResponse response= null;
    private HttpGet get =null;

    public ApiClient(String url){
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        get = new HttpGet(url);
    }

    public String doPostJson(Object data) throws IOException {
        String responseStr = null;
        try{
            System.out.println("请求数据："+data);
            StringEntity entity = new StringEntity(data.toString(), "utf-8");// 解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            System.out.println(entity);

            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(responseStr);
        }catch (Exception e){
//            log.error("出错了");
            e.printStackTrace();
        }
        return responseStr;
    }
}
