package database;

import utils.UtilsTime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/12/24 16:40
 */
public class ErpOrder {

    public static boolean updateStatus(String orderNo,String type){
        boolean flag = false;
        String sql = null;
        if (type.equals("in")){
            sql = "UPDATE erp_in_order_"+ getDate() +" SET `status` = 15 WHERE in_order_no= '"+orderNo+"'";
        }
        if (type.equals("out")){
            sql = "UPDATE erp_out_order_"+ getDate() +" SET `status` = 15 WHERE out_order_no= '"+orderNo+"'";
        }

        String orderSn = null;
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://10.99.208.36/erp_order","mysql","JZeHrutBJxFUIy4B");
            statement = connection.createStatement();
            flag = statement.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 2020年第一季度格式：202001
     * @return 当前年+季度
     */
    public static String getDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int reason = (calendar.get(Calendar.MONTH+1)+2)/3;
        return year+"0"+reason;
    }
}
