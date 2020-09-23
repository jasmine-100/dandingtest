package casetest;

import client.ApiClient;
import com.alibaba.fastjson.JSONObject;
import domainout.stockin.PurOrderItem;
import domainout.stockin.PurchaseOrder;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.jupiter.api.Test;
import utils.ExcelUtils;
import utils.UtilTime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 未完成
 * @Date : Created in 2020/8/26 16:18
 */
public class PurchaseApi {

    // 采购单
    @Test
    public void purchaseAdd() {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(Data.FILEPATH));
            Sheet sheet = workbook.getSheet(1);
            Range[] ranges = sheet.getMergedCells();

            outer:for (int i =1; i <sheet.getRows(); i++) {// 单一商品
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
                String response = ApiClient.doPostJson(Data.PURCHASE_ADD,null, Data.getCookie(),purchaseOrder);
                // 获取采购单号
                String purchaseId = getPurchaseId(response);
                // 写入采购单号
                ExcelUtils.writeExcel(Data.FILEPATH,1,i,0,purchaseId);
                // 审核
                examine(purchaseId);
            }

            for(int m=0;m<ranges.length/7;m++) {// 多商品
                Range range = ranges[m];
                int index = range.getTopLeft().getRow();
                String type = sheet.getCell(1, index).getContents();
                String supplier = sheet.getCell(2, index).getContents();
                String payMethod = sheet.getCell(3, index).getContents();
                String curreny = sheet.getCell(4, index).getContents();
                String rate = sheet.getCell(5, index).getContents();
                long deliverTime = UtilTime.getTime("yyyy.MM.dd", sheet.getCell(6, index).getContents());

                List<PurOrderItem> purOrderItems = new ArrayList<PurOrderItem>();
                for (int i = index; i <= range.getBottomRight().getRow(); i++) {
                    String goodNo = sheet.getCell(7, i).getContents();
                    String price = sheet.getCell(8, i).getContents();
                    String num = sheet.getCell(9, i).getContents();
                    String total = sheet.getCell(10, i).getContents();
                    purOrderItems.add(new PurOrderItem(goodNo, price, num, total));
                }
                PurchaseOrder purchaseOrder = new PurchaseOrder(purOrderItems, supplier, curreny, deliverTime, payMethod, type, rate);
//                System.out.println(JSON.toJSON(purchaseOrder));
                String response = ApiClient.doPostJson(Data.PURCHASE_ADD, null, Data.getCookie(), purchaseOrder);
                // 获取采购单号
                String purchaseId = getPurchaseId(response);
                // 写入采购单号
                ExcelUtils.writeExcel(Data.FILEPATH,1,index,0,purchaseId);
                // 审核
                examine(purchaseId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 获取采购单号
    public String getPurchaseId(String response){
        // 获取采购单号
        JSONObject jsonObject = (JSONObject) JSONObject.parse(response);
        JSONObject object = (JSONObject) jsonObject.get("result");
        String purchaseId = (String) object.get("purOrderId");
        return purchaseId;
    }

    // 采购单审核通过
    public static void examine(String purchaseId){
        ApiClient.doPostForm(Data.PURCHASE_EXAMINE+"?purOrderId="+purchaseId,null, Data.getCookie(),null);
    }

}