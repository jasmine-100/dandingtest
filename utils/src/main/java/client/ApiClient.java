package client;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import utils.JavaBeanUtils;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

//    public String doPostXml(String xmlString) throws IOException {
//        String responseStr = null;
//        post.setHeader("Content-Type","text/xml");
//        post.setHeader("charset","utf-8");
//
//        StringEntity entity = new StringEntity(xmlString, "utf-8");
//        post.setEntity(entity);
//        System.out.println(entity);
//
//        response = client.execute(post);
//        responseStr = EntityUtils.toString(response.getEntity(),"UTF-8");
//        System.out.println(responseStr);
//
//        return responseStr;
//    }

    public String doPostJson(Object data) throws IOException {
        String responseStr = null;
        try{
            System.out.println("请求数据："+data);
            StringEntity entity = new StringEntity(data.toString(), "utf-8");// 解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);

            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(responseStr);
        }catch (Exception e){
//            log.error("出错了");
            e.printStackTrace();
        }
        return responseStr;
    }

    public String doPostForm(Object data) throws IOException {
        String responseStr = null;
        try{
            System.out.println(data);
            post.setHeader("Content-Type", "application/x-www-form-urlencoded");
            Map<String,Object> map = JavaBeanUtils.convertBeanToMap(data);
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            for (String key : map.keySet()) {
                paramList.add(new BasicNameValuePair(key, map.get(key).toString()));
            }
            // 模拟表单
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");

            post.setEntity(entity);
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
