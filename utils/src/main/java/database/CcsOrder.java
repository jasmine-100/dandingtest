package database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/9 14:15
 */
public class CcsOrder {

    // 清关单：根据申报单号查询订单sn
    public static String getOrderSn(String declareOrderNo){
        String orderSn = null;
        try {
            String sql = "SELECT sn from ccs_customs_inventory_2020q3 WHERE declare_order_no=\""+declareOrderNo+"\"";
            ResultSet resultSet = database(sql);
            while (resultSet.next()){
                orderSn = resultSet.getString("sn");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderSn;
    }

    /**
     * 连接ccs测试库
     * @param sql  查询语句
     * @return
     */
    static ResultSet database(String sql){
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://10.99.111.83:3306/ccs_order","root","ENPInr4GJRefShEI");
            System.out.println(connection.isClosed());
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
