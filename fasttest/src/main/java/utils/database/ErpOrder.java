package utils.database;

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

    // 出入库单状态变更：待出库/待入库-->出库中/入库中
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
//            connection = DriverManager.getConnection("jdbc:mysql://10.99.208.36/erp_order","mysql","JZeHrutBJxFUIy4B");//测试环境
            connection = DriverManager.getConnection("jdbc:mysql://10.98.149.233/erp_order","mysql","x66as9tT8Cl2FHA1");//预发环境
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
        int month = Calendar.MONTH+1;
        int reason = month%3==0?month/3:month/3+1;
        return year+"0"+reason;
    }
}
