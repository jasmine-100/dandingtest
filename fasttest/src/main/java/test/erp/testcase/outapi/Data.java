package test.erp.testcase.outapi;

public class Data {

    //erp内部奇门接口
    public String URL = "http://ares-admin.yang800.com/ares-admin/open/inEntrance";
//    String outShopId = "";// 店铺ID

    //erp内部wms回执接口
    public static String url = "https://ares-admin.yang800.com";
    public static String urlStockin = url + "/ares-admin/open/dtInStockCallback";
    public static String urlStockout = url + "/ares-admin/open/dtOutStockCallback";


    // 哈哈科技有限公司
    public String warehouseCode = "DT_JYWMS1230";//  金义完税仓

    public String logicWarehouseCode = "JHS71d3a7TuoguanQ";//托管仓(强效期)
    public String ownerCode = "TuoguanQ";//托管仓(强效期)

//    public String logicWarehouseCode = "JHScb94e5Tuoguan";//托管仓(非强效期)
//    public String ownerCode = "Tuoguan";//托管仓(非强效期)

//    public String logicWarehouseCode = "JHSd2adfeJinyiQ";//金义仓(强效期)
//    public String ownerCode = "JinyiQ";//金义仓(强效期)
//
//    public String logicWarehouseCode = "JHS48b9e1Jinyi";//金义仓(非强效期)
//    public String ownerCode = "Jinyi";//金义仓(非强效期)


//    public String warehouseCode = "DT_HNWMS";//  海南保税仓的wms编码

}
