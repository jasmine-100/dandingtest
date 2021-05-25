package utils.util;

import com.alibaba.fastjson.JSON;
/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:39
 */
public class UtilJson {

    // 从json字符串获取指定字段的值
    public static String getValueFromJson(String jsonStr,String key){
        String data = JSON.parseObject(jsonStr).get(key).toString();
        return data;
    }

}
