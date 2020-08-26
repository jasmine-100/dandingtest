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
        map.put("Cookie","web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6Imphc21pbmUiLCJhdWQiOiIqLnlhbmc4MDAuY29tIiwiZXhwIjoxNTk4NDM2MDM0LCJuYmYiOjE1OTg0MDM2MzQsImlhdCI6MTU5ODQwMzYzNCwianRpIjoiY2Y0MDQ3ZWItYjQ5MC00OWFkLWFmZjItZjYwMWZhYWY5Nzk3IiwidXNlciI6eyJ1c2VySWQiOjMsInVzZXJOYW1lIjoiamFzbWluZSIsInN1cGVyVXNlciI6dHJ1ZSwicm9sZXMiOltdLCJzeXN0ZW0iOiJPTVNfU1VQUExZIiwibG9naW5UaW1lIjoxNTk4NDAzNjM0MTg0LCJ2YWxpZFRpbWUiOjE1OTg0MzYwMzQxODQsInJlZnJlc2hUaW1lIjoxNTk4NDE0NDM0MTg0LCJleHRlbmQiOnsidXNlcklkIjozLCJ1c2VyTmFtZSI6Imphc21pbmUiLCJtYXN0ZXIiOnRydWV9fX0.WCxlZ31OgmD1YM6Snz5Mut2nzJmD_CFBs5qB6CchBIM");
        return map;
    }

}
