package casetest;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domainout.good.Good;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/22 16:12
 */
public class GoodApi {

    // 添加商品
    @Test
    public void goodAdd() {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(BaseParam.FILEPATH));
            Sheet sheet = workbook.getSheet(0);
            for (int i =1; i < sheet.getRows(); i++) {
                String goodname = sheet.getCell(0,i).getContents();
                String goodno = sheet.getCell(1,i).getContents();
                String barcode = sheet.getCell(2,i).getContents();
                String type = sheet.getCell(3,i).getContents();
                String isbatch = sheet.getCell(4,i).getContents();
                String brand = sheet.getCell(5,i).getContents();
                String price = sheet.getCell(6,i).getContents();

                Good good = new Good(goodno,barcode,goodname,brand,isbatch,type,price);
//                System.out.println(JSON.toJSON(good));
                ApiClient.doPostJson(BaseParam.GOOD_ADD,null, BaseParam.getCookie(),good);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
