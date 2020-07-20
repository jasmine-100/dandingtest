package utils;

import domain.good.Good;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/7/20 12:41
 */
public class ExcelUtils {
    public static List<Good> readGoods() throws IOException {
        List<Good> goodList = new ArrayList<Good>();
        Workbook workbook = WorkbookFactory.create(new File("./file/goods.xls"));
        Sheet sheet = workbook.getSheetAt(0);
        for(int i=1;i<=sheet.getLastRowNum();i++){
            Good good = null;
            Row row = sheet.getRow(i);
            String procode = row.getCell(0).toString();
            String name = row.getCell(1).toString();
            String isbatch = row.getCell(2).toString();
            String exdate = null;
            if(isbatch.equals("1")){
                exdate = row.getCell(3).toString();
            }
            String reprice = row.getCell(4).toString();
            String brand = row.getCell(5).toString();
            good = new Good(procode,name,isbatch,exdate,reprice,brand);
            goodList.add(good);
        }
        return goodList;
    }
}
