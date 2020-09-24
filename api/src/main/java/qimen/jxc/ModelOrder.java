package qimen.jxc;

import client.ApiClient;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import qimen.domain.Param;
import qimen.domain.deliver.DeliveryOrder;
import qimen.domain.deliver.OrderLine;
import qimen.domain.deliver.ReceiverInfo;
import qimen.domain.deliver.RequestOrderDeliver;
import qimen.domain.returnorder.RequestOrderReturn;
import qimen.domain.returnorder.ReturnOrder;
import qimen.domain.stockin.EntryOrder;
import qimen.domain.stockin.OrderData;
import qimen.domain.stockin.SenderInfo;
import utils.XmlUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2020/9/24 15:17
 */
public class ModelOrder {

    // 推送出库单：发货出库、批发出库、调拨出库
    public static void orderStockout(String orderType, String expressCode){
        try {
            Sheet sheet = Workbook.getWorkbook(new File(Data.FILEPATH)).getSheet(2);
            Range[] ranges = sheet.getMergedCells();

            outer:for (int i=1;i<sheet.getRows();i++){
                inner:for (Range range:ranges){
                    if(i>= range.getTopLeft().getRow() && i<= range.getBottomRight().getRow()){
                        continue outer;
                    }
                }
                List<OrderLine> orderLines = new ArrayList<>();
                String sku = sheet.getCell(2,i).getContents();
                int qty = Integer.parseInt(sheet.getCell(3,i).getContents());
                String batchCode = sheet.getCell(4,i).getContents();
                orderLines.add(new OrderLine("",sku,qty,batchCode));

                String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String whCode = sheet.getCell(0,i).getContents();
                String shopNick = sheet.getCell(1,i).getContents();
                DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,orderType,whCode, shopNick,orderLines,expressCode,new SenderInfo(),new ReceiverInfo());

                RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);
                ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
            }

            for (int m=0;m<ranges.length/2;m++){
                Range range = ranges[m*2];
                int index = range.getTopLeft().getRow();

                List<OrderLine> orderLines = new ArrayList<>();
                for(int i=index;i<=range.getBottomRight().getRow();i++){
                    String sku = sheet.getCell(2,i).getContents();
                    int qty = Integer.parseInt(sheet.getCell(3,i).getContents());
                    String batchCode = sheet.getCell(4,i).getContents();
                    orderLines.add(new OrderLine("",sku,qty,batchCode));
                }

                String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String whCode = sheet.getCell(0,index).getContents();
                String shopNick = sheet.getCell(1,index).getContents();
                DeliveryOrder deliveryOrder = new DeliveryOrder(orderno,"JYCK",whCode, shopNick,orderLines,expressCode,new SenderInfo(),new ReceiverInfo());

                RequestOrderDeliver deliverData = new RequestOrderDeliver(deliveryOrder,orderLines);
                ApiClient.doPostXml(Data.url,new Param("deliveryorder.create",Data.customerId),null, XmlUtil.objToXml(deliverData));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 入库单：采购、调拨
    public static void stockinPurchaseDiaobo(String billType)  {
        try {
            Sheet sheet = Workbook.getWorkbook(new File(Data.FILEPATH)).getSheet(0);
            Range[] ranges = sheet.getMergedCells();

            outer:for (int i=1;i<sheet.getRows();i++){
                inner:for(Range range:ranges){
                    if(i>=range.getTopLeft().getRow() && i<=range.getBottomRight().getRow()){
                        continue outer;
                    }
                }
                List<qimen.domain.stockin.OrderLine> orderLines = new ArrayList<>();
                String sku = sheet.getCell(2,i).getContents();
                int num = Integer.parseInt(sheet.getCell(3,i).getContents());
                orderLines.add(new qimen.domain.stockin.OrderLine(sku, num, ""));

                String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String whCode = sheet.getCell(0,i).getContents();
                String supplier = sheet.getCell(1,i).getContents();
                EntryOrder entryOrder = new EntryOrder(orderno,whCode, billType, supplier);
                OrderData orderData = new OrderData(entryOrder, orderLines);
                ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
            }

            for(int i=0;i<ranges.length/2;i++){
                Range range = ranges[i*2];
                int index = range.getTopLeft().getRow();

                List<qimen.domain.stockin.OrderLine> orderLines = new ArrayList<>();
                for(int j=index;j<=range.getBottomRight().getRow();j++){
                    String sku = sheet.getCell(2,j).getContents();
                    int num = Integer.parseInt(sheet.getCell(3,j).getContents());
                    orderLines.add(new qimen.domain.stockin.OrderLine(sku, num, ""));
                }

                String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String whCode = sheet.getCell(0,index).getContents();
                String supplier = sheet.getCell(1,index).getContents();
                EntryOrder entryOrder = new EntryOrder(orderno,whCode, billType, supplier);
                OrderData orderData = new OrderData(entryOrder, orderLines);
                ApiClient.doPostXml(Data.url, new Param("entryorder.create", Data.customerId), null, XmlUtil.objToXml(orderData));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 入库：退货
    public static void stockinTuihuo() {
        try {
            Sheet sheet  = Workbook.getWorkbook(new File(Data.FILEPATH)).getSheet(0);
            Range[] ranges = sheet.getMergedCells();

            outer:for (int i=1;i<sheet.getRows();i++){
                inner:for(Range range:ranges){
                    if(i>=range.getTopLeft().getRow() && i<=range.getBottomRight().getRow()){
                        continue outer;
                    }
                }
                List<qimen.domain.stockin.OrderLine> orderLines = new ArrayList<>();
                String sku = sheet.getCell(2,i).getContents();
                int num = Integer.parseInt(sheet.getCell(3,i).getContents());
                orderLines.add(new qimen.domain.stockin.OrderLine("",sku,num,"",""));

                String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String whCode = sheet.getCell(0,i).getContents();
                ReturnOrder returnOrder = new ReturnOrder(orderno,whCode,"THRK","",new SenderInfo("浙江省","杭州市","西湖区"));
                // 组装body消息体
                RequestOrderReturn request = new RequestOrderReturn(returnOrder,orderLines);
                ApiClient.doPostXml(Data.url,new Param("returnorder.create",Data.customerId),null, XmlUtil.objToXml(request));
            }

            for(int m=0;m<ranges.length/2;m++){
                Range range = ranges[m*2];
                int index = range.getTopLeft().getRow();

                List<qimen.domain.stockin.OrderLine> orderLines = new ArrayList<>();
                for(int i=index;i<=range.getBottomRight().getRow();i++){
                    String sku = sheet.getCell(2,i).getContents();
                    int num = Integer.parseInt(sheet.getCell(3,i).getContents());
                    orderLines.add(new qimen.domain.stockin.OrderLine("",sku,num,"",""));
                }

                String orderno = "QM"+new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
                String whCode = sheet.getCell(0,index).getContents();
                ReturnOrder returnOrder = new ReturnOrder(orderno,whCode,"THRK","",new SenderInfo("浙江省","杭州市","西湖区"));
                // 组装body消息体
                RequestOrderReturn request = new RequestOrderReturn(returnOrder,orderLines);
                ApiClient.doPostXml(Data.url,new Param("returnorder.create",Data.customerId),null, XmlUtil.objToXml(request));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
