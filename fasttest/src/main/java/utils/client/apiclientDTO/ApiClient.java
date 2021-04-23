package utils.client.apiclientDTO;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import utils.client.apiclientDTO.DataSet;

import java.io.IOException;
import java.util.Map;

/**
 * @Author： jasmine
 * @Description : OMS推送订单接口（已调试完成）
 * @Date : Created in 2020/7/20 11:15
 */
public class ApiClient {
     static String url;
     static CloseableHttpClient client = null;
     static HttpGet get =null;
     static HttpPost post = null;
     static HttpResponse response= null;

     // form表单
    public static String doPostForm(String URL,Object params,Map<String,Object> head,Object body){
        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;

        DataSet.setParams(post,url,params);
        DataSet.setHead(post,head);
        DataSet.setForm(post,body);

        try {
            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    // json格式
    public static String doPostJson(String URL,Object params,Map<String,Object> head,Object body){
        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;

        DataSet.setParams(post,url,params);
        DataSet.setHead(post,head);
        DataSet.setJson(post,body);

        try {
            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    // xml格式
    public static String doPostXml(String URL,Object params,Map<String,Object> head,Object body) {
        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;

        post = DataSet.setParams(post,url,params);
        DataSet.setHead(post,head);
        DataSet.setXml(post,body);

        try {
            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(responseStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseStr;
    }

    // get请求
    public static String doGetUrl(String URL) throws IOException {
        url = URL;
        get = new HttpGet(url);
        String responseStr = null;

        get.setHeader("Content-Type", "application/x-www-form-urlencoded");
        response = client.execute(get);

        responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println(responseStr);
        return responseStr;
    }

}
