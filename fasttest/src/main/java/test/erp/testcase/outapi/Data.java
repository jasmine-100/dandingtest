package test.erp.testcase.outapi;

public class Data {

    //erp内部接口域名
//    public static String url = "https://ares-admin.yang800.com";//预发环境
    public static String url = "https://ares-admin.yang800.com.cn";//测试环境

    public static String URL = url+"/ares-admin/open/inEntrance";//erp内部:奇门下单接口
    public static String urlStockin = url + "/ares-admin/open/dtInStockCallback";//erp内部:wms入库回执接口
    public static String urlStockout = url + "/ares-admin/open/dtOutStockCallback";//erp内部:wms出库回执接口

    public String warehouseCode = "DT_JYWMS1230";//  金义完税仓
    // 哈哈科技有限公司
//    public String logicWarehouseCode = "JHS71d3a7TuoguanQ";//托管仓(强效期)
//    public String ownerCode = "TuoguanQ";//托管仓(强效期)

//    public String logicWarehouseCode = "JHScb94e5Tuoguan";//托管仓(非强效期)
//    public String ownerCode = "Tuoguan";//托管仓(非强效期)

//    public String logicWarehouseCode = "JHSd2adfeJinyiQ";//金义仓(强效期)
//    public String ownerCode = "JinyiQ";//金义仓(强效期)
//
//    public String logicWarehouseCode = "JHS48b9e1Jinyi";//金义仓(非强效期)
//    public String ownerCode = "Jinyi";//金义仓(非强效期)

    public String logicWarehouseCode = "JHS0db4f9baishengqimen";//百胜奇门仓
    public String ownerCode = "baishengqimen";//百胜奇门货主


//    public String warehouseCode = "DT_HNWMS";//  海南保税仓的wms编码

}
