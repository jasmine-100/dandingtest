package client;

import org.apache.http.Consts;
import org.apache.http.Header;
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
import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author： jasmine
 * @Description : OMS推送订单接口（已调试完成）
 * @Date : Created in 2020/7/20 11:15
 */
public class ApiClient {
    private static String url;
    private static CloseableHttpClient client = null;
    private static HttpGet get =null;
    private static HttpPost post = null;
    private static HttpResponse response= null;

    public ApiClient(String url){
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        get = new HttpGet(url);
    }

    public static String doPostXml(String url,Object params,Object head,Object body) throws Exception {
        client = HttpClients.createDefault();
        post = new HttpPost(url);

        String responseStr = null;

        //组装params参数
        if(params!=null){
            Map<String,Object> map = JavaBeanUtils.convertBeanToMap(params);
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            for (String key : map.keySet()) {
                paramList.add(new BasicNameValuePair(key, map.get(key).toString()));
                System.out.println(key+":"+map.get(key).toString());
            }
            String str = EntityUtils.toString(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
            System.out.println(str);
            post = new HttpPost(url+"?"+str);
        }

        //组装head参数
        if(head!=null) {
            System.out.println(head);
//            post.setHeader("Content-Type", "application/x-www-form-urlencoded");
            Map<String, Object> map = JavaBeanUtils.convertBeanToMap(head);
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            for (String key : map.keySet()) {
                paramList.add(new BasicNameValuePair(key, map.get(key).toString()));
            }
            // 模拟表单
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
            post.setEntity(entity);
        }

        //组装body参数(xml格式)
        if (body != null){
            System.out.println(body);
            //组装xml参数
            StringEntity entity2 = new StringEntity(body.toString(), "utf-8");// 解决中文乱码问题
            post.setEntity(entity2);
        }

        response = client.execute(post);
        responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(responseStr);
        return responseStr;
    }

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
            e.printStackTrace();
        }
        return responseStr;
    }

    public String doPostForm(Object data) throws IOException {
        String responseStr = null;
        if(data!=null){
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
            }catch (Exception e){
//            log.error("出错了");
                e.printStackTrace();
            }
        }
        response = client.execute(post);
        responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(responseStr);
        return responseStr;
    }

    public String doGetUrl() throws IOException {
        String responseStr = null;

        get.setHeader("Content-Type", "application/x-www-form-urlencoded");
        response = client.execute(get);

        responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(responseStr);
        return responseStr;
    }

}
