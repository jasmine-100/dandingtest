package utils.util;

import org.testng.annotations.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

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
    public static long getTime(String time){
        java.util.Date date = null;
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

    /**
     *
     * @param smdate 较小时间
     * @param bdate 较大时间
     * @return 时间差-天数
     * @throws ParseException
     */
    public static int daysBetween(String smdate,String bdate)
    {
        long between_days = 0;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Date date1 = Date.valueOf(smdate);
            Date date2 = Date.valueOf(bdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(date2);
            long time2 = cal.getTimeInMillis();
            between_days=(time2-time1)/(1000*3600*24);
        }catch (Exception e){
            e.printStackTrace();
        }

        return Integer.parseInt(String.valueOf(between_days));
    }

    @Test
    public void test(){
//        System.out.println(getTime("yyyyMMddHHmmss","20200901100101"));
//        System.out.println(getTime("yyyy.MM.dd","2020.9.1"));
//        System.out.println(addDate("2021-01-02",200));
        System.out.println(daysBetween("2020-10-10","2022-10-20"));
//        System.out.println(daysBetween("2021-02-05","2022-10-20"));
    }
}
