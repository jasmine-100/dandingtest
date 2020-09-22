package utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/22 9:15
 */
public class ExcelUtils {

    // 读取excel
    public static void getExcel(String pathname){
        try {
            Workbook workbook = Workbook.getWorkbook(new File(pathname));
            Sheet sheet = workbook.getSheet(0);
            for (int i=0;i<sheet.getRows();i++){
                for (int j=0;j<sheet.getColumns();j++){
                    Cell cell = sheet.getCell(j,i);
                    System.out.print(cell.getContents());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
