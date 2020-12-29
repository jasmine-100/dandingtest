package utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/22 9:15
 */
public class UtilsExcel {

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

    // 写入excel
    public static void writeExcel(String filepath,int sheetIndex,int row ,int col,String str){
        WritableWorkbook workbook1 = null;
        try {
            Workbook workbook = Workbook.getWorkbook(new File(filepath));
            workbook1 = Workbook.createWorkbook(new File(filepath),workbook);
            WritableSheet sheet1 = workbook1.getSheet(sheetIndex);
            Label label = new Label(col,row,str);
            sheet1.addCell(label);
            workbook1.write();
            workbook1.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
