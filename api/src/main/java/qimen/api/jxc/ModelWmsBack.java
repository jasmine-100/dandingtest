package qimen.api.jxc;

import client.ApiClient;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.DeliverData;
import wms.domain.deliver.Product;
import wms.domain.outbound.OutboundData;
import wms.domain.stockin.StockinData;
import wms.jxc.BaseParams;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/24 15:10
 */
public class ModelWmsBack {

    // 入库单回执
    public static void backStockin(String billType){
        try {
            Sheet sheet = Workbook.getWorkbook(new File(Data.FILEPATH)).getSheet(1);
            Range[] ranges = sheet.getMergedCells();

            // 回执单一商品
            outer:for (int i = 1; i < sheet.getRows(); i++) {
                inner:for (Range range : ranges) {
                    if (i >= range.getTopLeft().getRow() && i <= range.getBottomRight().getRow()) {
                        continue outer;
                    }
                }
                List<Product> products = new LinkedList<>();
                String sku = sheet.getCell(3,i).getContents();
                int num = Integer.parseInt(sheet.getCell(4,i).getContents());
                String batchCode = sheet.getCell(5,i).getContents();
                String batchValue1 = sheet.getCell(6,i).getContents();
                String batchValue2 = sheet.getCell(7,i).getContents();
                String inventoryType = sheet.getCell(8,i).getContents();
                products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));

                String orderId = sheet.getCell(0,i).getContents();
                int batchNo = Integer.parseInt(sheet.getCell(1,i).getContents());
                int confirm = Integer.parseInt(sheet.getCell(2,i).getContents());
                StockinData stockinData = new StockinData(orderId, "GLB", BaseParams.hzid,billType,confirm,batchNo,products);
                ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");
                ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
            }

            // 回执多商品
            for(int m=0;m< ranges.length/3;m++){
                Range range = ranges[m*3];
                int index = range.getTopLeft().getRow();

                List<Product> products = new LinkedList<>();
                for (int i=index ;i<= range.getBottomRight().getRow();i++){
                    String sku = sheet.getCell(3,i).getContents();
                    int num = Integer.parseInt(sheet.getCell(4,i).getContents());
                    String batchCode = sheet.getCell(5,i).getContents();
                    String batchValue1 = sheet.getCell(6,i).getContents();
                    String batchValue2 = sheet.getCell(7,i).getContents();
                    String inventoryType = sheet.getCell(8,i).getContents();
                    products.add(new Product(sku,batchCode,num,batchValue1,batchValue2,inventoryType));
                }
                String orderId = sheet.getCell(0,index).getContents();
                int batchNo = Integer.parseInt(sheet.getCell(1,index).getContents());
                int confirm = Integer.parseInt(sheet.getCell(2,index).getContents());
                StockinData stockinData = new StockinData(orderId, "GLB",BaseParams.hzid,billType,confirm,batchNo,products);
                ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");
                ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 出库单回执：发货出库、批发出库
    public static void backStockoutOrder(){
        try {
            Sheet sheet = Workbook.getWorkbook(new File(Data.FILEPATH)).getSheet(3);
            Range[] ranges = sheet.getMergedCells();

            outer:for(int i=1;i<sheet.getRows();i++){
                inner:for (Range range: ranges){
                    if(i>= range.getTopLeft().getRow() && i<= range.getBottomRight().getRow()){
                        continue outer;
                    }
                }
                List<Product> products = new ArrayList<>();
                String sku = sheet.getCell(2,i).getContents();
                int qty = Integer.parseInt(sheet.getCell(3,i).getContents());
                String batchCode = sheet.getCell(4,i).getContents();
                String batchValue1 = sheet.getCell(5,i).getContents();
                String batchValue2 = sheet.getCell(6,i).getContents();
                String inventoryType = sheet.getCell(7,i).getContents();
                products.add(new Product(sku, batchCode, qty, batchValue1, batchValue2, inventoryType));

                String orderId = sheet.getCell(0,i).getContents();
                String expressCode = sheet.getCell(1,i).getContents();
                DeliverData deliverData = new DeliverData(orderId,"GLB", expressCode, 1.68, BaseParams.hzid, products);
                ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), "wms.saleorderinfo.update", "1.0");
                ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
            }

            for(int m=0;m<ranges.length/2;m++){
                Range range = ranges[m*2];
                int index = range.getTopLeft().getRow();

                List<Product> products = new ArrayList<>();
                for(int i= index;i<=range.getBottomRight().getRow();i++){
                    String sku = sheet.getCell(2,i).getContents();
                    int qty = Integer.parseInt(sheet.getCell(3,i).getContents());
                    String batchCode = sheet.getCell(4,i).getContents();
                    String batchValue1 = sheet.getCell(5,i).getContents();
                    String batchValue2 = sheet.getCell(6,i).getContents();
                    String inventoryType = sheet.getCell(7,i).getContents();
                    products.add(new Product(sku, batchCode, qty, batchValue1, batchValue2, inventoryType));
                }

                String orderId = sheet.getCell(0,index).getContents();
                String expressCode = sheet.getCell(1,index).getContents();
                DeliverData deliverData = new DeliverData(orderId,"GLB", expressCode, 1.68, BaseParams.hzid, products);
                ParamsWms param = new ParamsWms(XmlUtil.objToXml(deliverData), "wms.saleorderinfo.update", "1.0");
                ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 出库单回执：调拨
    public static void backStockoutDiaobo(){
        try {
            Sheet sheet = Workbook.getWorkbook(new File(Data.FILEPATH)).getSheet(3);
            Range[] ranges = sheet.getMergedCells();

            outer:for(int i=1;i<sheet.getRows();i++){
                inner:for (Range range: ranges){
                    if(i>= range.getTopLeft().getRow() && i<= range.getBottomRight().getRow()){
                        continue outer;
                    }
                }

                List<Product> products = new ArrayList<>();
                String sku = sheet.getCell(2,i).getContents();
                int qty = Integer.parseInt(sheet.getCell(3,i).getContents());
                String batchCode = sheet.getCell(4,i).getContents();
                String batchValue1 = sheet.getCell(5,i).getContents();
                String batchValue2 = sheet.getCell(6,i).getContents();
                String inventoryType = sheet.getCell(7,i).getContents();
                products.add(new Product(sku, batchCode, qty, batchValue1, batchValue2, inventoryType));

                String orderId = sheet.getCell(0,i).getContents();
                String expressCode = sheet.getCell(1,i).getContents();
                OutboundData outboundData = new OutboundData(orderId, "GLB", BaseParams.hzid,expressCode,"DBCKD",1.68 ,products);
                ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), "wms.saleorderinfo.update", "1.0");
                ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
            }

            for(int m=0;m<ranges.length/2;m++){
                Range range = ranges[m*2];
                int index = range.getTopLeft().getRow();

                List<Product> products = new ArrayList<>();
                for(int i= index;i<=range.getBottomRight().getRow();i++){
                    String sku = sheet.getCell(2,i).getContents();
                    int qty = Integer.parseInt(sheet.getCell(3,i).getContents());
                    String batchCode = sheet.getCell(4,i).getContents();
                    String batchValue1 = sheet.getCell(5,i).getContents();
                    String batchValue2 = sheet.getCell(6,i).getContents();
                    String inventoryType = sheet.getCell(7,i).getContents();
                    products.add(new Product(sku, batchCode, qty, batchValue1, batchValue2, inventoryType));
                }

                String orderId = sheet.getCell(0,index).getContents();
                String expressCode = sheet.getCell(1,index).getContents();
                OutboundData outboundData = new OutboundData(orderId, "GLB", BaseParams.hzid,expressCode,"DBCKD",1.68 ,products);
                ParamsWms param = new ParamsWms(XmlUtil.objToXml(outboundData), "wms.saleorderinfo.update", "1.0");
                ApiClient.doPostForm(BaseParams.URL_BACK,null,null,param);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
