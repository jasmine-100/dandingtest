package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 常用时间戳工具
 * @Date : Created in 2020/9/4 11:10
 */
public class UtilTime {

    /**
     * @param time  yyyyMMddHHmmss 格式
     * @return 返回时间戳
     * @throws ParseException
     */
    public static long getTime(String time){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long timestamp = calendar.getTimeInMillis();
        return timestamp;
    }


}
