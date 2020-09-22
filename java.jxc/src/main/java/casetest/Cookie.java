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
        map.put("Cookie","_ga=GA1.2.1004578877.1598319387; web-token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJkZCIsInN1YiI6Imphc21pbmUxMCIsImF1ZCI6IioueWFuZzgwMC5jb20iLCJleHAiOjE2MDA3Njk2MzcsIm5iZiI6MTYwMDczNTQzNywiaWF0IjoxNjAwNzM3MjM3LCJqdGkiOiI5N2M3ZmFiMy1kMzI5LTQ3ZDktYTRjNS1kYTVmNDk4NDE4YzAiLCJ1c2VyIjp7InVzZXJJZCI6MTQ0LCJ1c2VyTmFtZSI6Imphc21pbmUxMCIsInN1cGVyVXNlciI6dHJ1ZSwicm9sZXMiOltdLCJzeXN0ZW0iOiJPTVNfU1VQUExZIiwibG9naW5UaW1lIjoxNjAwNzM3MjM3Mzk3LCJ2YWxpZFRpbWUiOjE2MDA3Njk2MzczOTcsInJlZnJlc2hUaW1lIjoxNjAwNzQ4MDM3Mzk3LCJleHRlbmQiOnsidXNlcklkIjoxNDQsInVzZXJOYW1lIjoiamFzbWluZTEwIiwibWFzdGVyIjp0cnVlfX19.16mLSvFS9n7EttMK_Qfp3igu1EYTnuXOw-N3nHqRuPU");
        return map;
    }

}
