package test.erp.testcase.outapi.wmsDaita;

import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.Test;
import test.erp.testcase.outapi.Data;
import test.erp.testcase.outapi.wmsDaita.dto.stockin.SkuParam;
import test.erp.testcase.outapi.wmsDaita.dto.stockin.StockinOrder;
import utils.client.apiclientDTO.ApiClient;
import utils.database.ErpOrder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/11/28 17:40
 */
public class WmsStockinApi extends Data {
    String orderno = "ET202104082002140157848510";

    @Test
    public void updateStatusIn(){
        ErpOrder.updateStatus(orderno,"in");
    }

    @Test
    public void backStockin(){
        List<SkuParam> skuParams = new ArrayList<>();
        String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        String sku = "SKU2104082000165";
        skuParams.add(new SkuParam(sku,str+1,100,1,1,"2020-10-10","2022-10-10",false));
        skuParams.add(new SkuParam(sku,str+2,200,1,2,null,null,false));
//        skuParams.add(new SkuParam(sku,str+2,200,1,2,"2020-10-10","2022-10-10",false));
        skuParams.add(new SkuParam(sku,str+3,300,1,3,"2020-10-10","2022-10-10",false));
        skuParams.add(new SkuParam(sku,str+4,400,2,4,"2020-10-10","2022-10-10",false));
        skuParams.add(new SkuParam(sku,str+5,10,1,5,"2020-10-10","2022-10-10",true));
        skuParams.add(new SkuParam(sku,str+6,20,2,6,"2020-10-10","2022-10-10",true));

        StockinOrder stockinOrder = new StockinOrder(orderno,"KJ"+orderno,warehouseCode,ownerCode,1,"1",skuParams,"2020-10-10 12:00:00","2021-01-27 10:00:00");

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
