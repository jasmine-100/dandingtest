package test.erp.testcase.wmsdaita;

import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.Test;
import test.erp.testcase.wmsdaita.dto.stockin.SkuParam;
import test.erp.testcase.wmsdaita.dto.stockin.StockinOrder;
import utils.client.apiclientDTO.ApiClient;
import utils.database.ErpOrder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:40
 */
public class WmsStockinApi extends Data {
    String orderno = "ET202103160943330346195638";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        skuParams.add(new SkuParam("SKU202103150","202103081736",100,1,1,"2020-10-10","2022-10-10",false));
        skuParams.add(new SkuParam("SKU202103151","202103081751",100,1,2,"2020-10-10","2022-10-10",false));

        StockinOrder stockinOrder = new StockinOrder(orderno,"KJ"+orderno,warehouseCode,ownerCode,0,"1",skuParams,"2020-10-10 12:00:00","2021-01-27 10:00:00");

        ApiClient.doPostJson(urlStockin,null,null,stockinOrder);
    }

    // 读取excel商品参数
    @Test
    public void backStockin2() {
        List<SkuParam> skuParams = new ArrayList<>();
        try {
            String excelFileName = "C:/Users/jasmine/Desktop/比瑞吉入库单回传参数.xls";
            Workbook wb = Workbook.getWorkbook(new File(excelFileName));
            Sheet sheet = wb.getSheet(0);
            for (int i =1;i<sheet.getRows();i++){
                String sku = sheet.getCell(0,i).getContents();
                int num = Integer.valueOf(sheet.getCell(1,i).getContents());
                String productDate = sheet.getCell(2,i).getContents();
                String expireDate = sheet.getCell(3,i).getContents();
                int inventoryType = Integer.valueOf(sheet.getCell(4,i).getContents());
                String bathcode = sheet.getCell(5,i).getContents();
                SkuParam skuParam = new SkuParam(sku,bathcode,num,inventoryType,i,productDate,expireDate,false);
                skuParams.add(skuParam);
//                System.out.println(skuParam);
            }
            StockinOrder stockinOrder = new StockinOrder("ET202103101012330805255279","ASN210310000005","DT_MNWMS0308","JJCS",0,"1",skuParams,"2020-10-10 12:00:00","2021-01-27 10:00:00");

            ApiClient.doPostJson(urlStockin,null,null,stockinOrder);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
