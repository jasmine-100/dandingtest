package api;

import client.ApiClient;
import domain.Stock;
import jxc.BaseParam;
import domain.Good;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author： jasmine
 * @Description : 添加备案商品
 * @Date : Created in 2020/8/12 14:23
 */
public class GoodStockApi {

    // 单一添加商品备案和账册库存
    @Test
    public void addGoodAndStock() {
        // 添加备案商品
        try {
            Workbook workbook = Workbook.getWorkbook(new File(Data.FILEPATH));
            Sheet sheet = workbook.getSheet(0);
            for (int i=1;i<sheet.getRows();i++){
                String skuNo = sheet.getCell(0,i).getContents();
                String productId = sheet.getCell(1,i).getContents();
                String goodsSeqNo = sheet.getCell(2,i).getContents();
                String goodName = sheet.getCell(3,i).getContents();
                String bookId = sheet.getCell(4,i).getContents();

                // 添加商品备案
                Good good = new Good(skuNo,goodName,productId,bookId);
                ApiClient.doPostJson(BaseParam.URL_GOOD,null,null,good);

                // 添加账册库存
                Stock stock = new Stock(goodsSeqNo,goodName,productId,bookId);
                ApiClient.doPostJson(BaseParam.URL_STOCK,null,null,stock);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
