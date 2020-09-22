package casetest;

import client.ApiClient;
import com.alibaba.fastjson.JSON;
import domainout.good.Good;
import domainout.stockin.PurOrderItem;
import domainout.stockin.PurchaseOrder;
import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.Test;
import utils.UtilTime;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 未完成
 * @Date : Created in 2020/8/26 16:18
 */
public class Purchase {
    String filePath = "C:/Users/jasmine/Desktop/jxc/purchase.xls";

    // 添加商品
    @Test
    public void goodAdd() {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(filePath));
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
                ApiClient.doPostJson(BaseParam.GOOD_ADD,null, Cookie.getCookie(),good);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }

    }

    // 单一商品采购单
    @Test
    public void purchaseAdd() {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(filePath));
            Sheet sheet = workbook.getSheet(1);
            Range[] ranges = sheet.getMergedCells();
            outer:for (int i =1; i < sheet.getRows(); i++) {// 单一商品
                Cell cell = sheet.getCell(9,i);
                inner:for(Range range:ranges){
                    if (i>=range.getTopLeft().getRow() && i<=range.getBottomRight().getRow()){
                        continue outer ;  //判断为合并单元格，即跳出
                    }
                }
                List<PurOrderItem> purOrderItems = new ArrayList<PurOrderItem>();
                String goodNo = sheet.getCell(7,i).getContents();
                String price = sheet.getCell(8,i).getContents();
                String num = sheet.getCell(9,i).getContents();
                String total = sheet.getCell(10,i).getContents();
                purOrderItems.add(new PurOrderItem(goodNo,price,num,total));

                String type = sheet.getCell(1,i).getContents();
                String supplier = sheet.getCell(2,i).getContents();
                String payMethod = sheet.getCell(3,i).getContents();
                String curreny = sheet.getCell(4,i).getContents();
                String rate = sheet.getCell(5,i).getContents();
                long deliverTime = UtilTime.getTime("yyyy.MM.dd",sheet.getCell(6,i).getContents());
                PurchaseOrder purchaseOrder = new PurchaseOrder(purOrderItems,supplier,curreny,deliverTime,payMethod,type,rate);
//                    System.out.println(JSON.toJSON(purchaseOrder));
                ApiClient.doPostJson(BaseParam.PURCHASE_ADD,null, Cookie.getCookie(),purchaseOrder);
            }
            for(int m=0;m<ranges.length/7;m++){// 多商品
                Range range = ranges[m];
                int index = range.getTopLeft().getRow();
                String type = sheet.getCell(1,index).getContents();
                String supplier = sheet.getCell(2,index).getContents();
                String payMethod = sheet.getCell(3,index).getContents();
                String curreny = sheet.getCell(4,index).getContents();
                String rate = sheet.getCell(5,index).getContents();
                long deliverTime = UtilTime.getTime("yyyy.MM.dd",sheet.getCell(6,index).getContents());

                List<PurOrderItem> purOrderItems = new ArrayList<PurOrderItem>();
                for(int i=index;i<=range.getBottomRight().getRow();i++){
                    String goodNo = sheet.getCell(7,i).getContents();
                    String price = sheet.getCell(8,i).getContents();
                    String num = sheet.getCell(9,i).getContents();
                    String total = sheet.getCell(10,i).getContents();
                    purOrderItems.add(new PurOrderItem(goodNo,price,num,total));
                }
                PurchaseOrder purchaseOrder = new PurchaseOrder(purOrderItems,supplier,curreny,deliverTime,payMethod,type,rate);
//                System.out.println(JSON.toJSON(purchaseOrder));
                ApiClient.doPostJson(BaseParam.PURCHASE_ADD,null, Cookie.getCookie(),purchaseOrder);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}