package test.oms.testcase.dto.order;

import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.Test;
import utils.util.ExcelUtils;
import utils.util.UtilsTime;

import java.io.File;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/20 9:04
 */
public class ExcelOrderDTO {

    public void setOrder(){
        try {
            Workbook wb = Workbook.getWorkbook(new File(""));
            Sheet sheet = wb.getSheet("order");
            for(int i=1;i<sheet.getRows();i++){
//                OrderDTO order = new OrderDTO();
//                order.setOutOrderNo(sheet.getCell("outOrderNo").toString());
//                order.setDeclareCode(sheet.getCell("declareOrderNo").toString());
//                order.setOutPayNo(sheet.getCell("outPayNo").toString());
//                order.setOutShopCode(sheet.getCell("outShopCode").toString());
//                order.setOrderTime(UtilsTime.getTime(sheet.getCell("orderTime").toString()));
//                order.setSaleChannel(sheet.getCell("saleChannel").toString());
//                order.setAppCode(sheet.getCell("appCode").toString());




            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
