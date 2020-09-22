package casetest;

import client.ApiClient;
import com.alibaba.fastjson.JSONObject;
import domainout.stockin.PurOrderItem;
import domainout.stockin.PurchaseOrder;
import domainout.stockin.StoOrderItem;
import domainout.stockin.StockinOrder;
import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.jupiter.api.Test;
import utils.UtilTime;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : 未完成
 * @Date : Created in 2020/8/26 16:18
 */
public class PurchaseApi {

    @Test
    public void test(){
        purchaseAdd();
        purchaseAdds();
    }

    // 单一商品采购单
    @Test
    public void purchaseAdd() {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(BaseParam.FILEPATH));
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
                String response = ApiClient.doPostJson(BaseParam.PURCHASE_ADD,null, BaseParam.getCookie(),purchaseOrder);

                // 审核
                ApiClient.doPostForm(BaseParam.PURCHASE_EXAMINE+"?purOrderId="+getPurchaseId(response),null, BaseParam.getCookie(),null);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 多商品订单
    @Test
    public void purchaseAdds(){
        try {
            Workbook workbook = Workbook.getWorkbook(new File(BaseParam.FILEPATH));
            Sheet sheet = workbook.getSheet(1);
            Range[] ranges = sheet.getMergedCells();
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
                String response = ApiClient.doPostJson(BaseParam.PURCHASE_ADD, null, BaseParam.getCookie(), purchaseOrder);
                // 审核
                ApiClient.doPostForm(BaseParam.PURCHASE_EXAMINE+"?purOrderId="+getPurchaseId(response),null, BaseParam.getCookie(),null);
            }
        } catch (Exception e) {
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
        ApiClient.doPostForm(BaseParam.PURCHASE_EXAMINE+"?purOrderId="+purchaseId,null, BaseParam.getCookie(),null);
    }

}