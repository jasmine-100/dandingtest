package api;

import client.ApiClient;
import jxc.BaseParam;
import domain.Item;
import domain.Order;
import domainout.*;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.jupiter.api.Test;
import sun.security.provider.SHA;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author： jasmine
 * @Description : CCS申报单完整流程：推送申报单--申报订单-申报清单--回执电子税单
 * @Date : Created in 2020/7/20 12:23
 */
public class OrderAutoApi {
    // 推送申报单
    @Test
    public void pushOrder(){
        try {
            Workbook workbook = Workbook.getWorkbook(new File(Data.FILEPATH));
            Sheet sheet = workbook.getSheet(1);
            Range[] ranges = sheet.getMergedCells();

            outer:for(int i=1;i<sheet.getRows();i++){  //单一商品申报单
                inner:for(Range range:ranges){
                    if(i>=range.getTopLeft().getRow() && i<=range.getBottomRight().getRow()){
                        continue outer;
                    }
                }
                List<Item> items = new ArrayList<Item>();
                String productId = sheet.getCell(5,i).getContents();
                String sku = sheet.getCell(6,i).getContents();
                String price = sheet.getCell(7,i).getContents();
                String num = sheet.getCell(8,i).getContents();
                items.add(new Item(productId,sku,num,price));

                String outOrderNo = sheet.getCell(0,i).getContents();
                String declareOrderno = sheet.getCell(1,i).getContents();
                String routeCode = sheet.getCell(2,i).getContents();
                String expressCode = sheet.getCell(3,i).getContents();
                String logiticsNo = sheet.getCell(4,i).getContents();
                Order order = new Order("xiaoyuer","小鱼儿",outOrderNo,declareOrderno,expressCode,logiticsNo,routeCode,items);
                //接口：推送申报单
                ApiClient.doPostJson(BaseParam.URL_ORDER,null,null,order);

                dingdanBack(declareOrderno);
                qingdanBack(declareOrderno);
            }

            for(int i=0;i<ranges.length/5;i++){ //多商品申报单
                Range range = ranges[i];
                int index = range.getTopLeft().getRow();
                // 组装商品项
                List<Item> items = new ArrayList<Item>();
                for(int j=index;j<=range.getBottomRight().getRow();j++){
                    String productId = sheet.getCell(5,j).getContents();
                    String sku = sheet.getCell(6,j).getContents();
                    String price = sheet.getCell(7,j).getContents();
                    String num = sheet.getCell(8,j).getContents();
                    items.add(new Item(productId,sku,num,price));
                }
                // 组装申报单
                String outOrderNo = sheet.getCell(0,index).getContents();
                String declareOrderno = sheet.getCell(1,index).getContents();
                String routeCode = sheet.getCell(2,index).getContents();
                String expressCode = sheet.getCell(3,index).getContents();
                String logiticsNo = sheet.getCell(4,index).getContents();
                Order order = new Order("xiaoyuer","小鱼儿",outOrderNo,declareOrderno,expressCode,logiticsNo,routeCode,items);
                //接口：推送申报单
                ApiClient.doPostJson(BaseParam.URL_ORDER,null,null,order);

                dingdanBack(declareOrderno);
                qingdanBack(declareOrderno);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void dingdanBack(String orderno){
        try {
            // 口岸：处理成功
            BackDingdanKouan.backPass(orderno,"2020-8-06");
            Thread.sleep(1000);
            // 总署：逻0辑校验通过
            BackDingdanZongshu.logicOk(orderno, Data.ebpCode,Data.ebcCode,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            Thread.sleep(1000);
            // 总署:新增申报成功
            BackDingdanZongshu.declareAddOk(orderno,Data.ebpCode,Data.ebcCode,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 步骤三：清单申报回执
     */
    public void qingdanBack(String declareOrderNo) {
        try {
            // 回执清单号
            String invtNo = "QD"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

            //回执逻辑校验通过报文
            //回传时间格式：年月日时分秒毫秒
            BackQingdanZongshu.backLogic(declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,invtNo,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            Thread.sleep(1000);

            // 回执新增申报成功报文
            BackQingdanZongshu.backAddOk(declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,invtNo,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
            Thread.sleep(1000);

            //回执放行报文
            BackQingdanZongshu.backPass(declareOrderNo,Data.ebpCode,Data.ebcCode,Data.agentCode,invtNo,"20200916110030001");
            Thread.sleep(1000);

            // 回执：税金
            BackTax.backTaxrd(invtNo,100,5.2,3.6,new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
