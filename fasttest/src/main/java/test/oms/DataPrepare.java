package test.oms;

import org.testng.annotations.Test;
import utils.database.OmsOrder;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/20 11:45
 */
public class DataPrepare{

    // 在数据库中添加实体仓和渠道的对应关系
    @Test
    public static void createPlatform(){
        OmsOrder.insertPlatform("BJCQfefd9d","V2");
    }

    // 添加快递公司和快递100的物流合作
    @Test
    public static void createExpress(){
        OmsOrder.insertExpress("ZTO","zhongtong");
    }
}
