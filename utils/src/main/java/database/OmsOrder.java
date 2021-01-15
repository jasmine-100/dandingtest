package database;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 实体仓和渠道关联平台
 * @Date : Created in 2021/1/12 19:07
 */
public class OmsOrder {

    /**
     *
     * @param wareCode 实体仓编码
     * @param channelCode 渠道编码
     * @return
     */
    // 在数据库中添加实体仓和渠道的对应关系
    public static boolean insertPlatform(String wareCode,String channelCode){
        String orderSn = null;
        Connection connection = null;
        Statement statement = null;
        boolean flag = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://rm-uf6tn16nrn673xbb0bo.mysql.rds.aliyuncs.com:3306/oms_order","oms","Oms#2020");
            statement = connection.createStatement();
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            flag = statement.execute("INSERT INTO o_way_bill_platform VALUES('0','"+wareCode+"','"+channelCode+"','DEFAULT','"+time+"','"+time+"',0,0,0);");
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

    @Test
    public void test(){
        insertPlatform("DTS6a3036","V2");
    }

}
