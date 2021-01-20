package oms;

import database.OmsOrder;
import org.testng.annotations.Test;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/1/20 11:45
 */
public class DataPrepare {

    // 在数据库中添加实体仓和渠道的对应关系
    @Test
    public static void createPlatform(){
        OmsOrder.insertPlatform("DTS6a3036","V2");
    }

    // 添加快递公司和快递100的物流合作
    @Test
    public static void createExpress(){
        OmsOrder.insertExpress("ZTO","zhongtong");
    }
}
