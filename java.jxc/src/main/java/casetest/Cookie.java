package casetest;

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
        map.put("Cookie","web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6Imphc21pbmUiLCJhdWQiOiIqLnlhbmc4MDAuY29tIiwiZXhwIjoxNTk4NTMwMTYwLCJuYmYiOjE1OTg0OTc3NjAsImlhdCI6MTU5ODQ5Nzc2MCwianRpIjoiZTRhY2Q2OGQtOWU3Yi00OTZkLTgwOWItOWQ2ZDZhMDI3NGE2IiwidXNlciI6eyJ1c2VySWQiOjMsInVzZXJOYW1lIjoiamFzbWluZSIsInN1cGVyVXNlciI6dHJ1ZSwicm9sZXMiOltdLCJzeXN0ZW0iOiJPTVNfU1VQUExZIiwibG9naW5UaW1lIjoxNTk4NDk3NzYwNDI5LCJ2YWxpZFRpbWUiOjE1OTg1MzAxNjA0MjksInJlZnJlc2hUaW1lIjoxNTk4NTA4NTYwNDI5LCJleHRlbmQiOnsidXNlcklkIjozLCJ1c2VyTmFtZSI6Imphc21pbmUiLCJtYXN0ZXIiOnRydWV9fX0.7Xuu9QXwYd8-dlvy3jj8rD8Y_2v7b95FXpcOCmAxHoU");
        return map;
    }

}
