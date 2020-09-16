package client;

import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
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
     static String url;
     static CloseableHttpClient client = null;
     static HttpGet get =null;
     static HttpPost post = null;
     static HttpResponse response= null;

    public static String doPostForm(String URL,Object params,Map<String,Object> head,Object body){
        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;

        setParams(params);
        setHead(head);
        setForm(body);

        try {
            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    public static String doPostJson(String URL,Object params,Map<String,Object> head,Object body){
        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;
//        System.out.println(url);

        setParams(params);
        setHead(head);
        setJson(body);

        try {
            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    public static String doPostXml(String URL,Object params,Map<String,Object> head,Object body) throws Exception {
        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;

        setParams(params);
        setHead(head);
        setXml(body);

        response = client.execute(post);
        responseStr = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(responseStr);
        return responseStr;
    }

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

    static void setHead(Map<String,Object> head){
        //组装head参数
        if(head!=null) {
            for (String key : head.keySet()) {
                post.addHeader(key,head.get(key).toString());
            }
        }
    }

    static void setParams(Object params){
        //组装params参数
        if(params!=null){
            Map<String,Object> map = null;
            try {
                map = JavaBeanUtils.convertBeanToMap(params);
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : map.keySet()) {
                    paramList.add(new BasicNameValuePair(key, map.get(key).toString()));
                }
                String str = EntityUtils.toString(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
                post = new HttpPost(url+"?"+str);
//            System.out.println(url+"?"+str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static void setForm(Object body){
        if(body!=null){
            try{
//                System.out.println(body);
                post.setHeader("Content-Type", "application/x-www-form-urlencoded");
                Map<String,Object> map = JavaBeanUtils.convertBeanToMap(body);
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : map.keySet()) {
                    paramList.add(new BasicNameValuePair(key, map.get(key).toString()));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                post.setEntity(entity);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    static void setJson(Object body){
        if(body!=null){
//            System.out.println("请求数据："+JSON.toJSON(body).toString());
            StringEntity entity = new StringEntity(JSON.toJSON(body).toString(), "utf-8");// 解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
        }
    }

    static void setXml(Object body){
        //组装body参数(xml格式)
        if (body != null){
//            System.out.println(body);
            //组装xml参数
            HttpEntity entity2 = new StringEntity(body.toString(),"utf-8");// 解决中文乱码问题
            post.addHeader("Context-Type","text/xml;charset=UTF-8");
            post.setEntity(entity2);
        }
    }

}
