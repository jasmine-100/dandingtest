package dao;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author： jasmine
 * @Description : 获取进销存用户端cookie
 * @Date : Created in 2020/8/25 16:08
 */
public class Cookie {

    public static Map<String,Object> getCookie(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("Cookie","web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6ImFkbWluIiwiYXVkIjoiKi55YW5nODAwLmNvbSIsImV4cCI6MTU5ODM1OTY0MCwibmJmIjoxNTk4MzI3MjQwLCJpYXQiOjE1OTgzMjcyNDAsImp0aSI6ImE1ZTJlYjIxLTA0MjItNDY1Yy05MGJiLTAyNTg3NzhiNDNhYyIsInVzZXIiOnsidXNlcklkIjoxLCJ1c2VyTmFtZSI6ImFkbWluIiwic3VwZXJVc2VyIjp0cnVlLCJyb2xlcyI6WzQwLDQyXSwic3lzdGVtIjoiT01TX1NFUlZFUiIsImxvZ2luVGltZSI6MTU5ODMyNzI0MDc3NSwidmFsaWRUaW1lIjoxNTk4MzU5NjQwNzc1LCJyZWZyZXNoVGltZSI6MTU5ODMzODA0MDc3NSwiZXh0ZW5kIjoiIn19.VsqDRsEEIHr37m-dIb8ZcbEcfCV4NdlnT3O29vqeZu8");
        return map;
    }

}
