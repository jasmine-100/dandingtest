package qimen.jxc.apiauto;

import client.ApiClient;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.jupiter.api.Test;
import qimen.domain.Param;
import qimen.domain.stockin.EntryOrder;
import qimen.domain.stockin.OrderData;
import qimen.domain.stockin.OrderLine;
import qimen.jxc.api.Data;
import utils.XmlUtil;
import wms.domain.ParamsWms;
import wms.domain.deliver.Product;
import wms.domain.stockin.StockinData;
import wms.jxc.BaseParams;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/23 17:21
 */
public class StockinDiaobo {

    // 采购入库单
    @Test
    public void orderPurchase() throws Exception {
        Workbook workbook = Workbook.getWorkbook(new File(Data.FILEPATH));
        Sheet sheet = workbook.getSheet(0);
        Range[] ranges = sheet.getMergedCells();

        outer:for (int i=1;i<sheet.getRows();i++){
            inner:for(Range range:ranges){
                if(i>=range.getTopLeft().getRow() && i<=range.getBottomRight().getRow()){
                    continue outer;
                }
            }
            List<OrderLine> orderLines = new ArrayList<>();
            String sku = sheet.getCell(2,i).getContents();
            int num = Integer.parseInt(sheet.getCell(3,i).getContents());
            orderLines.add(new OrderLine(sku, num, ""));

            String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            String whCode = sheet.getCell(0,i).getContents();
            String supplier = sheet.getCell(1,i).getContents();
            EntryOrder entryOrder = new EntryOrder(orderno,whCode, "DBRK", supplier);
            OrderData orderData = new OrderData(entryOrder, orderLines);
            ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
        }

        for(int i=0;i<ranges.length/2;i++){
            Range range = ranges[i*2];
            int index = range.getTopLeft().getRow();

            List<OrderLine> orderLines = new ArrayList<>();
            for(int j=index;j<=range.getBottomRight().getRow();j++){
                String sku = sheet.getCell(2,j).getContents();
                int num = Integer.parseInt(sheet.getCell(3,j).getContents());
                orderLines.add(new OrderLine(sku, num, ""));
            }

            String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            String whCode = sheet.getCell(0,index).getContents();
            String supplier = sheet.getCell(1,index).getContents();
            EntryOrder entryOrder = new EntryOrder(orderno,whCode, "DBRK", supplier);
            OrderData orderData = new OrderData(entryOrder, orderLines);
            ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
        }
    }

    @Test
    public void wmsBack(){
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
                StockinData stockinData = new StockinData(orderId, "GLB",BaseParams.hzid,"DBRKD",confirm,batchNo,products);
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
                StockinData stockinData = new StockinData(orderId, "GLB",BaseParams.hzid,"DBRKD",confirm,batchNo,products);
                ParamsWms paramsWms = new ParamsWms(XmlUtil.objToXml(stockinData),"wms.stockin.update", "1.0");
                ApiClient.doPostForm(BaseParams.URL_BACK,null,null,paramsWms);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
