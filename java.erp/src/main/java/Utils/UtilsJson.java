package Utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:39
 */
public class UtilsJson {

    public static Object getJsonStr(String jsonStr,String key){
        JSONObject jsondata = JSONObject.parseObject(jsonStr);
        JSONObject result = (JSONObject) jsondata.get("result");
        Object data = result.get(key);
        return data;
    }
}
