package Utils;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 常用时间戳工具
 * @Date : Created in 2020/9/4 11:10
 */
public class UtilsTime {

    /**
     * @param time  yyyyMMddHHmmss 格式
     * @return 返回时间戳
     */
    public static long getTime(String pattern,String time){
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        long timestamp = calendar.getTimeInMillis();
        return timestamp;
    }

    /**
     * 推算日期（当前日期以前或以后多少天）
     * @param date 初始日期 yyyy-MM-dd
     * @param days
     * @return 目标日期
     */
    public static String addDate(String date,int days){
        LocalDate targetDate = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date,formatter);

        if(days>=0){
            targetDate = localDate.plusDays(days);
        }else{
            targetDate = localDate.minusDays(-days);
        }
        return targetDate.toString();
    }

    @Test
    public void test(){
//        System.out.println(getTime("yyyyMMddHHmmss","20200901100101"));
//        System.out.println(getTime("yyyy.MM.dd","2020.9.1"));
        System.out.println(addDate("2020-10-10",10));
    }
}
