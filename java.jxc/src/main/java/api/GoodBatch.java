package api;

import jxl.Workbook;
import jxl.Cell;
import jxl.Sheet;
import org.junit.jupiter.api.Test;

import java.io.File;


/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/21 17:57
 */
public class GoodBatch {

    // 读取excel
    public void readExcel(String pathname,int row){
        try {
            Workbook workbook = Workbook.getWorkbook(new File(pathname));
            Sheet sheet = workbook.getSheet(0);
            for (int i=row;i<sheet.getRows();i++){
                for (int j=0;j<sheet.getColumns();j++){
                    Cell cell = sheet.getCell(j,i);
                    System.out.print(cell.getContents());
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 连接数据库并写入数据
    public void writeDataBase(){

    }


    @Test
    public void test(){
        readExcel("C:/Users/jasmine/Desktop/jxc.xls",0);
    }
}
