package utils.database;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/9 14:15
 */
public class CcsOrder {

    // 清关单：根据申报单号查询订单sn（需连VPN）
    public static String getOrderSn(String declareOrderNo){
        String orderSn = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://10.99.111.83:3306/ccs_order","root","ENPInr4GJRefShEI");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT sn from ccs_customs_inventory_"+getDate()+" WHERE declare_order_no=\""+declareOrderNo+"\"");
            while (resultSet.next()){
                orderSn = resultSet.getString("sn");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return orderSn;
    }

    /**
     * 2020年第一季度格式：2020q1
     * @return 当前年+季度
     */
    public static String getDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
        int month = Calendar.MONTH+1;
        int reason = month%3==0?month/3:month/3+1;
        return year+"q"+reason;
    }

    @Test
    public void test(){
        System.out.println(getOrderSn("DOS0909150322"));
    }

}