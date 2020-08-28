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
        map.put("Cookie","_ga=GA1.2.1004578877.1598319387; web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6Imphc21pbmUiLCJhdWQiOiIqLnlhbmc4MDAuY29tIiwiZXhwIjoxNTk4NjI2MTM0LCJuYmYiOjE1OTg1OTM3MzQsImlhdCI6MTU5ODU5MzczNCwianRpIjoiXCJmNTY0Mjg3Mi1mNTczLTQzMzEtODc1MS0yYmFhZWIzZmI4MzdcIiIsInVzZXIiOnsidXNlcklkIjozLCJ1c2VyTmFtZSI6Imphc21pbmUiLCJzdXBlclVzZXIiOnRydWUsInJvbGVzIjpbXSwic3lzdGVtIjoiT01TX1NVUFBMWSIsImxvZ2luVGltZSI6MTU5ODU5MzczNDYxNSwidmFsaWRUaW1lIjoxNTk4NjI2MTM0NjE1LCJyZWZyZXNoVGltZSI6MTU5ODYwNDUzNDYxNSwiZXh0ZW5kIjp7InVzZXJJZCI6MywidXNlck5hbWUiOiJqYXNtaW5lIiwibWFzdGVyIjp0cnVlfX19.fgVFFovmSskFapaaSnzEZYwebKGUCjZ6JGU7xjugcsE");
        return map;
    }

}
