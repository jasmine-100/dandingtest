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
//            connection = DriverManager.getConnection("jdbc:mysql://10.98.149.233:3306/ccs_order","mysql","x66as9tT8Cl2FHA1");//预发环境
            connection = DriverManager.getConnection("jdbc:mysql://192.168.20.215:3306/ccs_order","root","Dd82727893!p");//测试环境
            statement = connection.createStatement();
            String sql = "SELECT sn from ccs_customs_inventory_"+getDate()+" WHERE declare_order_no=\""+declareOrderNo+"\"";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);
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
        int reason = month/3+1;
        return year+"q"+reason;
    }

    @Test
    public void test(){
        System.out.println(getOrderSn("JOS20210401092540324"));
    }

}
